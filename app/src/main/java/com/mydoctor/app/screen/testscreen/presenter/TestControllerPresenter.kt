package com.mydoctor.app.screen.testscreen.presenter

import com.mydoctor.app.abs.presenter.BasePresenter
import com.mydoctor.app.room.entity.Person

interface TestControllerPresenter : BasePresenter {

    fun personSelected(person: Person)

}