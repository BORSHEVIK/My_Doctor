package com.mydoctor.app.dialog.message.view

import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.view.BaseViewImpl
import com.mydoctor.app.dialog.message.presenter.MessageDialogPresenter

class MessageDialogViewImpl : BaseViewImpl<MessageDialogViewHolder, MessageDialogPresenter>, MessageDialogView {

    constructor(messageDialogViewHolder: MessageDialogViewHolder, presenterProvider: PresenterProvider<MessageDialogPresenter>)
            : super(messageDialogViewHolder, presenterProvider) {
        viewHolder.okButton.setOnClickListener { presenterProvider.getPresenter().okButtonClick() }
    }

    override fun setMeessage(message: String) {
        viewHolder.messageTextView.setText(message)
    }

}