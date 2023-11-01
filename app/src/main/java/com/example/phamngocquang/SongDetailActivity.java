package com.example.phamngocquang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phamngocquang.Model.Song;


public class SongDetailActivity extends AppCompatActivity {
    ImageView imgLike,imgDisLike;
    TextView tvId,tvSong,tvAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        imgLike = findViewById(R.id.imgLike);
        imgDisLike = findViewById(R.id.imgDisLike);
        tvId = findViewById(R.id.tvId);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvSong = findViewById(R.id.tvSong);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Song song = (Song) bundle.getSerializable("song");
            if (song.isLike) {
                imgLike.setVisibility(View.VISIBLE);
                imgDisLike.setVisibility(View.GONE);
            } else {
                imgLike.setVisibility(View.GONE);
                imgDisLike.setVisibility(View.VISIBLE);
            }
            tvId.setText(String.valueOf(song.getId()));
            tvSong.setText(song.getNameSong());
            tvAuthor.setText(song.getNameAuthor());
        }
    }

}