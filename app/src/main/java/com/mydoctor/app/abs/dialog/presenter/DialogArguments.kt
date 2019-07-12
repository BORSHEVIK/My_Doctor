package com.mydoctor.app.abs.dialog.presenter

import com.mydoctor.app.abs.presenter.Arguments

open class DialogArguments(parrentTag: String) : Arguments(parrentTag) {

    var title = ""
    var cancelable = true

}