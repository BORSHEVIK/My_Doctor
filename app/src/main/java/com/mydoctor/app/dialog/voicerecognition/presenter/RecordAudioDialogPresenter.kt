package com.mydoctor.app.dialog.message.presenter

import com.mydoctor.app.abs.dialog.presenter.BaseDialogPresenter
import com.mydoctor.app.dialog.message.RecordAudioCallback

interface RecordAudioDialogPresenter : BaseDialogPresenter<RecordAudioCallback> {

    fun recordClick()

}