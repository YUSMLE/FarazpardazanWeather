package com.farazpardazan.weather.presentation.view.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.farazpardazan.weather.R
import com.farazpardazan.weather.common.BaseActivity
import com.farazpardazan.weather.databinding.ActivityMainBinding
import com.farazpardazan.weather.presentation.viewmodel.MainVM
import com.farazpardazan.weather.presentation.viewstate.WeatherDataVS
import javax.inject.Inject

class MainActivity : BaseActivity() {

    /**
     * Values
     */

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private lateinit var mainVM: MainVM
    private lateinit var dataBinding: ActivityMainBinding

    /****************************************************
     * ACTIVITY LIFECYCLE
     ***************************************************/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        extractIntentParams(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    /****************************************************
     * ACTIVITY STATE
     ***************************************************/

    override fun initializeActivity(savedInstanceState: Bundle?) {
        // Nothing
    }

    override fun extractIntentParams(data: Intent?) {
        // Nothing
    }

    /****************************************************
     * VIEW/DATA BINDING
     ***************************************************/

    override fun setupViews() {
        // Set Content View
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun setupActionBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowTitleEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
    }

    override fun setupNavigation() {
        /* Nothing */
    }

    private fun fetchOpenCities() {
        mainVM.fetchOpenCities()
    }

    private fun fetchOverallWeatherData(lat: Double, lon: Double) {
        mainVM.fetchOverallWeatherData(lat, lon)
    }

    private fun renderWeatherDataViewState(weatherDataVS: WeatherDataVS) {
        TODO("Not yet implemented")
    }

    /****************************************************
     * OBSERVERS
     ***************************************************/

    override fun setupObservers() {
        super.setupObservers()

        mainVM = ViewModelProvider(this, viewModelProviderFactory).get(MainVM::class.java)

        mainVM.getWeatherDataStream().observe(this) {
            // DEBUG
            Log.w(TAG, it.toString())
        }

        fetchOverallWeatherData(33.441792, -94.037689)
    }

    /****************************************************
     * SERVICE BINDING
     ***************************************************/

    // Nothing

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
