package com.mydoctor.app.abs

import com.mydoctor.app.abs.presenter.BasePresenter

interface PresenterProvider<P : BasePresenter> {

    fun getPresenter(): P

}