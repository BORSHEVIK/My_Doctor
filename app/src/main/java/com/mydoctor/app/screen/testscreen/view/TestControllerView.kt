package com.mydoctor.app.screen.testscreen.view

import com.mydoctor.app.abs.view.BaseView
import com.mydoctor.app.room.entity.Person

interface TestControllerView : BaseView {

    fun updatePersons(persons: MutableList<Person>)
    fun setProgressVisibility(visible: Boolean)

}