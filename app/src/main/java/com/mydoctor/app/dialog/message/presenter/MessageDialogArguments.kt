package com.mydoctor.app.dialog.message.presenter

import com.mydoctor.app.abs.dialog.presenter.DialogArguments
import java.io.Serializable

class MessageDialogArguments(parrentTag: String) : DialogArguments(parrentTag), Serializable {

    var value: String = ""

}