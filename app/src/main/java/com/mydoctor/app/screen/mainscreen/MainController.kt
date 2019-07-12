package com.mydoctor.app.screen.mainscreen

import android.os.Bundle
import android.view.View
import com.mydoctor.app.R
import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.BaseController
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.BaseDialogEventListener
import com.mydoctor.app.abs.presenter.Arguments
import com.mydoctor.app.screen.mainscreen.model.MainControllerModel
import com.mydoctor.app.screen.mainscreen.model.MainControllerModelImpl
import com.mydoctor.app.screen.mainscreen.presenter.MainControllerDataHolder
import com.mydoctor.app.screen.mainscreen.presenter.MainControllerPresenter
import com.mydoctor.app.screen.mainscreen.presenter.MainControllerPresenterImpl
import com.mydoctor.app.screen.mainscreen.view.MainControllerView
import com.mydoctor.app.screen.mainscreen.view.MainControllerViewHolder
import com.mydoctor.app.screen.mainscreen.view.MainControllerViewImpl

class MainController(args: Bundle?) : BaseController<MainControllerViewHolder, MainControllerView, MainControllerModel, MainControllerDataHolder, MainControllerPresenter, Arguments>(args) {

    override fun getViewLayoutId(): Int {
        return R.layout.main_controller
    }

    override fun createViewHolder(view: View): MainControllerViewHolder {
        return MainControllerViewHolder(view)
    }

    override fun createDataHolder(): MainControllerDataHolder {
        return MainControllerDataHolder()
    }

    override fun createView(viewHolder: MainControllerViewHolder): MainControllerView {
        return MainControllerViewImpl(viewHolder, this)
    }

    override fun createModel(abs: Abs): MainControllerModel {
        return MainControllerModelImpl(this, abs)
    }

    override fun createPresenter(view: MainControllerView, model: MainControllerModel, dataHolder: MainControllerDataHolder, arguments: Arguments, abs: PAbs): MainControllerPresenter {
        return MainControllerPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun provideEvent(): BaseDialogEventListener {
        return getPresenter()
    }

}
