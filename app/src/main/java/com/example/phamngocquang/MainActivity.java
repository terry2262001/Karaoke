package com.example.phamngocquang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.phamngocquang.Adapter.SongAdapter;
import com.example.phamngocquang.Model.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.onItemClickListener{

    public RecyclerView rcvSong;
    public ArrayList<Song> songList;
    public SongAdapter songAdapter;
    public Context mContext;
    static final int ADD_SONG_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvSong = findViewById(R.id.rcvSong);
        mContext = getApplicationContext();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rcvSong.setLayoutManager(linearLayoutManager);
        rcvSong.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        songList = new ArrayList<>();

        songAdapter = new SongAdapter(mContext, songList,this);
        rcvSong.setAdapter(songAdapter);
        initData();
        registerForContextMenu(rcvSong);
    }

    private void initData() {
        songList.clear();
        songList.addAll(fakeSongData());
        songAdapter.notifyDataSetChanged();

    }


    public ArrayList<Song> fakeSongData(){
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(10101,"Thu Cuối 1","Song Luân",false));
        songs.add(new Song(10102,"Thu Cuối 2",  "Song Luân",true));
        songs.add(new Song(10103,"Thu Cuối 3","Song Luân",false));
        songs.add(new Song(10104,"Thu Cuối 4","Song Luân",true));
        songs.add(new Song(10105,"Thu Cuối 5","Song Luân",false));
        songs.add(new Song(10106,"Thu Cuối 6","Song Luân",true));
        songs.add(new Song(10107,"Thu Cuối 7","Song Luân",false));
        songs.add(new Song(10108,"Thu Cuối 8","Song Luân",true));
        songs.add(new Song(10109,"Thu Cuối 9","Song Luân",false));
        songs.add(new Song(101010,"Thu Cuối 10","Song Luân",true));

        return songs;
    }

    @Override
    public void OnItemClick(Song song, int pos) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("song", song);
        Intent intent = new Intent(this,SongDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.add:
                Intent intent = new Intent(MainActivity.this, AddSong.class);
                startActivityForResult(intent, ADD_SONG_REQUEST);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_SONG_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                Song newSong = (Song) data.getSerializableExtra("newSong");
                int sizeTemp = songList.size();
                songList.add(newSong);
                if (songList.size() > sizeTemp){
                    Toast.makeText(getApplicationContext(), "Thêm thành công bài hát "+newSong.getNameSong()+"vào danh sách. ", Toast.LENGTH_SHORT).show();
                }
                songAdapter.notifyDataSetChanged();
            }
        }
    }
}
