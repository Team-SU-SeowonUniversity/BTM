package com.teamsu.presentation.main.zone.gamezone.perception.game.shadowmatching

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import java.util.Random

class ShadowMatchingViewModel: ViewModel() {
    private val _answer = mutableStateOf(0)
    val answer: State<Int> = _answer

    private val mutableSetList = mutableSetOf<Int>()

    var viewList = mutableStateListOf<Int>()

    fun start(
        shadowImage: List<Painter>,
        generalImage: List<Painter>
    ) {
        val random = Random()

        _answer.value = random.nextInt(shadowImage.size)

        mutableSetList.add(_answer.value)

        while(mutableSetList.size < 4) {
            val num = random.nextInt(generalImage.size)
            mutableSetList.add(num)
        }

        viewList = mutableSetList.toMutableStateList()

        viewList.shuffle()
    }
}