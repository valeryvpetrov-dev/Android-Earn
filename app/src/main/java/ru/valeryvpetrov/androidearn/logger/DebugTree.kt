package ru.valeryvpetrov.androidearn.logger

import timber.log.Timber

class DebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${super.createStackElementTag(element)}:${element.lineNumber}"
    }
}