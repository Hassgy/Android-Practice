package com.example.hassgy.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.application.vm.MovieDetailsVM;
import com.example.hassgy.ui.base.BaseView;

@Layout(id = R.layout.view_movie_detials)
public class MovieDetailsView extends BaseView {
    private MovieDetailsVM vm;

    public MovieDetailsView(Context context) {
        super(context);
        init(context, null);
    }

    public MovieDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    @Override public void bind(IViewModel model) {
        vm = (MovieDetailsVM) model;
    }
}