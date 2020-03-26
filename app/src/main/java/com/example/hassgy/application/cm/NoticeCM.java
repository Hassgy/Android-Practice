package com.example.hassgy.application.cm;

import com.ulfy.android.mvvm.IView;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.utils.LogUtils;
import com.example.hassgy.application.base.BaseCM;
import com.example.hassgy.ui.cell.NoticeCell;

public class NoticeCM extends BaseCM {

    public int index;
    // 列表项选中
    public boolean picked;

    public NoticeCM(int index) {
        this.index = index;
    }

    @Override public Class<? extends IView> getViewClass() {
        return NoticeCell.class;
    }
}