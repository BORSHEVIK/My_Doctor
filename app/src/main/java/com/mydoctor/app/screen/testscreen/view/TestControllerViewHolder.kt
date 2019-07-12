package com.mydoctor.app.screen.testscreen.view

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.View
import com.mydoctor.app.R
import com.mydoctor.app.abs.view.ViewHolder

class TestControllerViewHolder : ViewHolder {

    val searchView: SearchView
    val recyclerView: RecyclerView
    val progressView: View

    constructor(view: View) : super(view) {
        searchView = view.findViewById(R.id.search_view)
        recyclerView = view.findViewById(R.id.recycler_view)
        progressView = view.findViewById(R.id.progressbar)
    }

}