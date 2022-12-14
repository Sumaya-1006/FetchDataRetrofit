package com.example.fetchdataretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context context;
    List<Posts> postsList;

    public PostAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.title.setText(postsList.get(position).getTitle());
        holder.id.setText(String.valueOf(postsList.get(position).getId()));
        holder.albumId.setText(String.valueOf(postsList.get(position).getAlbumId()));
        holder.url.setText(String.valueOf(postsList.get(position).getUrl()));
        holder.thumbnail.setText(String.valueOf(postsList.get(position).getThumbnailUrl()));


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
class PostViewHolder extends RecyclerView.ViewHolder {
    TextView title, url, albumId,id,thumbnail;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleId);
        url = itemView.findViewById(R.id.urlId);
        albumId = itemView.findViewById(R.id.albumId);
        id = itemView.findViewById(R.id.nameId);
        thumbnail = itemView.findViewById(R.id.thumbnailUrlId);
    }
}

