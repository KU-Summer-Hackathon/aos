package com.yjooooo.doreandroid.presentation.lamp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Field
import timber.log.Timber
import javax.inject.Inject


class LampViewModel @Inject constructor() : ViewModel() {
    private val map = HashMap<String, String>()

    fun postKakaoPayment() {
        map["cid"] = "TC0ONETIME"
        map["partner_order_id"] = "0"
        map["partner_user_id"] = "0"
        map["item_name"] = "램프"
        map["quantity"] = "5"
        map["total_amount"] = "11"
        map["tax_free_amount"] = "0"
        map["approval_url"] =
            "https://developers.kakao.com/success"
        map["cancel_url"] =
            "https://developers.kakao.com/success"
        map["fail_url"] =
            "https://developers.kakao.com/success"

    }
}
