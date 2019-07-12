package com.mydoctor.app.screen.testscreen.view

import com.mydoctor.app.abs.PresenterProvider
import com.mydoctor.app.abs.view.BaseViewImpl
import com.mydoctor.app.room.entity.Person
import com.mydoctor.app.screen.testscreen.presenter.TestControllerPresenter

class TestControllerViewImpl : BaseViewImpl<TestControllerViewHolder, TestControllerPresenter>, TestControllerView  {

    constructor(myControllerViewHolder: TestControllerViewHolder, presenterProvider: PresenterProvider<TestControllerPresenter>)
            : super(myControllerViewHolder, presenterProvider) {

    }

    override fun updatePersons(persons: MutableList<Person>) {
    }

    override fun setProgressVisibility(visible: Boolean) {
    }

}