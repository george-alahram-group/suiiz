package com.suiiz.viewmodels

import android.app.Application
import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suiiz.adapters.vehicle_fragment_adapters.VehiclesRecyclerAdapter
import com.suiiz.repositories.MainRepository
import com.suiiz.util.DummyData

@Suppress("UNCHECKED_CAST")
class VehicleViewModelProviderFactory(
    val app: Application,
    private val repository: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VehicleViewModel(app, repository) as T
    }
}

class VehicleViewModel(
    app: Application,
    val repository: MainRepository
) : AndroidViewModel(app) {

    // TODO : Logic here

    /*init {
        getPhotos()
    }*/

    /////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////// Vehicles fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    val vehiclesRecyclerAdapter = VehiclesRecyclerAdapter()

    fun setupRv(rv:RecyclerView,res:Resources,context: Context) {
        vehiclesRecyclerAdapter.differ.submitList(DummyData.vehicleList(res))
        rv.apply {
            adapter = vehiclesRecyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

/*
    /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////// API NETWORK - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    val photos: MutableLiveData<Resource<PhotosResponse>> = MutableLiveData()
    var photosPage = 1
    var photosResponse: PhotosResponse? = null

    fun getPhotos() = viewModelScope.launch {
        Log.d(TAG, " getPhotos() called from VehicleViewModel::class.java ")
        safePhotosListCall()
    }

    private fun handlePhotosResponse(response: Response<PhotosResponse>): Resource<PhotosResponse> {
        Log.d(TAG, " handle() called from VehicleViewModel::class.java ")
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                photosPage++
                Log.d(TAG, " $photosPage ")
                if (photosResponse == null) {
                    photosResponse = resultResponse
                } else {
                    val oldPhotos = photosResponse?.list
                    val newPhotos = resultResponse.list
                    oldPhotos?.addAll(newPhotos)
                }
                return Resource.Success(photosResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private suspend fun safePhotosListCall() {
        Log.d(TAG, " safePhotosListCall() called from VehicleViewModel::class.java ")
        Log.d(TAG, " hasInternetConnection() : ${hasInternetConnection()} ")
        photos.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = repository.getPhotos(photosPage)
                photos.postValue(handlePhotosResponse(response))
            } else {
                photos.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> photos.postValue(Resource.Error("Network Failure"))
                else -> photos.postValue(Resource.Error("Conversion Error"))
            }
        }
    }


    // return the internet state :: Boolean
    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<SuiizApplication>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilitiesInfo =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilitiesInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilitiesInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilitiesInfo.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }
*/
}