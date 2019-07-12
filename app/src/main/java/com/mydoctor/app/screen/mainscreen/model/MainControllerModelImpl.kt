package com.mydoctor.app.screen.mainscreen.model

import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.model.BaseModelImpl
import com.mydoctor.app.screen.mainscreen.presenter.MainControllerPresenter

class MainControllerModelImpl : BaseModelImpl<MainControllerPresenter>, MainControllerModel {

    constructor(myControllerPresenterProvider: PresenterProvider<MainControllerPresenter>, abs: Abs) : super(myControllerPresenterProvider, abs) {

    }

}