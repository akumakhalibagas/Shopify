package com.makhalibagas.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * Flow collector for ViewModel
 * @see [launch]
 *
 * @param flow flow to be collected
 * @param collect lambda function to collect items
 * */
fun <T> ViewModel.collectLifecycleFlow(flow: Flow<T>, collect: FlowCollector<T>): Job =
    viewModelScope.launch {
        flow.collect(collect)
    }