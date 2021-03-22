package com.suiiz.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.*
import android.os.Build
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asksira.loopingviewpager.LoopingViewPager
import com.suiiz.R
import com.suiiz.SuiizApplication
import com.suiiz.adapters.HomeAdapter
import com.suiiz.adapters.carsBrandFragmentAdapters.CarsBrandRvAdapter
import com.suiiz.adapters.AdsLoopViewPagerAdapter
import com.suiiz.adapters.vehicleFragmnetAdapters.VehiclesRecyclerAdapter
import com.suiiz.repositories.MainRepository
import com.suiiz.util.Constants
import com.suiiz.util.DummyData
import java.util.*
import kotlin.collections.ArrayList

class MainViewModelProviderFactory(
    val app: Application,
    val repository: MainRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, repository) as T
    }
}

class MainViewModel(
    app: Application,
    val repository: MainRepository
) : AndroidViewModel(app) {

    /////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// MAIN ACTIVITY - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    fun getSharedPrefLocale(activity: Activity, context: Context, res: Resources) {
        val sharedPref =
            context.getSharedPreferences(Constants.SHARED_PREF, AppCompatActivity.MODE_PRIVATE)
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            res.configuration.locales[0].toString()
        } else {
            res.configuration.locale.toString()
        }
        setLocale(activity, sharedPref.getString(Constants.LANG, locale))
    }

    private fun setLocale(activity: Activity, languageCode: String?) {
        val locale = Locale(languageCode.toString())
        Locale.setDefault(locale)
        val resources = activity.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////// CHOOSE LANGUAGE fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////

    // Country Spinner Configuration
    fun setupCountrySpinner(sp: Spinner, context: Context, res: Resources) {
        // popup bg configuration
        sp.setPopupBackgroundResource(R.color.primaryColor)
        // data configuration
        val arr = res.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(context, R.layout.item_spinner, arr)
        sp.adapter = adapter
    }

    // set language code string to use it with sharedPref to set locale manual
    fun setLanguageCode(code: String, activity: FragmentActivity) {
        val pref = activity.getSharedPreferences(Constants.SHARED_PREF, 0)
        val editor = pref.edit()
        editor.apply {
            putString(Constants.LANG, code)
            apply()
        }
        activity.recreate()
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// LOGIN fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// SIGNUP fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// HOME fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    var homeAdapter = HomeAdapter()
    fun setupHomeRv(rv: RecyclerView, res: Resources, activity: Activity) {
        homeAdapter.differ.submitList(DummyData.mainCategoryList(res))
        rv.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////// Vehicles fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    private fun vehicleLoopVpAdapter(
        context: Context,
        list: ArrayList<String>,
        isInfinity: Boolean
    ) = AdsLoopViewPagerAdapter(context, list, isInfinity)

    fun setupLoopingVp(loopingViewPager: LoopingViewPager, context: Context) {
        val adapter = vehicleLoopVpAdapter(context, DummyData.loopVpList(), true)
        loopingViewPager.adapter = adapter
    }



    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// Brand fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    val carsBrandRvAdapter = CarsBrandRvAdapter()



    /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////// API NETWORK - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    /*val photos: MutableLiveData<Resource<PhotosResponse>> = MutableLiveData()
    var photosPage = 1
    var photosResponse: PhotosResponse? = null

    fun getPhotos() = viewModelScope.launch {
        Log.d(Constants.TAG, " getPhotos() called from VehicleViewModel::class.java ")
        safePhotosListCall()
    }

    private fun handlePhotosResponse(response: Response<PhotosResponse>): Resource<PhotosResponse> {
        Log.d(Constants.TAG, " handle() called from VehicleViewModel::class.java ")
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                photosPage++
                Log.d(Constants.TAG, " $photosPage ")
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
        Log.d(Constants.TAG, " safePhotosListCall() called from VehicleViewModel::class.java ")
        Log.d(Constants.TAG, " hasInternetConnection() : ${hasInternetConnection()} ")
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
    }*/


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





















}