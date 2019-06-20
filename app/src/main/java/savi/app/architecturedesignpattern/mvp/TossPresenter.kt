package savi.app.architecturedesignpattern.mvp

import android.os.Handler
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import savi.app.architecturedesignpattern.AppConstant
import savi.app.architecturedesignpattern.Coin
import savi.app.architecturedesignpattern.R
import savi.app.architecturedesignpattern.AppConstant.TOSS_DELAY_DURATION

class TossPresenter(val view : TossContract.View) : TossContract.Presenter {

    override fun onViewCreated(){
        view.setScreenTitle(AppConstant.SCREEN_TITLE_MVP)
        view.setBackgroundColor(R.color.colorMvpBackground)
    }

    override fun onTossButtonClicked() {
            view.run {

                setProgressBarVisibility(VISIBLE) // Presenter -> View
                setResultTextViewVisibility(INVISIBLE)

                Handler().postDelayed({

                    setResultText(Coin().toss())
                    setProgressBarVisibility(INVISIBLE)
                    setResultTextViewVisibility(VISIBLE)

                }, TOSS_DELAY_DURATION)
            }

    }

}

