package savi.app.architecturedesignpattern.mvvm_rx

import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import io.reactivex.subjects.PublishSubject
import savi.app.architecturedesignpattern.AppConstant
import savi.app.architecturedesignpattern.AppConstant.TOSS_DELAY_DURATION
import savi.app.architecturedesignpattern.Coin
import savi.app.architecturedesignpattern.R

class TossRxViewModel : ViewModel() {

    val screenTitleSubject  by lazy {
        PublishSubject.create<String>()
    }

    val backgroundColorSubject  by lazy {
         PublishSubject.create<Int>()
    }

    val progressBarVisibilitySubject by lazy {
        PublishSubject.create<Int>()
    }

    val resultTextViewVisibilitySubject by lazy {
        PublishSubject.create<Int>()
    }

    var resultTextSubject=  PublishSubject.create<String>()

    val coin = Coin()

    init {
        resultTextSubject = coin.tossSubject
    }

    fun onViewCreate(){
        screenTitleSubject.onNext(AppConstant.SCREEN_TITLE_MVVM_RX)
        backgroundColorSubject.onNext( R.color.colorMvvmRxBackground)
    }

    fun onTossButtonClicked(){
        progressBarVisibilitySubject.onNext(VISIBLE)
        resultTextViewVisibilitySubject.onNext(INVISIBLE)

        Handler().postDelayed(Runnable {
            coin.tossAndUpdateSubject()
            progressBarVisibilitySubject.onNext(INVISIBLE)
            resultTextViewVisibilitySubject.onNext(VISIBLE)
        }, TOSS_DELAY_DURATION)



    }


}