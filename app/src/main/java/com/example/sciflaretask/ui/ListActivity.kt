package com.example.sciflaretask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.room.Room
import com.example.sciflaretask.databinding.ActivityListBinding
import com.example.sciflaretask.repository.local.UserDB
import com.example.sciflaretask.utils.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private var _binding: ActivityListBinding? = null

    private val mBinding get() = _binding!!

    private val mViewModel: ListViewModel by viewModels()

    @Inject
    lateinit var mAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        _binding = ActivityListBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        mBinding.recyclerView.adapter = mAdapter

        addDataObserver()

        loadData()

        mBinding.swipeRefreshLayout.setOnRefreshListener {

            loadData()

        }

    }

    private fun loadData(){

        if (NetworkUtils.isNetworkAvailable(this)) mViewModel.getUserList()
        else mViewModel.getLocalUserList()

    }

    override fun onResume() {

        super.onResume()

        mViewModel.getLocalUserList()

    }

    private fun addDataObserver() {

        mViewModel.userListLiveData.observe(this) { userList ->

            mAdapter.setData(userList = userList)

            mBinding.swipeRefreshLayout.isRefreshing = false

        }

        mViewModel.isLoading.observe(this) { isLoading ->

            mBinding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE

        }

    }

}