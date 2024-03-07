package com.example.sciflaretask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sciflaretask.model.DBModel
import com.example.sciflaretask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _isLoading : MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val isLoading get() = _isLoading

    private val _userListLiveData : MutableLiveData<List<DBModel.User>> by lazy { MutableLiveData() }
    val userListLiveData get() = _userListLiveData


    fun getUserList(){

        _isLoading.postValue(true)

        viewModelScope.launch(Dispatchers.IO) {

            _userListLiveData.postValue(repository.getUserList())

            _isLoading.postValue(false)

        }

    }

    fun getLocalUserList(){

        _isLoading.postValue(true)

        viewModelScope.launch(Dispatchers.IO) {

            _userListLiveData.postValue(repository.getLocalUserList() as ArrayList<DBModel.User>?)

            _isLoading.postValue(false)

        }

    }

}