package savi.app.architecturedesignpattern

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.ThreadLocalRandom

class Coin {

    val tossLiveData = MutableLiveData<String>()

    val tossResourceLiveData = MutableLiveData<Int>()

    var tossSubject = PublishSubject.create<String>()

    //Business Logic for Toss
    fun toss() : String {
        return if(ThreadLocalRandom.current().nextInt(0,2) == 0) " Head" else "Tails"
    }

    fun tossAndUpdateLiveData(){
        tossLiveData.value = toss()
    }

    fun tossWithResource(){
        tossResourceLiveData.value = if(ThreadLocalRandom.current().nextInt(0,2) == 0)
            R.string.heads_text else R.string.tails_text
    }

    fun tossAndUpdateSubject() {
        tossSubject.onNext(toss())
    }

}