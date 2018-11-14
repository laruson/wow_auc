package com.gmail.chernikovich.wow_auctionator.presenter.utils.adapters

import andrey.chernikovich.domain.entity.BaseItem
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.chernikovich.wow_auctionator.R
import com.gmail.chernikovich.wow_auctionator.generated.callback.OnClickListener
import com.gmail.chernikovich.wow_auctionator.presenter.utils.picasso.setImage
import kotlinx.android.synthetic.main.item_item.view.*

class ItemsListAdapter() : RecyclerView.Adapter<ItemsListAdapter.Holder>() {
    private var items: List<BaseItem> = emptyList()
    private lateinit var onItemClick : (BaseItem) -> Unit

    fun setItems(items: List<BaseItem>) {
        this.items = items
    }

    fun setClicker(onItemClick: (BaseItem) -> Unit){
        this.onItemClick=onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BaseItem){
            itemView.nameItemt.text=item.name
            setImage(item.image,
                    itemView.imageItem,
                    itemView.progressItem)
        }
    }
}