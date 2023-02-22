package com.lee.beachcongetion.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lee.beachcongetion.R
import com.lee.beachcongetion.common.CONGEST
import com.lee.beachcongetion.common.FEW_CONGEST
import com.lee.beachcongetion.common.NORMAL
import com.lee.beachcongetion.databinding.BeachItemBinding
import com.lee.data.model.beach.BeachDTO
import com.lee.domain.model.beach.Beach

class BeachRecyclerAdapter() : RecyclerView.Adapter<BeachRecyclerAdapter.BeachViewpagerViewHolder>() {

    private var beachList = arrayListOf<Beach>()
    private var onItemClickListener : OnItemClickListener? = null

    /**
     * Interface ItemClick Listener
     * **/

    interface OnItemClickListener{
        fun onItemClick(v:View, data: Beach , pos : Int)
    }

    /**
     * Attach listener with Activity
     * **/

    fun setOnItemClickListener(listener : OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachViewpagerViewHolder {
        val binding = BeachItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return BeachViewpagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeachViewpagerViewHolder, position: Int) {
        holder.bind(beachList[position])
    }


    override fun getItemCount() = beachList.size

    fun setList(list : ArrayList<Beach>){
        beachList = list
    }

    inner class BeachViewpagerViewHolder(private val binding : BeachItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: Beach){
            with(binding){
                beachName.text = model.poiNm
                beachCongestion.text = when(model.congestion){
                    NORMAL -> {
                        with(binding){
                            beachCongestion.setTextColor(Color.parseColor("#00ff2a"))
                            congestionSmile.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24)
                        }
                        "좋음"
                    }
                    FEW_CONGEST -> {
                        with(binding){
                            beachCongestion.setTextColor(Color.parseColor("#ffe900"))
                            congestionSmile.setImageResource(R.drawable.ic_baseline_sentiment_neutral_24)
                        }

                        "보통"
                    }
                    CONGEST -> {
                        with(binding){
                            beachCongestion.setTextColor(Color.parseColor("#ff0000"))
                            congestionSmile.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                        }
                        "혼잡"
                    }
                    else -> {
                        "Error"
                    }
                }
            }
            val position = adapterPosition
            // init listeners at each viewHolders
            if(position != RecyclerView.NO_POSITION){
                itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(itemView , model , position)
                }
            }
        }

    }
}