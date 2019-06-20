package savi.app.architecturedesignpattern

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView

//Method inside binding adapter should be static
object DataBindingAdapter {

    @BindingAdapter("app:stringRes")
    @JvmStatic
    fun setStringRes(tv : TextView,res: Int){
        tv.text = tv.context.getString(res)
    }

    @BindingAdapter("app:backgroundRes")
    @JvmStatic
    fun setBackgroundColorRes(view : View,res: Int){
        view.setBackgroundColor(ContextCompat.getColor(view.context,res))
    }

}