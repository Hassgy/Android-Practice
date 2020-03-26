package com.example.hassgy.ui.cell;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.application.cm.NoticeCM;
import com.example.hassgy.ui.base.BaseCell;

@Layout(id = R.layout.cell_notice)
public class NoticeCell extends BaseCell {
    @ViewById(id = R.id.textTV) private TextView textTV;
    private NoticeCM cm;

    public NoticeCell(Context context) {
        super(context);
        init(context, null);
    }

    public NoticeCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    @Override public void bind(IViewModel model) {
        cm = (NoticeCM) model;

        // 动态设置样式
        textTV.setTextColor(cm.picked ? Color.BLACK : Color.GRAY);

    }
}