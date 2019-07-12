package com.mydoctor.app.dialog.message

import com.mydoctor.app.abs.dialog.BaseDialogEventListener

interface MessageCallback : BaseDialogEventListener {

    fun okPressed()

}