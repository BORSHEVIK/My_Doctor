package com.mydoctor.app.screen.mainscreen.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.mydoctor.app.abs.LocalSchedulers
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.presenter.Arguments
import com.mydoctor.app.abs.presenter.BasePresenterImpl
import com.mydoctor.app.screen.mainscreen.model.MainControllerModel
import com.mydoctor.app.screen.mainscreen.view.MainControllerView
import com.mydoctor.app.service.PermissionsService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*


class MainControllerPresenterImpl(view: MainControllerView, model: MainControllerModel, dataHolder: MainControllerDataHolder, arguments: Arguments, abs: PAbs) :
        BasePresenterImpl<MainControllerView, MainControllerModel, MainControllerDataHolder, Arguments>(view, model, dataHolder, arguments, abs), MainControllerPresenter {

    override fun onResume() {
        super.onResume()
    }

    @SuppressLint("CheckResult")
    override fun onCreate() {
        super.onCreate()
    }

}