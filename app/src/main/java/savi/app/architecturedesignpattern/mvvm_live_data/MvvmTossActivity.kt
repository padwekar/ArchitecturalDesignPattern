package savi.app.architecturedesignpattern.mvvm_live_data

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_toss.*
import savi.app.architecturedesignpattern.R

class MvvmTossActivity : AppCompatActivity() {

    lateinit var tossViewModel : TossViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        tossViewModel = ViewModelProviders.of(this).get(TossViewModel::class.java)
        subscribeToViewModelEvents()
        tossViewModel.onViewCreated()
    }

    fun onTossClick(view : View){
        tossViewModel.onTossButtonClicked()
    }

    private fun subscribeToViewModelEvents() {
        tossViewModel.run {

            screenTitleLiveData.observe(this@MvvmTossActivity, Observer { it?.let { title ->
                titleTextView.text = title
            }})

            backgroundColorLiveData.observe(this@MvvmTossActivity, Observer { it?.let { color ->
                    parentLayout.setBackgroundColor(ContextCompat.getColor(this@MvvmTossActivity,color))
            }})

            progressBarVisibilityLiveData.observe(this@MvvmTossActivity, Observer{it?.let { visibility ->
                    progressBar.visibility  = visibility
            }})

            resultTextViewVisibilityLiveData.observe(this@MvvmTossActivity, Observer {it?.let { visibility ->
                    tossResultTextView.visibility  = visibility
            }})

            resultTextLiveData.observe(this@MvvmTossActivity, Observer { it?.let { result ->
                    tossResultTextView.text = result
            }})
        }

    }
}
