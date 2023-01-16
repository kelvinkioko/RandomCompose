package com.graph.randomcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateComposeViewModel: ViewModel() {

    private val _nameState = MutableLiveData("")
    val nameState: LiveData<String> = _nameState

    fun onNameChanged(newName: String) {
        _nameState.value = newName
    }

}