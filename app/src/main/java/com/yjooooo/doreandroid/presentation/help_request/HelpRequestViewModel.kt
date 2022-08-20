package com.yjooooo.doreandroid.presentation.help_request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.doreandroid.util.Event
import okhttp3.MultipartBody
import java.lang.IllegalArgumentException

class HelpRequestViewModel : ViewModel() {
    private val _imgCount = MutableLiveData(0)
    val imgCount: LiveData<Int> = _imgCount

    private val _isCancelRequest = MutableLiveData<Event<Boolean>>()
    val isCancelRequest: LiveData<Event<Boolean>> = _isCancelRequest

    private val _imgUrl1 = MutableLiveData<String>()
    var imgUrl1: LiveData<String> = _imgUrl1

    private val _imgUrl2 = MutableLiveData<String>()
    var imgUrl2: LiveData<String> = _imgUrl2

    val images = ArrayList<MultipartBody.Part>()

    fun initIsCancelRequest(isCancel: Boolean) {
        _isCancelRequest.value = Event(isCancel)
    }

    fun increaseImgCount() {
        _imgCount.value = requireNotNull(_imgCount.value) + 1
    }

    fun addImage(img: MultipartBody.Part) {
        images.add(img)
    }

    fun initImgUrl(url: String) {
        when (imgCount.value) {
            0 -> _imgUrl1.value = url
            1 -> _imgUrl2.value = url
            else -> throw IllegalArgumentException()
        }
    }
}
