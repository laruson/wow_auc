package com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters

import andrey.chernikovich.domain.entity.BaseItem
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.presenter.utils.picasso.setImage
import kotlinx.android.synthetic.main.item_item.view.*

class GroupListAdapter: RecyclerView.Adapter<GroupListAdapter.Holder>() {

    private var items: List<BaseItem> = emptyList()
    private lateinit var onItemClick : (BaseItem) -> Unit
    private lateinit var onLongItemClick :  (BaseItem) -> Unit

    fun setItems(items: List<BaseItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setLongClicker(onLongItemClick:  (BaseItem) -> Unit){
        this.onLongItemClick = onLongItemClick
    }

    fun setClicker(onItemClick: (BaseItem) -> Unit){
        this.onItemClick=onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListAdapter.Holder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_my_group_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: GroupListAdapter.Holder, position: Int) {
        val item = items[position]

        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        holder.itemView.isLongClickable=true
        holder.itemView.setOnLongClickListener {
            onItemClick(item)
            true
        }
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BaseItem){
            itemView.nameItemt.text=item.name
            setImage(item.image,
                    itemView.imageItem,
                    itemView.progressItem)
        }
    }
}