package savi.app.architecturedesignpattern.mvvm_live_data

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import savi.app.architecturedesignpattern.AppConstant
import savi.app.architecturedesignpattern.Coin
import savi.app.architecturedesignpattern.R
import savi.app.architecturedesignpattern.AppConstant.TOSS_DELAY_DURATION

class TossViewModel : ViewModel() {

    val screenTitleLiveData by lazy {
        MutableLiveData<String>()
    }

    val backgroundColorLiveData by lazy {
        MutableLiveData<Int>()
    }

    val progressBarVisibilityLiveData by lazy {
        MutableLiveData<Int>()
    }

    val resultTextViewVisibilityLiveData by lazy {
        MutableLiveData<Int>()
    }

    var resultTextLiveData = MutableLiveData<String>()

    val coin = Coin()

    init {
        resultTextLiveData = coin.tossLiveData
    }

    fun onViewCreated(){
        screenTitleLiveData.value = AppConstant.SCREEN_TITLE_MVVM_LIVE_DATA
        backgroundColorLiveData.value = R.color.colorMvvmBackground
    }

    fun onTossButtonClicked(){
        progressBarVisibilityLiveData.value = VISIBLE
        resultTextViewVisibilityLiveData.value = INVISIBLE
        Handler().postDelayed({
            coin.tossAndUpdateLiveData()
            progressBarVisibilityLiveData.value = INVISIBLE
            resultTextViewVisibilityLiveData.value = VISIBLE
        }, TOSS_DELAY_DURATION)
    }


}