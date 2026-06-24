package com.example.youtubesearchapp;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class youtuberesponse {
    @SerializedName("items")
    private List<VideoItem> items;

    public List<VideoItem> getItems() { return items; }

    public static class VideoItem {
        @SerializedName("id")
        private VideoId id;

        @SerializedName("snippet")
        private VideoSnippet snippet;

        public VideoId getId() { return id; }
        public VideoSnippet getSnippet() { return snippet; }
    }

    public static class VideoId {
        @SerializedName("videoId")
        private String videoId;

        public String getVideoId() { return videoId; }
    }

    public static class VideoSnippet {
        @SerializedName("title")
        private String title;

        @SerializedName("description")
        private String description;

        @SerializedName("publishedAt")
        private String publishedAt;

        @SerializedName("channelTitle")
        private String channelTitle;

        @SerializedName("thumbnails")
        private Thumbnails thumbnails;

        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getPublishedAt() { return publishedAt; }
        public String getChannelTitle() { return channelTitle; }
        public Thumbnails getThumbnails() { return thumbnails; }
    }

    public static class Thumbnails {
        @SerializedName("high")
        private ThumbnailUrl high;

        public ThumbnailUrl getHigh() { return high; }
    }

    public static class ThumbnailUrl {
        @SerializedName("url")
        private String url;

        public String getUrl() { return url; }
    }
}