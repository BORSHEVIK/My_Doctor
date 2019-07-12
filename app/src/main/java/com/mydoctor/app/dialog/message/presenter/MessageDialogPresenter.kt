package com.mydoctor.app.dialog.message.presenter

import com.mydoctor.app.abs.dialog.presenter.BaseDialogPresenter
import com.mydoctor.app.dialog.message.MessageCallback

interface MessageDialogPresenter : BaseDialogPresenter<MessageCallback> {

    fun okButtonClick()

}