package savi.app.architecturedesignpattern.mvp

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_toss.*
import savi.app.architecturedesignpattern.R

class MvpTossActivity : AppCompatActivity(),TossContract.View {

    var presenter = TossPresenter(this) //Can be injected

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        presenter.onViewCreated()
    }

    fun onTossClick(view : View) {
        presenter.onTossButtonClicked()
    }

    override fun setScreenTitle(title: String) {
        titleTextView.text = title
    }

    override fun setBackgroundColor(colorRes: Int) {
        parentLayout.setBackgroundColor(ContextCompat.getColor(this,colorRes)) // View -> Android API
    }

    override fun setProgressBarVisibility(visibility: Int) {
        progressBar.visibility = visibility
    }

    override fun setResultTextViewVisibility(visibility: Int) {
        tossResultTextView.visibility = visibility
    }

    override fun setResultText(result : String) {
        tossResultTextView.text = result
    }


}