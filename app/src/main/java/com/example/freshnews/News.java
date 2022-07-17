package com.example.freshnews;

class News {

        // define data fields
        String title , author , url , imageUrl;

        // create a constructor
        public News(String title , String author , String url, String imageUrl)
        {
                this.title = title;
                this.author = author;
                this.url = url;
                this.imageUrl = imageUrl;

        }

        // getter & setter

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }
}
