package com.mydoctor.app.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.mydoctor.app.R
import com.mydoctor.app.abs.LocalSchedulers
import com.mydoctor.app.abs.PAbs
import com.mydoctor.app.abs.dialog.BaseDialogEventListener
import com.mydoctor.app.abs.dialog.DialogEventListenerStub
import com.mydoctor.app.abs.dialog.DialogEventProvider
import com.mydoctor.app.menu.Menu
import com.mydoctor.app.service.Navigator
import com.mydoctor.app.service.PermissionsService
import com.mydoctor.app.service.PermissionsService.Companion.PERMISSION_STATUS_GRANTED
import com.mydoctor.app.service.ToastManager
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.ObservableEmitter
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap


class MainActivity : AppCompatActivity(), PAbs, PermissionsService.PermissionsCallbacks {

    private lateinit var router: Router
    private lateinit var dialogRouter: Router
    private lateinit var navigator: Navigator
    private lateinit var toastManager: ToastManager
    private lateinit var permissionsService: PermissionsService
    private lateinit var menu: Menu

    private var pendingPermission: PermissionsService.Permission? = null

    private lateinit var toolBar: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById(R.id.container) as ViewGroup
        val dialogContainer = findViewById(R.id.dialogContainer) as ViewGroup
        toolBar = findViewById(R.id.tab_layout)

        menu = Menu(getContext(), findViewById(R.id.meny_layout) as ViewGroup)
        toastManager = ToastManager(applicationContext)
        permissionsService = PermissionsService(this, toastManager)
        router = Conductor.attachRouter(this, container, savedInstanceState)
        dialogRouter = Conductor.attachRouter(this, dialogContainer, savedInstanceState)
        navigator = Navigator(router, dialogRouter)
    }

    override fun onStart() {
        super.onStart()
        permissionsService.setListener(this)
    }

    override fun onStop() {
        permissionsService.removeListener(this)
        super.onStop()
    }

    override fun onBackPressed() {
        if (dialogRouter.backstackSize > 1 && dialogRouter.handleBack()) {
        } else if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun onPermissionRequest(keys: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(this, keys, requestCode)
    }

    override fun onPermissionPending(permission: PermissionsService.Permission) {
        pendingPermission = permission
    }

    override fun onPermissionShowExplanation(explanation: String?): Boolean {
        showPermisionMessage(explanation!!)
        return false
    }

    override fun getNavigator(): Navigator {
        return navigator
    }

    override fun getToastManager(): ToastManager {
        return toastManager
    }

    override fun getPermissionService(): PermissionsService {
        return permissionsService
    }

    //TODO how to move it in navigator without problems or it not needed?
    override fun getControllerEventListnerByTag(controllerTag: String): BaseDialogEventListener {
        val controller: Controller = router.getControllerWithTag(controllerTag)!!
        return if (controller is DialogEventProvider) controller.provideEvent() else DialogEventListenerStub()
    }

    override fun getContext(): Context {
        return applicationContext
    }

    private fun showPermisionMessage(message: String) {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.message_title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, { dialog, which ->
                    if (pendingPermission != null) {
                        val p = pendingPermission
                        pendingPermission = null
                        permissionsService.requestPermission(p!!)
                    }
                })
                .setCancelable(false)
                .show()
    }

    override fun getMenu(): Menu {
        return menu
    }

    open fun showToolBar(show: Boolean) {
        toolBar.visibility = if (show) View.VISIBLE else View.GONE
    }

}
