package com.mydoctor.app.screen.testscreen.model

import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.room.entity.Person
import io.reactivex.Single

interface TestControllerModel : BaseModel {

    fun getAllPersons(): Single<List<Person>>

}