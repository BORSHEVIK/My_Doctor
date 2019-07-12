package com.mydoctor.app.dialog.message

import android.os.Bundle
import android.view.View
import com.mydoctor.app.R
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.BaseDialogController
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.dialog.message.presenter.RecordAudioDialogArguments
import com.mydoctor.app.dialog.message.presenter.RecordAudioDialogPresenter
import com.mydoctor.app.dialog.message.presenter.RecordAudioDialogPresenterImpl
import com.mydoctor.app.dialog.message.view.RecordAudioDialogView
import com.mydoctor.app.dialog.message.view.RecordAudioDialogViewHolder
import com.mydoctor.app.dialog.message.view.RecordAudioDialogViewImpl

class RecordAudioDialogController(args: Bundle?) : BaseDialogController<RecordAudioDialogViewHolder, RecordAudioDialogView, DataHolder, RecordAudioDialogPresenter, RecordAudioDialogArguments, RecordAudioCallback>(args) {

    override fun createDataHolder(): DataHolder {
        return DataHolder()
    }

    override fun createViewHolder(view: View): RecordAudioDialogViewHolder {
        return RecordAudioDialogViewHolder(view)
    }

    override fun createView(viewHolder: RecordAudioDialogViewHolder): RecordAudioDialogView {
        return RecordAudioDialogViewImpl(viewHolder, this)
    }

    override fun createPresenter(view: RecordAudioDialogView, model: BaseModel, dataHolder: DataHolder, arguments: RecordAudioDialogArguments, abs: PAbs): RecordAudioDialogPresenter {
        return RecordAudioDialogPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun getViewLayoutId(): Int {
        return R.layout.voice_recognition_dialog
    }

}