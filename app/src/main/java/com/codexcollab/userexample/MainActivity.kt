package com.codexcollab.userexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codexcollab.userexample.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setDefault()
        callAPI()
    }

    private fun setDefault() {
        binding.message.showView()
        binding.message.text = getString(R.string.loading)
    }

    private fun callAPI() {
        viewModel.fetchData()
        viewModel.data.observe(this) {
            if (it.isNotEmpty()) {
                showList(it)
            }else {
                hideList()
            }
        }
    }

    private fun showList(list: ArrayList<User>) {
        binding.message.goneView()
        val userAdapter = UserAdapter(this)
        binding.userRecycler.apply {
          adapter = userAdapter
        }
        userAdapter.fillUsers(list)
    }

    private fun hideList() {
        binding.userRecycler.goneView()
        binding.message.text = getString(R.string.no_data)
    }
}