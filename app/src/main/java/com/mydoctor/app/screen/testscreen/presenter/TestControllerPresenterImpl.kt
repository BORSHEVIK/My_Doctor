package com.mydoctor.app.screen.testscreen.presenter

import android.annotation.SuppressLint
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.presenter.BasePresenterImpl
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.room.entity.Person
import com.mydoctor.app.screen.testscreen.model.TestControllerModel
import com.mydoctor.app.screen.testscreen.view.TestControllerView

class TestControllerPresenterImpl(view: TestControllerView, model: TestControllerModel, dataHolder: DataHolder, arguments: TestArguments, abs: PAbs)
    : BasePresenterImpl<TestControllerView, TestControllerModel, DataHolder, TestArguments>(view, model, dataHolder, arguments, abs), TestControllerPresenter {


    companion object {
        private val TAG = TestControllerPresenterImpl::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        updatePersons(true)
    }

    @SuppressLint("CheckResult")
    private fun syncronizeFiles() {
    }

    private fun updatePersons(syncronizeFiles: Boolean) {
    }

    override fun personSelected(person: Person) {
    }
}