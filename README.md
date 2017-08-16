# exo_player_demo

This is a simple demo project of android exo player library. 
In this project, mp3 and video can be played from your device and from internet.

Gradle: compile 'com.google.android.exoplayer:exoplayer:r2.4.0'

Starting with API level 24 Android supports multiple windows. 
As our app can be visible but not active in split window mode, 
we need to initialize the player in onStart. Before API level 24 
we wait as long as possible until we grab resources, 
so we wait until onResume before initializing the player.

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideSystemUi();
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer();
        }
    }


BTW: hideSystemUi called in onResume is just an implementation detail 
to have a pure full screen experience:

    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

Accordingly we need to release resources with the yet to be created releasePlayer 
method in onPause and onStop:

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }



Before API Level 24 there is no guarantee of onStop being called. 
So we have to release the player as early as possible in onPause. 
Starting with API Level 24 (which brought multi and split window mode) 
onStop is guaranteed to be called and in the paused mode our activity is eventually still visible.
 Hence we need to wait releasing until onStop.

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


