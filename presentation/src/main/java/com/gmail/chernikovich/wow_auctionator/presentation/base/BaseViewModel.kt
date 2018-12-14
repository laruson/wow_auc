package com.gmail.chernikovich.wow_auctionator.presentation.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel<R : BaseRouter<*>> : ViewModel() {
    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    protected var router: R? = null
    fun addRouter(router: R?) {
        this.router = router
    }

    fun removeRouter() {
        router = null
    }

    protected fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}