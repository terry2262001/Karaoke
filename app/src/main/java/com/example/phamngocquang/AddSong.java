package com.example.phamngocquang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phamngocquang.Model.Song;

public class AddSong extends AppCompatActivity {
    EditText etId,etNameSong,etNameAuthor;
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        etId = findViewById(R.id.etId);
        etNameSong = findViewById(R.id.etNameSong);
        etNameAuthor = findViewById(R.id.etNameAuthor);
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etId.getText().toString().trim().isEmpty() && !etNameSong.getText().toString().trim().isEmpty() && !etNameAuthor.getText().toString().trim().isEmpty()){
                    int id = Integer.parseInt(etId.getText().toString());
                    String nameSong = etNameSong.getText().toString();
                    String nameAuthor = etNameAuthor.getText().toString();
                    Song newSong = new Song(id,nameSong,nameAuthor,false);
                    Intent intent = getIntent();
                    intent.putExtra("newSong", newSong);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Không được để trống các trường !!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}