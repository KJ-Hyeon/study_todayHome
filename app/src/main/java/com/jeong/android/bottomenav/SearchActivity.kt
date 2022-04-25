package com.jeong.android.bottomenav

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeong.android.bottomenav.databinding.ActivitySearchBinding
import org.json.JSONArray

class SearchActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private val keyword_list = ArrayList<Search>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getPreferences(Context.MODE_PRIVATE)
        editor = pref.edit()

        val getShared = pref.getString("keywords", null)
        getShared?.let{
            var arr_json = JSONArray(it)
            for (i in 0 until arr_json.length()) {
                keyword_list.add(Search(arr_json.optString(i)))
                //Search(arr_json.optString(i))의 형태가 이상하다.
            }
        }
        val adapter = SearchAdapter(keyword_list)
        binding.searchRev.adapter = adapter

        if (keyword_list.isNullOrEmpty()) {
            binding.searchDelete.visibility = View.INVISIBLE
            binding.searchRev.visibility = View.INVISIBLE
        }

        binding.cancleText.setOnClickListener {
            finish()
        }

        binding.searchView.setOnKeyListener { view, keyCode, keyEvent ->
            if ((keyEvent.action == KeyEvent.ACTION_DOWN) && keyCode == KeyEvent.KEYCODE_ENTER) {
                if (binding.searchRev.visibility == View.INVISIBLE) {
                    binding.searchRev.visibility = View.VISIBLE
                    binding.searchDelete.visibility = View.VISIBLE
                }
                val keywords = binding.searchView.text.toString()
                adapter.addKeyword(keywords)
                savePref(adapter.saveKeyword())
                true
            } else {
                false
            }
        }
        binding.searchDelete.setOnClickListener {
            adapter.clearData()
            editor.remove("keywords")
            editor.apply()
            binding.searchRev.visibility = View.INVISIBLE
            binding.searchDelete.visibility = View.INVISIBLE
        }
    }
    private fun savePref(data: ArrayList<Search>){
        var json_arr = JSONArray()

        for (index in 0 until data.size) {
            json_arr.put(data[index].content)
        }

        var result = json_arr.toString()

        editor.putString("keywords", result)
        editor.apply()
    }

//    override fun onResume() {
//        super.onResume()
//        if (keyword_list.isNullOrEmpty()) {
//            binding.searchRev.visibility = View.INVISIBLE
//        } else {
//            binding.searchRev.visibility = View.VISIBLE
//        }
//    }
    // 리사이클러뷰의 height를 wrap_content로 설정
}