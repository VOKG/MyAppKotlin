package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.myapplication.data.Todo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_first.*


class RxJavaBasicDialogFragment : DialogFragment() {

    private lateinit var mDisposable: Disposable
    private var mResult: String = ""
    private lateinit var resultTextView: TextView

    companion object {
        fun newInstance(): RxJavaBasicDialogFragment {
            return RxJavaBasicDialogFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodsObservable = getFoodsObservable()
        val foodsObserver = getFoodsObserver()
       resultTextView = textView.findViewById(R.id.text_view_id) as TextView

        foodsObservable
            .subscribeOn(Schedulers.io())//это дает команду Observable запускать задачу в фоновом потоке
            .observeOn(AndroidSchedulers.mainThread())//Observer будет получать данные в потоке пользовательского
// интерфейса Android, чтобы разработчики могли выполнять действия в потоке пользовательского интерфейса при получении данных.
            .subscribe(foodsObserver)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    private fun getFoodsObservable(): Observable<String> {
        return Observable.just("Apple", "Bacon", "Cacao", "Dumpling", "Fish")
    }

    private fun getFoodsObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.i("onSubscribe", d.toString())
                mDisposable = d
            }

            override fun onNext(t: String) {
                Log.i("onNext", t)
                mResult += "$t, "
            }

            override fun onError(e: Throwable) {
                Log.i("onError", e.toString())
            }

            override fun onComplete() {
                Log.i("onComplete", "DONE!!")
                 resultTextView.text = mResult
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mDisposable.dispose()
    }
}




















