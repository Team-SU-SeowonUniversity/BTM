package com.teamsu.presentation.main.zone.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Timer
import kotlin.concurrent.timer

class CountDownViewModel : ViewModel() {
    private var timerTask: Timer? = null

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning

    private val _sec = mutableStateOf(1)
    val sec: State<Int> = _sec

    fun start(count: Int) {
        _isRunning.value = true
        _sec.value = count

        timerTask = timer(period = 1000) {
            _sec.value--
        }
    }

    fun stop() {
        _isRunning.value = false
        timerTask?.cancel()

        _sec.value = 1
    }

    fun delay() {

    }
}
