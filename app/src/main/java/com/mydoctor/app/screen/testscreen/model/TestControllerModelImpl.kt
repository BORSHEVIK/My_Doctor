package com.mydoctor.app.screen.testscreen.model

import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.model.BaseModelImpl
import com.mydoctor.app.room.entity.Person
import com.mydoctor.app.screen.testscreen.presenter.TestControllerPresenter
import io.reactivex.Single

class TestControllerModelImpl : BaseModelImpl<TestControllerPresenter>, TestControllerModel {

    constructor(myControllerPresenterProvider: PresenterProvider<TestControllerPresenter>, abs: Abs) : super(myControllerPresenterProvider, abs) {
    }

    override fun getAllPersons(): Single<List<Person>> {
        return Single.just(listOf())
    }

}