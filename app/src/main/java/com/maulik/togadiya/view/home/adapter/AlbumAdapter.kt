package com.maulik.togadiya.view.home.adapter

import android.view.View
import com.maulik.togadiya.R
import com.maulik.togadiya.base.BaseRecyclerAdapter
import com.maulik.togadiya.databinding.ItemAlbumBinding
import com.maulik.togadiya.model.AlbumData
import com.maulik.togadiya.utils.IAdapterOnClick


class AlbumAdapter(private val listener: IAdapterOnClick) :
    BaseRecyclerAdapter<AlbumData>() {
    override fun getLayoutIdForType(viewType: Int): Int {
        return R.layout.item_album
    }


    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        (binding as ItemAlbumBinding).ivArticleImage.setOnClickListener(holder)
    }


    override fun areItemsSame(
        oldItem: AlbumData,
        newItem: AlbumData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun onItemClick(view: View?, item: AlbumData, adapterPosition: Int) {
        listener.onClick(view, item, adapterPosition)
    }

    override fun areContentsTheSame(
        oldItem: AlbumData,
        newItem: AlbumData
    ): Boolean {
        return oldItem.id == newItem.id
    }
}