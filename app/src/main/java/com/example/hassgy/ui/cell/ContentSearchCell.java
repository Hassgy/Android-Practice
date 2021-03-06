package com.example.hassgy.ui.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.ulfy.android.image.ImageUtils;
import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.application.cm.ContentSearchCM;
import com.example.hassgy.ui.base.BaseCell;

@Layout(id = R.layout.cell_content_search)
public class ContentSearchCell extends BaseCell {
    @ViewById(id = R.id.coverIV) private ImageView coverIV;
    @ViewById(id = R.id.nameTV) private TextView nameTV;
    @ViewById(id = R.id.timeTV) private TextView timeTV;
    private ContentSearchCM cm;

    public ContentSearchCell(Context context) {
        super(context);
        init(context, null);
    }

    public ContentSearchCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    @Override public void bind(IViewModel model) {
        cm = (ContentSearchCM) model;

        ImageUtils.loadImage(cm.contentSearch.cover, R.drawable.drawable_loading, coverIV);
        nameTV.setText(cm.contentSearch.name);
        timeTV.setText(String.format("%d次观看", cm.contentSearch.time));

    }
}