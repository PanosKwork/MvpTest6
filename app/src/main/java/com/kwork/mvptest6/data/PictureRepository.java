package com.kwork.mvptest6.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/14 08:53
 * Annotation：
 */
public class PictureRepository implements PictureDataSource {
    private List<Picture> pictureList;
    /**
     * @param callback
     * 提供获取数据的方法
     */
    @Override
    public void loadPictures(LoadPictureCallback callback) {
        pictureList = new ArrayList<>();
        pictureList.add(new Picture("http://oyur9br22.bkt.clouddn.com/fragment.jpg"));
        pictureList.add(new Picture("http://oyur9br22.bkt.clouddn.com/13%20Hours.jpg"));
        pictureList.add(new Picture("http://oyur9br22.bkt.clouddn.com/U-571%2810%29.png"));
        pictureList.add(new Picture("http://oyur9br22.bkt.clouddn.com/U-571%286%29.png"));
        pictureList.add(new Picture("http://oyur9br22.bkt.clouddn.com/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%288%29.png"));
        callback.onLoadComplete(pictureList);
    }
}
