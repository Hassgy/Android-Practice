package com.example.hassgy.application.cm;

import com.example.hassgy.domain.entity.ContentSearch;
import com.ulfy.android.mvvm.IView;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.utils.LogUtils;
import com.example.hassgy.application.base.BaseCM;
import com.example.hassgy.ui.cell.ContentSearchCell;

public class ContentSearchCM extends BaseCM {

    public ContentSearch contentSearch;

    public ContentSearchCM(ContentSearch contentSearch) {
        this.contentSearch = contentSearch;
    }

    @Override public Class<? extends IView> getViewClass() {
        return ContentSearchCell.class;
    }
}