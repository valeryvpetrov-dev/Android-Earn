package ru.valeryvpetrov.androidearn.logger

import androidx.fragment.app.Fragment
import ru.valeryvpetrov.androidearn.App

fun Fragment.logD(message: String) {
    (this.activity?.application as App).logger.d(message)
}