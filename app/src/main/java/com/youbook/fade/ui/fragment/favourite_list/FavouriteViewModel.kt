package com.youbook.fade.ui.fragment.favourite_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.barber_details.ISFavouriteResponseModel
import com.youbook.fade.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class FavouriteViewModel(val repository: FavouriteRepository) : BaseViewModel(repository) {
    private val _getFavouriteBarber: MutableLiveData<Resource<FavBarberResponseModel>> = MutableLiveData()
    val getFavouriteBarber: LiveData<Resource<FavBarberResponseModel>>
        get() = _getFavouriteBarber

    private val _makeBarberFav: MutableLiveData<Resource<ISFavouriteResponseModel>> = MutableLiveData()
    val makeBarberFavUnFav: LiveData<Resource<ISFavouriteResponseModel>>
        get() = _makeBarberFav

    suspend fun getFavouriteBarber(
    ) = viewModelScope.launch {
        _getFavouriteBarber.value = Resource.Loading
        _getFavouriteBarber.value = repository.getFavouriteBarber()
    }

    suspend fun makeBarberFavUnFav(
        params: Map<String, String>
    ) = viewModelScope.launch {
        _makeBarberFav.value = Resource.Loading
        _makeBarberFav.value = repository.makeBarberFavUnFav(params)
    }
}