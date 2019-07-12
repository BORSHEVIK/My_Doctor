package com.mydoctor.app.abs.model

import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.presenter.BasePresenter

open class BaseModelImpl <P : BasePresenter> : BaseModel {

    internal val presenterProvider: PresenterProvider<P>
    internal val abs: Abs

    constructor(presenterProvider: PresenterProvider<P>, abs: Abs) {
        this.presenterProvider = presenterProvider
        this.abs = abs
    }
}