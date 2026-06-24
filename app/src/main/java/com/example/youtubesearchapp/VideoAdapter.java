package com.example.youtubesearchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    private List<youtuberesponse.VideoItem> videoList;


    public VideoAdapter(Context context, List<youtuberesponse.VideoItem> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        youtuberesponse.VideoItem video = videoList.get(position);
        youtuberesponse.VideoSnippet snippet = video.getSnippet();


        holder.title.setText(snippet.getTitle());
        holder.channelTitle.setText(snippet.getChannelTitle());
        holder.publishedAt.setText(snippet.getPublishedAt());
        holder.description.setText(snippet.getDescription());


        String imageUrl = snippet.getThumbnails().getHigh().getUrl();
        Glide.with(context)
                .load(imageUrl)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return videoList != null ? videoList.size() : 0;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title, channelTitle, publishedAt, description;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.ivThumbnail);
            title = itemView.findViewById(R.id.tvTitle);
            channelTitle = itemView.findViewById(R.id.tvChannelTitle);
            publishedAt = itemView.findViewById(R.id.tvPublishedAt);
            description = itemView.findViewById(R.id.tvDescription);
        }
    }
}