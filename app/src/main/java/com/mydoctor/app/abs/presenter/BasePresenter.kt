package com.mydoctor.app.abs.presenter

import android.content.Intent
import com.mydoctor.app.abs.AndroidLifeCycle

interface BasePresenter : AndroidLifeCycle {

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray)

}