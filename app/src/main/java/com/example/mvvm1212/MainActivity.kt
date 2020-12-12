package com.example.mvvm1212

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.example.mvvm1212.databinding.ActivityMainBinding
import com.example.mvvmpr.Util.DI.WeatherRepositoryInjector
import com.example.mvvmpr.model.repository.WeatherRepositoryInterface
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private val repository: WeatherRepositoryInterface =
        WeatherRepositoryInjector.provideWeatherRepository()

    private val mainViewModel: MainViewModel =
        MainViewModel(repository, compositeDisposable)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
//        mainViewModel.currentWeather.addOnPropertyChangedCallback(object :
//            Observable.OnPropertyChangedCallback() {
//            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
//                Toast.makeText(
//                    this@MainActivity,
//                    resources.getText(R.string.weather),
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//
//        })


        mainViewModel.currentWeather.observe(this, Observer {
            Toast.makeText(
                this@MainActivity,
                resources.getText(R.string.weather),
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}