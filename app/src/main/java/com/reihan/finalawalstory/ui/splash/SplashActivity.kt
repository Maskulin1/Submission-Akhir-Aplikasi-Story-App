package com.reihan.finalawalstory.ui.splash

import android.annotation.SuppressLint
import com.reihan.finalawalstory.ui.launcher.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.reihan.finalawalstory.databinding.ActivitySplashBinding
import com.reihan.finalawalstory.remote.preferences.SettingPreferences
import com.reihan.finalawalstory.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    @Inject
    lateinit var settingPreferences: SettingPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val settingPreferences = settingPreferences.getUser()
            if (settingPreferences?.token != null) {
                Log.d(TAG, settingPreferences.toString())
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LauncherActivity::class.java))
            }
            finish()
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 4000L // delay in milliseconds
        private const val TAG = "SETTING PREFERENCES"
    }
}