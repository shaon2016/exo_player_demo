# exo_player_demo

This is a simple demo project of android exo player library. 
In this project, mp3 and video can be played from your device and from internet.

Gradle: compile 'com.google.android.exoplayer:exoplayer:r2.4.0'

To play audio or video from internet, use this below code

    private MediaSource buildMediaSource(Uri uri) {
        return new ExtractorMediaSource(uri, new DefaultHttpDataSourceFactory("no_one"),
                new DefaultExtractorsFactory(), null, null);
    }
  
To play audio or video from your device, use this below code.

    private MediaSource buildLocalMediaSource(Uri uri) {
        return new ExtractorMediaSource(uri, new FileDataSourceFactory(),
                new DefaultExtractorsFactory(), null, null);
    }


# Any help will be appreciated
