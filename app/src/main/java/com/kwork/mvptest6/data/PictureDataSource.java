package com.kwork.mvptest6.data;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/14 08:49
 * Annotation：
 */
public interface PictureDataSource {
    interface LoadPictureCallback{
        void onLoadComplete(List<Picture> pictures);
    }
    void loadPictures(LoadPictureCallback callback);


}
