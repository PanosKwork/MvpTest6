package com.kwork.mvptest6.picture;

import android.os.Handler;

import com.kwork.mvptest6.data.Picture;
import com.kwork.mvptest6.data.PictureDataSource;
import com.kwork.mvptest6.data.PictureRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/14 08:27
 * Annotation：
 */
public class PicturePresenter implements PictureContract.Presenter {
    private PictureContract.View view;
    private PictureRepository repository;

    public PicturePresenter(PictureContract.View view) {
        this.view = view;
        repository = new PictureRepository();
        view.setPresenter(this);
    }

    @Override
    public void loadPicture() {
        view.showLoading();
        repository.loadPictures(new PictureDataSource.LoadPictureCallback() {
            @Override
            public void onLoadComplete(final List<Picture> pictures) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.showPictures(pictures);
                    }
                },3000);
                view.hideLoading();
            }
        });
    }

    @Override
    public void start() {
        loadPicture();
    }
}
