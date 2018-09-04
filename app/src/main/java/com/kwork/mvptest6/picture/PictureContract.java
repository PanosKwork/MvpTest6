package com.kwork.mvptest6.picture;



import com.kwork.mvptest6.BasePresenter;
import com.kwork.mvptest6.BaseView;
import com.kwork.mvptest6.data.Picture;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/13 17:29
 * Annotation：
 */
public interface PictureContract {
    interface View extends BaseView<Presenter>{
        void showLoading();
        void showPictures(List<Picture> pictures);
        void hideLoading();
    }

    interface Presenter extends BasePresenter{
        void loadPicture();
    }
}
