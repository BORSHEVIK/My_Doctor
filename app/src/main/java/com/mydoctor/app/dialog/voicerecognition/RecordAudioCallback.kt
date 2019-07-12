package com.mydoctor.app.dialog.message

import com.mydoctor.app.abs.dialog.BaseDialogEventListener

interface RecordAudioCallback : BaseDialogEventListener {

    fun audioSaved(filePath: String)

}