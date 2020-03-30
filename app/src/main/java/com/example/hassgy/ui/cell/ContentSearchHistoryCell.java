package com.example.hassgy.ui.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.application.cm.ContentSearchHistoryCM;
import com.example.hassgy.ui.base.BaseCell;

@Layout(id = R.layout.cell_content_search_history)
public class ContentSearchHistoryCell extends BaseCell {
    @ViewById(id = R.id.nameTV) private TextView nameTV;
    private ContentSearchHistoryCM cm;

    public ContentSearchHistoryCell(Context context) {
        super(context);
        init(context, null);
    }

    public ContentSearchHistoryCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    @Override public void bind(IViewModel model) {
        cm = (ContentSearchHistoryCM) model;
        nameTV.setText(cm.text);
    }
}