package com.mandiri.savin.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieDrawable
import com.mandiri.savin.HomeMainActivity
import com.mandiri.savin.LoginActivity
import com.mandiri.savin.R
import com.mandiri.savin.databinding.ActivitySplashscreenBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding

    private val viewModel by viewModels<SplashscreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loSplash.apply {
            setAnimation(R.raw.lo_loadingnew)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }

        Handler(mainLooper).postDelayed({
            val loginObserver = Observer<Boolean> {

                val isLogin = it

                if (isLogin) {
                    val intent = Intent(this, HomeMainActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            viewModel.checkLoginPref().observe(this, loginObserver)
        }, 2000L)
    }
}