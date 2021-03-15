package com.suiiz.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.suiiz.R
import com.suiiz.SuiizApplication
import com.suiiz.adapters.HomeAdapter
import com.suiiz.adapters.carsBrandFragmentAdapters.CarsBrandRvAdapter
import com.suiiz.adapters.vehicleFragmnetAdapters.VehiclesRecyclerAdapter
import com.suiiz.adapters.vehicleFragmnetAdapters.VehiclesVp2Adapter
import com.suiiz.model.VehiclesResponse
import com.suiiz.repositories.MainRepository
import com.suiiz.util.Constants
import com.suiiz.util.DummyData
import com.suiiz.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import java.util.*

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
    val vehiclesRecyclerAdapter = VehiclesRecyclerAdapter()
    val vehiclesVp2Adapter = VehiclesVp2Adapter()

    fun setupVehicleVp2(vp2: ViewPager2) {
        vehiclesVp2Adapter.differ.submitList(DummyData.vp2List())
        vp2.apply {
            adapter = vehiclesVp2Adapter
        }
    }



    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// Brand fragment - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////

    val carsBrandRvAdapter = CarsBrandRvAdapter()

    fun setupCarsBrandRv(rv: RecyclerView, res: Resources, activity: Activity) {
        carsBrandRvAdapter.differ.submitList(DummyData.carsBrandList(res))
        rv.apply {
            adapter = carsBrandRvAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////// API NETWORK - viewModel //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    val vehicles: MutableLiveData<Resource<VehiclesResponse>> = MutableLiveData()
    var vehiclesPage = 1
    var vehiclesResponse: VehiclesResponse? = null

    fun getVehicleList() = viewModelScope.launch {
        safeVehicleListCall()
    }

    private suspend fun safeVehicleListCall() {
        vehicles.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = repository.getVehicleList(/*vehiclesPage*/)
                vehicles.postValue(handleVehicleResponse(response))
            } else {
                vehicles.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (t: Throwable) {
            when(t) {
                is IOException -> vehicles.postValue(Resource.Error("Network Failure"))
                else -> vehicles.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private fun handleVehicleResponse(response: Response<VehiclesResponse>): Resource<VehiclesResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                vehiclesPage++
                if (vehiclesResponse == null) {
                    vehiclesResponse = resultResponse
                } else {
                    val oldVehicles = vehiclesResponse?.list
                    val newVehicles = resultResponse.list
                    oldVehicles?.addAll(newVehicles)
                }
                return Resource.Success(vehiclesResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<SuiizApplication>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilitiesInfo =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilitiesInfo.hasTransport(TRANSPORT_WIFI) -> true
                capabilitiesInfo.hasTransport(TRANSPORT_CELLULAR) -> true
                capabilitiesInfo.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }


}