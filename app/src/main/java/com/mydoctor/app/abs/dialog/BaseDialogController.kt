package com.mydoctor.app.abs.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mydoctor.app.R
import com.mydoctor.app.abs.Abs
import com.mydoctor.app.abs.BaseController
import com.mydoctor.app.abs.dialog.presenter.BaseDialogPresenter
import com.mydoctor.app.abs.dialog.presenter.DialogArguments
import com.mydoctor.app.abs.model.BaseModel
import com.mydoctor.app.abs.model.BaseModelImpl
import com.mydoctor.app.abs.presenter.DataHolder
import com.mydoctor.app.abs.view.BaseView
import com.mydoctor.app.abs.view.ViewHolder

open abstract class BaseDialogController<H: ViewHolder, V: BaseView, D: DataHolder, P: BaseDialogPresenter<L>, A: DialogArguments, L: BaseDialogEventListener> (args: Bundle?) :
        BaseController<H, V, BaseModel, D, P, A> (args) {

    override fun createModel(abs: Abs): BaseModel {
        return BaseModelImpl(this, abs)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflater.inflate(R.layout.dialog_container, container, false)
        val dialogView = view.findViewById<View>(R.id.dialogView)
        //This line is necessary so that the clicks are not detected on the screen under the dialog.
        dialogView.setOnClickListener {}

        if (fullSizeView()) {
            dialogView.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        } else {
            dialogView.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            dialogView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        }

        val padding = view.context.resources.getDimensionPixelSize(dialogViewPaddingResource())
        view.setPadding(padding, padding, padding, padding)

        val containerGroup: ViewGroup = view.findViewById(R.id.container)
        containerGroup.addView(super.onCreateView(inflater, container))

        val cancelable = arguments?.cancelable.let { true }
        view.setOnClickListener{ if(cancelable){
            abs.getNavigator().closeDialogByTag(arguments!!.controllerTag)
        }}

        val titleText = arguments!!.title
        if (!titleText.isEmpty()) {
            val title: TextView = view.findViewById(R.id.title)
            title.visibility = View.VISIBLE
            title.text = titleText
        }

        getPresenter().attachEventListener(abs.getControllerEventListnerByTag(arguments!!.parrentTag!!) as L)

        return view
    }

    open fun fullSizeView(): Boolean {
        return false
    }

    open fun dialogViewPaddingResource(): Int {
        return R.dimen.base_dialog_padding
    }


}