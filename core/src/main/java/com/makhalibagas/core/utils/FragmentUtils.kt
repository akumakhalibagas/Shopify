package com.makhalibagas.core.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch


fun <T> Fragment.collectLifecycleFlow(
    flow: Flow<T>,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    collect: FlowCollector<T>
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
            flow.collect(collect)
        }
    }
}

fun <T> BottomSheetDialogFragment.collectLifecycleFlow(flow: Flow<T>, collect: FlowCollector<T>) {
    this.lifecycleScope.launch {
        flow.collect(collect)
    }
}