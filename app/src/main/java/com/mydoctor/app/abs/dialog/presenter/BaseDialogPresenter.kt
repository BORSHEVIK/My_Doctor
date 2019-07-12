package com.mydoctor.app.abs.dialog.presenter

import com.mydoctor.app.abs.dialog.BaseDialogEventListener
import com.mydoctor.app.abs.presenter.BasePresenter

interface BaseDialogPresenter<L: BaseDialogEventListener> : BasePresenter {

    fun attachEventListener(eventListener: L)

}