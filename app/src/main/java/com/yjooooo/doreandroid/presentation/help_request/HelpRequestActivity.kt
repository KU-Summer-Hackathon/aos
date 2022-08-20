package com.yjooooo.doreandroid.presentation.help_request

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpRequestBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.util.EventObserver
import com.yjooooo.doreandroid.util.getImgUri
import com.yjooooo.doreandroid.util.getPathFromUri
import timber.log.Timber
import java.io.File
import java.lang.NullPointerException

class HelpRequestActivity :
    BaseActivity<ActivityHelpRequestBinding>(R.layout.activity_help_request) {
    private val helpRequestViewModel by viewModels<HelpRequestViewModel>()

    private var imgUri: Uri? = null

    private val fromCameraActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        imgUri?.let { uri ->
            Thread.sleep(700)
            if (File(getPathFromUri(this, uri)).exists()) {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCloseBtnClickListener()
        initIsCancelRequestObserver()
        initAddImgClickListener()
    }

    private fun initCloseBtnClickListener() {
        binding.btnHelpRequestClose.setOnClickListener {
            HelpRequestDialogFragment().show(supportFragmentManager, this.javaClass.name)
        }
    }

    private fun initIsCancelRequestObserver() {
        helpRequestViewModel.isCancelRequest.observe(this, EventObserver { isCancel ->
            if (isCancel) {
                finish()
            }
        })
    }

    private fun initAddImgClickListener() {
        binding.btnHelpRequestAddImg.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                if (checkCameraPermission()) {
                    takePicture()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CAMERA),
                        REQUEST_CAMERA_PERMISSION
                    )
                }
            } else {
                if (checkCameraPermissionUnderQ()) {
                    takePicture()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                            android.Manifest.permission.CAMERA,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ),
                        REQUEST_CAMERA_PERMISSION_UNDER_Q
                    )
                }
            }
        }
    }

    private fun checkCameraPermission() =
        ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermissionUnderQ() =
        checkCameraPermission() && ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    private fun takePicture() {
        try {
            imgUri = getImgUri(this.contentResolver)
                ?: throw NullPointerException()
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.putExtra(MediaStore.EXTRA_OUTPUT, imgUri)
                fromCameraActivityLauncher.launch(it)
            }
        } catch (e: NullPointerException) {
            Timber.tag("ProfileBottomSheet").e("ImgUri Null 에러")
        }
    }

    companion object {
        private const val IMG_URI = "imgUri"
        const val REQUEST_CAMERA_PERMISSION = 1
        const val REQUEST_CAMERA_PERMISSION_UNDER_Q = 2
    }
}
