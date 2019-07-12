package com.mydoctor.app.screen.testscreen

import android.os.Bundle
import android.view.View
import com.mydoctor.app.R
import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.BaseController
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.screen.testscreen.model.TestControllerModel
import com.mydoctor.app.screen.testscreen.model.TestControllerModelImpl
import com.mydoctor.app.screen.testscreen.presenter.TestArguments
import com.mydoctor.app.screen.testscreen.presenter.TestControllerPresenter
import com.mydoctor.app.screen.testscreen.presenter.TestControllerPresenterImpl
import com.mydoctor.app.screen.testscreen.view.TestControllerView
import com.mydoctor.app.screen.testscreen.view.TestControllerViewHolder
import com.mydoctor.app.screen.testscreen.view.TestControllerViewImpl

class TestController(args: Bundle?) : BaseController<TestControllerViewHolder, TestControllerView, TestControllerModel, DataHolder, TestControllerPresenter, TestArguments>(args) {

    override fun createDataHolder(): DataHolder {
        return DataHolder()
    }

    override fun createViewHolder(view: View): TestControllerViewHolder {
        return TestControllerViewHolder(view)
    }

    override fun createView(viewHolder: TestControllerViewHolder): TestControllerView {
        return TestControllerViewImpl(viewHolder, this)
    }

    override fun createPresenter(view: TestControllerView, model: TestControllerModel, dataHolder: DataHolder, arguments: TestArguments, abs: PAbs): TestControllerPresenter {
        return TestControllerPresenterImpl(view, model, dataHolder, arguments, abs)
    }

    override fun createModel(abs: Abs): TestControllerModel {
        return TestControllerModelImpl(this, abs)
    }

    override fun getViewLayoutId(): Int {
        return R.layout.test_controller
    }
}