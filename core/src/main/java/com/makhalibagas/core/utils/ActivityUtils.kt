package com.makhalibagas.core.utils

import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * Created by Gabor Varadi on Medium (23-02-2020)
 * @see <a href="https://zhuinden.medium.com/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c">Simple one-liner ViewBinding </a>
 *
 * */
inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T,
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

/**
 * Created by Phillip Lackner (09-12-2021)
 * @see <a href="https://github.com/philipplackner/KotlinFlowsGuide/blob/cb1a28bb79701dd52b7cbdd553bfa50fce6c9a16/app/src/main/java/com/plcoding/kotlinflows/MainActivity.kt">KotlinFlowsGuide</a>
 *
 * */
fun <T> ComponentActivity.collectLifecycleFlow(flow: Flow<T>, collect: FlowCollector<T>) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect(collect)
        }
    }
}