package com.example.progica_android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.progica_android.network.Gite
import com.example.progica_android.network.GiteApi
import kotlinx.coroutines.launch

enum class GiteApiStatus {LOADING, ERROR, DONE}

class GiteViewModel: ViewModel(){

    private val _status = MutableLiveData<GiteApiStatus>()
    val status: LiveData<GiteApiStatus> = _status


    private val _gites = MutableLiveData<List<Gite>>()
    val gites : LiveData<List<Gite>> = _gites


    private val _gite = MutableLiveData<Gite>()
    val gite: LiveData<Gite> = _gite


    fun getGiteList(){
        viewModelScope.launch {
            _status.value = GiteApiStatus.LOADING
            try{

                _gites.value = GiteApi.retrofitService.getGites()
                _status.value = GiteApiStatus.DONE
            }catch (e:Exception){

                println(e.printStackTrace().toString())
                _status.value = GiteApiStatus.ERROR
                _gites.value = listOf()
            }
        }

    }


    fun onGiteClicked(gite: Gite){
        _gite.value = gite
    }
}