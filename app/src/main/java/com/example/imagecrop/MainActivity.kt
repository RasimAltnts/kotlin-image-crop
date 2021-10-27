package com.example.imagecrop

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun chooseToİmage(view: View){
        CropImage.activity()
            .setGuidelines(CropImageView.Guidelines.ON)
            .start(this)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            val result:CropImage.ActivityResult = CropImage.getActivityResult(data)
            println("RequestCode : ${requestCode}")
            if(requestCode == 203){
                val resultUri: Uri = result.uri
                println(resultUri)
                val imageView:ImageView = findViewById(R.id.imageView)
                imageView.setImageURI(resultUri)



            }
            else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                val error:Exception = result.error
                println("E:${error}")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}