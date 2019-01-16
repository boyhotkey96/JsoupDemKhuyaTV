package com.boyhotkey96.jsoupdemkhuyatv;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class XemBongDa extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private String path = "";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_bong_da);
        videoView = findViewById(R.id.videoView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            path = bundle.getString("LINK-VIDEO");

            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            progressDialog = new ProgressDialog(XemBongDa.this);
            progressDialog.setTitle("Connecting server");
            progressDialog.setMessage("Please Wait... ");
            progressDialog.setCancelable(false);
            progressDialog.show();
            if (progressDialog.isShowing()) {
                Uri uri = Uri.parse(path);
                videoView.setVideoURI(uri);
                videoView.start();

                mediaController = new MediaController(this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
                videoView.requestFocus();
            }
            progressDialog.dismiss();
        }
    }
}
