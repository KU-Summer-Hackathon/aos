package com.yjooooo.doreandroid.presentation.help_request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.repository.HelpRepository
import com.yjooooo.doreandroid.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import timber.log.Timber
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class HelpRequestViewModel @Inject constructor(
    private val helpRepository: HelpRepository
) : ViewModel() {
    val content = MutableLiveData("")

    private val _imgCount = MutableLiveData(0)
    val imgCount: LiveData<Int> = _imgCount

    private val _isCancelRequest = MutableLiveData<Event<Boolean>>()
    val isCancelRequest: LiveData<Event<Boolean>> = _isCancelRequest

    private val _imgUrl1 = MutableLiveData<String>()
    var imgUrl1: LiveData<String> = _imgUrl1

    private val _imgUrl2 = MutableLiveData<String>()
    var imgUrl2: LiveData<String> = _imgUrl2

    private val map = mutableMapOf<String, @JvmSuppressWildcards RequestBody>()

    private val images = ArrayList<MultipartBody.Part>()

    private val _isSuccessRequest = MutableLiveData<Event<Boolean>>()
    val isSuccessRequest: LiveData<Event<Boolean>> = _isSuccessRequest

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

    fun postHelpRequest() {
        map["content"] =
            requireNotNull(content.value).toRequestBody("text/plain".toMediaTypeOrNull())
        viewModelScope.launch {
            helpRepository.postHelpRequest(map, images)
                .onSuccess { response ->
                    Timber.tag("HelpRequest_postHelpRequest").d((response.toString()))
                    _isSuccessRequest.postValue(Event(response.data))
                }
                .onFailure {
                    Timber.tag("HelpRequest_postHelpRequest").d((it.message.toString()))
                }
        }
    }
}
