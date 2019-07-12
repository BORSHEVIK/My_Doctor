package com.mydoctor.app.abs.presenter

import android.content.Intent
import com.bluelinelabs.conductor.Controller
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.view.BaseView
import com.mydoctor.app.menu.MenuCallback

abstract open class BasePresenterImpl<V: BaseView, M: BaseModel, D: DataHolder, A: Arguments> : BasePresenter {

    internal val view: V
    internal val model: M
    internal val dataHolder: D
    internal val arguments: A
    internal val abs: PAbs

    constructor(view: V, model: M, dataHolder: D, arguments: A, abs: PAbs) {
        this.view = view
        this.model = model
        this.dataHolder = dataHolder
        this.arguments = arguments
        this.abs = abs
    }

    override fun onDestroy() {

    }

    override fun onCreate() {
        setMenu()
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //Do nothing
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        //DO nothing
    }

    open internal fun setMenu() {
        abs.getMenu().setMenu(arrayListOf(), object: MenuCallback {
            override fun menuItemClick(itemID: Int) {
                //Not implemented
            }
        })
    }

    fun getCurrentController(): Controller {
        return getCurrentController(false)
    }

    fun getCurrentController(isDialog: Boolean): Controller {
        return abs.getNavigator().getControllerByTag(arguments.controllerTag, isDialog)
    }

}