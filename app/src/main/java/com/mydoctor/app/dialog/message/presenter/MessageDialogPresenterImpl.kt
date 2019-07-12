package com.mydoctor.app.dialog.message.presenter

import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.presenter.BaseDialogPresenterImlp
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.dialog.message.MessageCallback
import com.mydoctor.app.dialog.message.view.MessageDialogView

class MessageDialogPresenterImpl(view: MessageDialogView, model: BaseModel, dataHolder: DataHolder, arguments: MessageDialogArguments, abs: PAbs) :
        BaseDialogPresenterImlp<MessageDialogView, BaseModel, DataHolder, MessageDialogArguments, MessageCallback>(view, model, dataHolder, arguments, abs), MessageDialogPresenter {

    override fun onResume() {
        super.onResume()
        view.setMeessage(arguments.value)
    }

    override fun okButtonClick() {
        abs.getNavigator().closeDialogByTag(getControllerTag())
        eventListener.okPressed()
    }
}