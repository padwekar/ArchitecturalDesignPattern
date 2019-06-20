package savi.app.architecturedesignpattern.mvvm_live_data_binding

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import savi.app.architecturedesignpattern.R
import savi.app.architecturedesignpattern.databinding.ActivityBindingTossBinding

class MvvmTossBindingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ViewModelProviders.of(this).get(TossBindingViewModel::class.java).also {


            DataBindingUtil.setContentView<ActivityBindingTossBinding>(this@MvvmTossBindingActivity,R.layout.activity_binding_toss).apply {
                tossViewModel = it
                lifecycleOwner = this@MvvmTossBindingActivity
            }


        }.onViewCreated()

    }

}
