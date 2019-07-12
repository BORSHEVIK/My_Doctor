package com.mydoctor.app.abs.dialog.presenter

import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.BaseDialogEventListener
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.presenter.BasePresenterImpl
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.abs.view.BaseView

abstract open class BaseDialogPresenterImlp<V: BaseView, M: BaseModel, D: DataHolder, A: DialogArguments, L: BaseDialogEventListener>(view: V, model: M, dataHolder: D, arguments: A, abs: PAbs) :
        BasePresenterImpl<V, M, D, A>(view, model, dataHolder, arguments, abs), BaseDialogPresenter<L> {

    internal lateinit var eventListener: L

    override fun attachEventListener(eventListener: L) {
        this.eventListener = eventListener
    }

    fun getControllerTag(): String {
        return arguments.controllerTag
    }

    override fun setMenu() {
        //Do nothing
    }
}