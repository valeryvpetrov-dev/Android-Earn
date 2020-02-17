package ru.valeryvpetrov.androidearn

import android.app.Application
import ru.valeryvpetrov.androidearn.logger.Logger

class App : Application() {

    private lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            logger = Logger()
            logger.initDebug()
        }
    }
}