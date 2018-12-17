package com.gmail.chernikovich.wow_auctionator.presentation.base.recycler

import android.support.v7.widget.RecyclerView
import io.reactivex.subjects.PublishSubject

abstract class BaseRecyclerAdapter<
        Entity,
        VM : BaseRecyclerViewModel<Entity>>
(val itemList: MutableList<Entity> = mutableListOf())
    : RecyclerView.Adapter<BaseViewHolder<Entity, VM, *>>() {

    val clickItemSubject = PublishSubject.create<ItemClick<Entity>>()

    override fun onBindViewHolder(holder: BaseViewHolder<Entity, VM, *>, position: Int) {
        holder.bind(itemList[position], position)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onViewAttachedToWindow(holder: BaseViewHolder<Entity, VM, *>) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            clickItemSubject.onNext(ItemClick(itemList[position], position))
            holder.viewModel.onItemClick()
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<Entity, VM, *>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun addItems(items: List<Entity>) {
        val startPos = itemList.size
        itemList.addAll(items)
        notifyItemRangeChanged(startPos, items.size)
    }

    fun setItems(items: List<Entity>){
        cleanItems()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    fun cleanItems() {
        itemList.clear()
        notifyDataSetChanged()
    }

    fun removeItem(entity: Entity){
        itemList.remove(entity)
        notifyDataSetChanged()
    }

}