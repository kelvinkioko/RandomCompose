package com.graph.randomcompose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateComposeViewModel: ViewModel() {

    val textFieldState = MutableLiveData("")

    fun onNameChanged(newName: String) {
        textFieldState.value = newName
    }

}