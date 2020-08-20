package net.lishaoy.kotlindemo.utils

import android.app.Dialog
import android.content.Context
import net.lishaoy.kotlindemo.R

object LoadingDialog {

    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel()
        dialog = Dialog(context)
        dialog?.window?.setBackgroundDrawableResource(R.color.no_color)
        dialog?.setContentView(R.layout.dialog_layout)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel() {
        dialog?.dismiss()
    }

}