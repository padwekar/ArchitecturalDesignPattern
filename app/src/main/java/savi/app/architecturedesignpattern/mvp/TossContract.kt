package savi.app.architecturedesignpattern.mvp

import android.support.annotation.ColorRes

interface TossContract {

    interface View {
        fun setScreenTitle(title: String)
        fun setBackgroundColor(@ColorRes colorRes: Int)
        fun setProgressBarVisibility(visibility: Int)
        fun setResultTextViewVisibility(visibility: Int)
        fun setResultText(result: String)
    }

    interface Presenter {
        fun onViewCreated()
        fun onTossButtonClicked()
    }

}