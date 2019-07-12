package com.mydoctor.app.abs

import com.mydoctor.app.abs.dialog.BaseDialogEventListener
import com.mydoctor.app.service.Navigator
import com.mydoctor.app.service.ToastManager

interface PAbs : Abs {

    fun getToastManager(): ToastManager
    fun getNavigator(): Navigator
    fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener

}