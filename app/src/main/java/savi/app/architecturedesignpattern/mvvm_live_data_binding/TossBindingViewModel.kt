package savi.app.architecturedesignpattern.mvvm_live_data_binding

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import savi.app.architecturedesignpattern.AppConstant
import savi.app.architecturedesignpattern.Coin
import savi.app.architecturedesignpattern.R
import savi.app.architecturedesignpattern.AppConstant.TOSS_DELAY_DURATION

class TossBindingViewModel : ViewModel() {

    val screenTitleLiveData by lazy {
        MutableLiveData<String>().apply {
            value = AppConstant.SCREEN_TITLE_MVVM_LIVE_DATA_BINDING
        }
    }

    val backgroundColorLiveData by lazy {
        MutableLiveData<Int>()
    }

    val progressBarVisibilityLiveData by lazy {
        MutableLiveData<Int>().apply {
            value = INVISIBLE
        }
    }

    val resultTextViewVisibilityLiveData by lazy {
        MutableLiveData<Int>().apply {
            value = VISIBLE
        }
    }

    var resultTextLiveData = MutableLiveData<Int>()

    val coin = Coin()

    init {
        resultTextLiveData = coin.tossResourceLiveData
        resultTextLiveData.value = R.string.toss_a_coin_text
    }

    fun onViewCreated(){
        screenTitleLiveData.value = AppConstant.SCREEN_TITLE_MVVM_LIVE_DATA_BINDING
        backgroundColorLiveData.value = R.color.colorMvvmBindingBackground
    }

    fun onTossButtonClicked(){
        progressBarVisibilityLiveData.value = VISIBLE
        resultTextViewVisibilityLiveData.value = INVISIBLE
        Handler().postDelayed({
            coin.tossWithResource()
            progressBarVisibilityLiveData.value = INVISIBLE
            resultTextViewVisibilityLiveData.value = VISIBLE
        }, TOSS_DELAY_DURATION)
    }


}