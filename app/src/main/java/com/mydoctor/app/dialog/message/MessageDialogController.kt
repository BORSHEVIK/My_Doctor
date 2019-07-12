package com.mydoctor.app.dialog.message

import android.os.Bundle
import android.view.View
import com.mydoctor.app.R
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.BaseDialogController
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.dialog.message.presenter.MessageDialogArguments
import com.mydoctor.app.dialog.message.presenter.MessageDialogPresenter
import com.mydoctor.app.dialog.message.presenter.MessageDialogPresenterImpl
import com.mydoctor.app.dialog.message.view.MessageDialogView
import com.mydoctor.app.dialog.message.view.MessageDialogViewHolder
import com.mydoctor.app.dialog.message.view.MessageDialogViewImpl

class MessageDialogController(args: Bundle?) : BaseDialogController<MessageDialogViewHolder, MessageDialogView, DataHolder, MessageDialogPresenter, MessageDialogArguments, MessageCallback>(args) {

    override fun createDataHolder(): DataHolder {
        return DataHolder()
    }

    override fun createViewHolder(view: View): MessageDialogViewHolder {
        return MessageDialogViewHolder(view)
    }

    override fun createView(viewHolder: MessageDialogViewHolder): MessageDialogView {
        return MessageDialogViewImpl(viewHolder, this)
    }

    override fun createPresenter(view: MessageDialogView, model: BaseModel, dataHolder: DataHolder, arguments: MessageDialogArguments, abs: PAbs): MessageDialogPresenter {
        return MessageDialogPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun getViewLayoutId(): Int {
        return R.layout.message_dialog
    }

}