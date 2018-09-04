package com.kwork.mvptest6.picture;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kwork.mvptest6.R;
import com.kwork.mvptest6.data.Picture;
import com.kwork.mvptest6.data.PictureAdapter;
import com.kwork.mvptest6.data.PictureDataSource;
import com.kwork.mvptest6.data.PictureRepository;

import java.util.List;

/**
 * Author：PanosKwork
 * Time：2018/8/13 17:17
 * Annotation：
 */
public class PictureFragment extends Fragment implements PictureContract.View {

    private RecyclerView recyclerView;
    private View view;
    private PictureContract.Presenter mPresenter;
    private PictureAdapter adapter;
    private PictureRepository repository;

    /**
     * 必需的空的无参构造方法
     */
    public PictureFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_picture, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter = new PicturePresenter(this);
        mPresenter.start();
    }

    @Override
    public void showLoading() {
        Toast.makeText(getActivity(), "开始加载...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPictures(List<Picture> pictures) {
        if (pictures != null){
            adapter = new PictureAdapter(pictures);
            //LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }


    }

    @Override
    public void hideLoading() {
        Toast.makeText(getActivity(), "加载完成....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(PictureContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
