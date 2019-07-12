package com.mydoctor.app.abs.view

import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.presenter.BasePresenter

open class BaseViewImpl<V : ViewHolder, P : BasePresenter> : BaseView {

    internal val viewHolder: V
    internal val presenterProvider: PresenterProvider<P>

    constructor(viewHolder: V, presenterProvider: PresenterProvider<P>) {
        this.viewHolder = viewHolder
        this.presenterProvider = presenterProvider
    }

}