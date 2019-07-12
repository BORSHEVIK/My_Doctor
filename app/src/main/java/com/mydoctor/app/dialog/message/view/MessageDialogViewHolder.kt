package com.mydoctor.app.dialog.message.view

import android.view.View
import android.widget.TextView
import com.mydoctor.app.R
import com.mydoctor.app.abs.view.ViewHolder

class MessageDialogViewHolder : ViewHolder {

    val messageTextView: TextView
    val okButton: TextView

    constructor(view: View) : super(view) {
        messageTextView = view.findViewById(R.id.message)
        okButton = view.findViewById(R.id.button)
    }

}