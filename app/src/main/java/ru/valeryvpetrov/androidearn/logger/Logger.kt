package ru.valeryvpetrov.androidearn.logger

import timber.log.Timber

class Logger {

    fun initDebug() {
        Timber.plant(DebugTree())
    }

    inline fun d(message: String) {
        Timber.d(message)
    }

}
