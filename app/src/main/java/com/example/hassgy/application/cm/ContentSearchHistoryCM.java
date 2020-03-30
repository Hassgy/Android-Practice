package com.example.hassgy.application.cm;

import com.ulfy.android.mvvm.IView;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.utils.LogUtils;
import com.example.hassgy.application.base.BaseCM;
import com.example.hassgy.ui.cell.ContentSearchHistoryCell;

public class ContentSearchHistoryCM extends BaseCM {

    public String text;

    public ContentSearchHistoryCM(String text) {
        this.text = text;
    }

    @Override public Class<? extends IView> getViewClass() {
        return ContentSearchHistoryCell.class;
    }
}