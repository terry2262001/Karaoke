package com.example.phamngocquang.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phamngocquang.Model.Song;
import com.example.phamngocquang.R;
import com.example.phamngocquang.SongDetailActivity;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongVH>{
    private Context mContext;
    private ArrayList<Song> songList;
    onItemClickListener listener;

    public SongAdapter(Context mContext, ArrayList<Song> songList) {
        this.mContext = mContext;
        this.songList = songList;
    }
    public SongAdapter(Context mContext, ArrayList<Song> songList, onItemClickListener listener) {
        this.mContext = mContext;
        this.songList = songList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public SongVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.song_item,parent,false);
        return new SongAdapter.SongVH(view);
    }

    @Override

    public void onBindViewHolder(@NonNull SongVH holder, @SuppressLint("RecyclerView") int position) {
        Song song = songList.get(position);
        holder.tvId.setText(String.valueOf(song.getId()));
        holder.tvNameSong.setText(song.getNameSong());
        holder.tvNameAuthor.setText(song.getNameAuthor());
        if(song.isLike){
            holder.imgLike.setVisibility(View.VISIBLE);
            holder.imgDisLike.setVisibility(View.GONE);
        }else{
            holder.imgLike.setVisibility(View.GONE);
            holder.imgDisLike.setVisibility(View.VISIBLE);
        }
        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.setLike(false);
                holder.imgLike.setVisibility(View.GONE);
                holder.imgDisLike.setVisibility(View.VISIBLE);
                songList.set(position,song);

            }
        });
        holder.imgDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.setLike(true);
                holder.imgLike.setVisibility(View.VISIBLE);
                holder.imgDisLike.setVisibility(View.GONE);
                songList.set(position,song);

            }
        });
        holder.imgAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("song", song);
                Intent intent = new Intent(mContext, SongDetailActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnItemClick(song,position);
            }
        });


    }
    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class SongVH extends RecyclerView.ViewHolder {
        ImageButton imgLike,imgDisLike,imgAbout,imgDelete;
        TextView tvId,tvNameSong,tvNameAuthor;

        public SongVH(@NonNull View itemView) {
            super(itemView);
            imgLike = itemView.findViewById(R.id.imgLike);
            imgDisLike = itemView.findViewById(R.id.imgDisLike);
            imgAbout  = itemView.findViewById(R.id.imgAbout);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            tvId = itemView.findViewById(R.id.tvId);
            tvNameSong  = itemView.findViewById(R.id.tvNameSong);
            tvNameAuthor = itemView.findViewById(R.id.tvNameAuthor);

        }
    }
    public interface onItemClickListener{
        void OnItemClick( Song product, int pos);
    }
}


