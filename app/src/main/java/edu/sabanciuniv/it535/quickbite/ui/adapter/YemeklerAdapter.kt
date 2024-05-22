package edu.sabanciuniv.it535.quickbite.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.sabanciuniv.it535.quickbite.data.entity.Yemekler
import edu.sabanciuniv.it535.quickbite.databinding.YemeklerListItemDesignBinding

class YemeklerAdapter(var mContext: Context, var yemeklerList: List<Yemekler>)
    : RecyclerView.Adapter<YemeklerAdapter.ConversationListItemDesignHolder>(){


    inner class ConversationListItemDesignHolder(var design: YemeklerListItemDesignBinding)
        : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ConversationListItemDesignHolder {
        val binding = YemeklerListItemDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ConversationListItemDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: ConversationListItemDesignHolder, position: Int) {

        val yemekler = yemeklerList.get(position)
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemekler.yemek_resim_adi}"

        val d = holder.design

        Glide.with(mContext).load(url).override(48,48).into(d.iconView)
        d.TitleTextView.text = yemekler.yemek_adi
        d.PriceTextView.text = buildString {
            append(yemekler.yemek_fiyat.toString())
            append(" ₺")
        }

    }

    override fun getItemCount(): Int {
        return yemeklerList.size
    }

}