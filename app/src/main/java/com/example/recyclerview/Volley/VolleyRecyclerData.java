package com.example.recyclerview.Volley;

public class VolleyRecyclerData {
    private int ImageView_title;
    private String TextView_title;
    private String TextView_content;

    public VolleyRecyclerData(int imageView_title, String textView_title, String textView_content) {
        ImageView_title = imageView_title;
        TextView_title = textView_title;
        TextView_content = textView_content;
    }

    public int getImageView_title() {
        return ImageView_title;
    }

    public void setImageView_title(int imageView_title) {
        ImageView_title = imageView_title;
    }

    public String getTextView_title() {
        return TextView_title;
    }

    public void setTextView_title(String textView_title) {
        TextView_title = textView_title;
    }

    public String getTextView_content() {
        return TextView_content;
    }

    public void setTextView_content(String textView_content) {
        TextView_content = textView_content;
    }
}
