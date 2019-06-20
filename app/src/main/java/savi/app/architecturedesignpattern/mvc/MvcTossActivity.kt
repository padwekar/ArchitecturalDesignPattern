package savi.app.architecturedesignpattern.mvc

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_toss.*
import savi.app.architecturedesignpattern.AppConstant
import savi.app.architecturedesignpattern.R
import savi.app.architecturedesignpattern.Coin
import savi.app.architecturedesignpattern.AppConstant.TOSS_DELAY_DURATION

//Controller
class MvcTossActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        titleTextView.text = AppConstant.SCREEN_TITLE_MVC
        parentLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorMvcBackground))
    }


    fun onTossClick(view : View){
        tossResultTextView.visibility = INVISIBLE //Controller -> View Communication
        progressBar.visibility = VISIBLE

         Handler().postDelayed( {
             tossResultTextView.visibility = VISIBLE
             progressBar.visibility = INVISIBLE
             tossResultTextView.text = Coin().toss()  // Controller -> Model Communication
         }
         ,TOSS_DELAY_DURATION)   // Business Logic
    }
}
