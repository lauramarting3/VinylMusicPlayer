/*
 * Copyright 2018 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.poupa.vinylmusicplayer.util;

import android.content.ComponentName;
import android.content.Context;
//import com.poupa.vinylmusicplayer.viewmodels.MediaItemFragmentViewModel
import com.poupa.vinylmusicplayer.service.MusicService;
import com.poupa.vinylmusicplayer.ui.viewmodels.MainActivityViewModel;

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
public class InjectorUtils {
    public static MediaSessionConnection provideMediaSessionConnection(Context context) {
        ComponentName componentName = new ComponentName(context, MusicService.class);
        return MediaSessionConnection.Companion.getInstance(context, componentName);
    }

    public static MainActivityViewModel.Factory provideMainActivityViewModel(Context context) {
        Context applicationContext = context.getApplicationContext();
        MediaSessionConnection mediaSessionConnection = provideMediaSessionConnection(applicationContext);
        return new MainActivityViewModel.Factory(mediaSessionConnection);
    }

    /*fun provideMediaItemFragmentViewModel(context: Context, mediaId: String)
            : MediaItemFragmentViewModel.Factory {
        val applicationContext = context.applicationContext
        val mediaSessionConnection = provideMediaSessionConnection(applicationContext)
        return MediaItemFragmentViewModel.Factory(mediaId, mediaSessionConnection)
    }*/
}