package ru.valeryvpetrov.androidearn

import android.app.Application
import com.google.android.gms.ads.MobileAds
import ru.valeryvpetrov.androidearn.logger.Logger

class App : Application() {

    lateinit var logger: Logger
        private set

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            logger = Logger()
            logger.initDebug()
        }

        MobileAds.initialize(this) {
            logger.d("Mobile ads initialization complete: $it")
        }
    }
}