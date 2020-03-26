package com.example.hassgy.application.vm;

import com.example.hassgy.application.cm.NoticeCM;
import com.ulfy.android.mvvm.IView;
import com.ulfy.android.task.LoadDataUiTask;
import com.ulfy.android.task.LoadListPageUiTask;
import com.ulfy.android.utils.LogUtils;
import com.example.hassgy.application.base.BaseVM;
import com.example.hassgy.ui.view.NoticeView;

import java.util.ArrayList;
import java.util.List;

public class NoticeVM extends BaseVM {
    public List<NoticeCM> noticeCMList = new ArrayList<>();
    public LoadListPageUiTask.LoadListPageUiTaskInfo<NoticeCM> taskInfo = new LoadListPageUiTask.LoadListPageUiTaskInfo<>(noticeCMList);


    public LoadListPageUiTask.OnLoadListPage loadDataPerPageOnExe() {
        return new LoadListPageUiTask.OnLoadSimpleListPage() {
            @Override protected void loadSimplePage(LoadListPageUiTask task, List<Object> modelList, List<Object> tempList, int page, int pageSize) throws Exception {

//                List<Notice> noticeList = 网络获取;
//                if (noticeList != null && noticeList.size() > 0) {
//                    for (Notice notice : noticeList) {
//                        tempList.add(new NoticeCM(notice));
//                    }
//                }
                Thread.sleep(1000);
                for (int i = 0; i < 40; i++){
                    tempList.add(new NoticeCM((page - 1) * 30 + i));
                }
            }
        };
    }

    // 循环遍历picked字段
    public void selectedNoticeCMListByIndex(int index) {
        for (int i = 0; i < noticeCMList.size(); i++) {
            noticeCMList.get(i).picked = i == index;
        }
    }


    @Override public Class<? extends IView> getViewClass() {
        return NoticeView.class;
    }
}