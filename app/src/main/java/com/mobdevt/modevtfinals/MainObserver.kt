package com.mobdevt.modevtfinals

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainObserver: LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("kek", "MainActivity is CREATED")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun show() {
        Log.i("kek", "Screen is VISIBLE")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun hide() {
        Log.i("kek", "MainActivity is HIDDEN")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onClose() {
        Log.i("kek", "MainActivity is DESTROYED")
    }


}