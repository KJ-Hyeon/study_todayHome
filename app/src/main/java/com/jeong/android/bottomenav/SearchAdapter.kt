package com.jeong.android.bottomenav

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.bottomenav.databinding.ItemSearchBinding

class SearchAdapter(private val data: ArrayList<Search>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addKeyword(keyword: String){
        // 만약에 중복이 된 키워드가 있으면 해당 키워드를 맨 앞으로 다시 배열
        var check = data.contains(Search(keyword))
        if(!check) {
            data.add(Search(keyword))
            notifyDataSetChanged()
        } else {
            data.remove(Search(keyword))
            data.add(0,Search(keyword))
            notifyDataSetChanged()
        }
        //sharedPreference
        saveKeyword()
    }

    fun saveKeyword(): ArrayList<Search>{
        return data
    }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    class SearchViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(search : Search){
            binding.searchContent.text = search.content
        }
    }
}