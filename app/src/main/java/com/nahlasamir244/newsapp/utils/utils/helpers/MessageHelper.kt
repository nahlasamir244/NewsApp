package com.nahlasamir244.newsapp.utils.utils.helpers

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nahlasamir244.newsapp.application.NewsApp

fun displayToast(textResourceId:Int) {
    Toast.makeText(NewsApp.getAppContext(),textResourceId,Toast.LENGTH_LONG).show()

}
fun displayToast(text:String) {
    Toast.makeText(NewsApp.getAppContext(),text,Toast.LENGTH_LONG).show()
}

fun displaySnackBar(view:View,textResourceId:Int) {
    Snackbar.make(view,textResourceId,Snackbar.LENGTH_LONG).show()
}