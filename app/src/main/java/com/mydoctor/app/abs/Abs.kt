package com.mydoctor.app.abs

import android.content.Context
import com.mydoctor.app.menu.Menu
import com.mydoctor.app.service.PermissionsService
import java.io.Serializable

interface Abs : Serializable {

    fun getPermissionService(): PermissionsService
    fun getContext(): Context
    fun getMenu(): Menu

}