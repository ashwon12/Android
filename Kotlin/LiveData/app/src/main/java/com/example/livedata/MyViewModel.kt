package com.example.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class MyViewModel : ViewModel() {

    //mutableLiveData - 수정가능, 내부에서 사용
    //LiveDate - 수정불가능, 읽기전용 외부에서 사용

    //1. LiveData 인스턴스 생성
    private val _currentValue = MutableLiveData<Int>()
    val currentValue : LiveData<Int>
        get() = _currentValue

    init {
        Log.d("로그", "생성자 호출")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input : Int){
        //뷰모델 값을 변경시키는 메서드
        when(actionType){
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }

}

