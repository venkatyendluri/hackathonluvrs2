package com.example.hackathong


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var camera_open_id: Button? = null
    private var click_image_id: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camera_open_id = findViewById<View>(R.id.camera_button) as ImageButton
        click_image_id = findViewById<View>(R.id.click_image) as ImageView


        camera_open_id!!.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)


            startActivityForResult(camera_intent, pic_id)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == pic_id) {


            val photo = data!!.extras
                ?.get("data") as Bitmap?


            click_image_id!!.setImageBitmap(photo)
        }
    }

    companion object {

        private const val pic_id = 123
    }
}


