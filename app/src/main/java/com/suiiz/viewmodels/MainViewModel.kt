package com.suiiz.viewmodels

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.suiiz.R
import com.suiiz.util.Constants
import java.util.*

class MainViewModel(

) : ViewModel() {

    //////////////////////////////////////////////////////////
    //////////////////////////////// MAIN ACTIVITY - viewModel
    //////////////////////////////////////////////////////////
    fun getSharedPrefLocale(activity: Activity, context: Context, res: Resources) {
        val sharedPref = context.getSharedPreferences(Constants.SHARED_PREF, AppCompatActivity.MODE_PRIVATE)
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            res.configuration.locales[0].toString()
        } else {
            res.configuration.locale.toString()
        }
        setLocale(activity, sharedPref.getString(Constants.LANG, locale))
    }

    private fun setLocale(activity: Activity, languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = activity.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    //////////////////////////////////////////////////////////
    ///////////////////// CHOOSE LANGUAGE fragment - viewModel
    //////////////////////////////////////////////////////////

    // Country Spinner Configuration
    fun setupCountrySpinner(sp: Spinner, context: Context, res: Resources) {
        // popup bg configuration
        sp.setPopupBackgroundResource(R.color.primaryColor)
        // data configuration
        val arr = res.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(context, R.layout.spinner_item, arr)
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


}