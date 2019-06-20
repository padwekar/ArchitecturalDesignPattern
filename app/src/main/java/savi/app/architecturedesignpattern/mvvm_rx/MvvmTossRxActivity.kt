package savi.app.architecturedesignpattern.mvvm_rx

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_toss.*
import savi.app.architecturedesignpattern.R

class MvvmTossRxActivity : AppCompatActivity() {

    private lateinit var tossRxViewModel : TossRxViewModel

    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toss)
        tossRxViewModel = ViewModelProviders.of(this).get(TossRxViewModel::class.java)
        subscribeToViewModelEvents()
        tossRxViewModel.onViewCreate()
    }

    override fun onPause() {
        super.onPause()
        unsubscribeToViewModelEvents()
    }

    override fun onResume() {
        super.onResume()
        subscribeToViewModelEvents()
    }

    fun onTossClick(view : View){
        tossRxViewModel.onTossButtonClicked()
    }


    private fun subscribeToViewModelEvents() {
        tossRxViewModel.run {

            compositeDisposable.add(backgroundColorSubject.subscribe {
                parentLayout.setBackgroundColor(ContextCompat.getColor(this@MvvmTossRxActivity,it))
            })

            compositeDisposable.add(progressBarVisibilitySubject.subscribe {
                progressBar.visibility  = it
            })

            compositeDisposable.add(resultTextViewVisibilitySubject.subscribe {
                tossResultTextView.visibility  = it
            })

            compositeDisposable.add( resultTextSubject.subscribe {
                tossResultTextView.text = it
            })

        }
    }

    private fun unsubscribeToViewModelEvents(){
        compositeDisposable.dispose()
    }
}
