package com.mydoctor.app.abs

import android.support.multidex.MultiDexApplication
import com.mydoctor.app.model.SchoolPerson
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber


class App : MultiDexApplication() {

    private var schoolPersons: List<SchoolPerson>? = null
    private lateinit var debugLogTree: DebugLogTree

    override fun onCreate() {
        super.onCreate()
        debugLogTree = DebugLogTree(applicationContext)
        Timber.plant(debugLogTree)
        RxJavaPlugins.setErrorHandler { throwable ->
            Timber.e(throwable, "Error handler reported")
        }

        Timber.i(DebugLogTree.LOG_MESSAGE_APPLICATION_STARTED)
    }

    fun setSchoolPersons(schoolPersons: List<SchoolPerson>) {
        this.schoolPersons = schoolPersons
    }

    fun setLogMessageListener(timberMessageListener: DebugLogTree.TimberMessageListener) {
        debugLogTree.setTimberMessageListener(timberMessageListener)
    }

    fun clearLogMessageListener() {
        debugLogTree.clearLogMessageListener()
    }


}