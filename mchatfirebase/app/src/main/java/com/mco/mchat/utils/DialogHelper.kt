package com.mco.mchat.utils

import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.mco.mchat.R

object DialogHelper {
    fun loadingDialog(context: Context, isCancelable: Boolean = false): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(context, R.style.WinDowTransparentDialog)
        dialogBuilder.setView(R.layout.progress_dialog_view)
        dialogBuilder.setCancelable(isCancelable)
        val loadingDialog = dialogBuilder.create()
        val window: Window?= loadingDialog.window
        window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window?.setGravity(Gravity.CENTER)
        return loadingDialog
    }

    fun alert(context: Context, msg: String, onPositiveClick: DialogInterface.OnClickListener? = null, onNegativeClick: DialogInterface.OnClickListener? = null): AlertDialog{
        val builder = AlertDialog.Builder(context)
        builder.setMessage(msg)
            .setPositiveButton(context.getString(R.string.ok),
                onPositiveClick)
            .setNegativeButton(context.getString(R.string.cancel),
                onNegativeClick)
        return builder.create()
    }
}