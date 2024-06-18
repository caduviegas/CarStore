package com.benhurqs.base.views.components

import android.content.Context
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.FragmentActivity
import com.benhurqs.base.R
import com.benhurqs.base.views.inflateView

class ErrorView (private val context: Context) {
    private val errorView = (R.layout.error_view).inflateView(context)
    private var mainView =  (context as? FragmentActivity)?.findViewById<ViewGroup>(android.R.id.content)
    private val errorMessage = errorView.findViewById<AppCompatTextView>(R.id.error_view_message)
    private val errorTryAgain = errorView.findViewById<AppCompatTextView>(R.id.error_view_try_btn)

    private var clickTryAgain: (() -> Unit)? = null

    private fun setTitle(text: String){
        errorMessage.text = text
    }

    private fun setListener(listener: (() -> Unit)){
        this.clickTryAgain = listener
    }

    fun show(){
        errorTryAgain.setOnClickListener { clickTryAgain?.invoke(); hideError() }
        mainView?.addView(errorView)
    }

    private fun hideError(){
        mainView?.removeView(errorView)
    }

    companion object {
        fun makeContent(context: Context,
                        title: String? = null,
                        clickTryAgain: (() -> Unit)? = null): ErrorView {
            val message = ErrorView(context)
            title?.let { message.setTitle(it) }
            clickTryAgain?.let { message.setListener(it) }
            return message
        }
    }
}