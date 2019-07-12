package com.mydoctor.app.dialog.message.view

import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.TextView
import com.mydoctor.app.R
import com.mydoctor.app.abs.view.ViewHolder

class RecordAudioDialogViewHolder : ViewHolder {

    val questionTextView: TextView
    val timerTextView: TextView
    val recordButton: AppCompatImageView

    constructor(view: View) : super(view) {
        questionTextView = view.findViewById(R.id.question)
        timerTextView = view.findViewById(R.id.timer)
        recordButton = view.findViewById(R.id.record)
    }

}