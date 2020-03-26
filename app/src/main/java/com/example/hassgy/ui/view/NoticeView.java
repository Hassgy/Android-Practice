package com.example.hassgy.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.hassgy.application.cm.NoticeCM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ulfy.android.adapter.RecyclerAdapter;
import com.ulfy.android.mvvm.IViewModel;
import com.ulfy.android.task_transponder.RecyclerViewPageLoader;
import com.ulfy.android.task_transponder_smart.SmartRefresher;
import com.ulfy.android.ui_injection.Layout;
import com.ulfy.android.ui_injection.ViewById;
import com.example.hassgy.R;
import com.example.hassgy.application.vm.NoticeVM;
import com.example.hassgy.ui.base.BaseView;
import com.ulfy.android.utils.RecyclerViewUtils;
import com.ulfy.android.utils.UiUtils;

@Layout(id = R.layout.view_notice)
public class NoticeView extends BaseView {
    @ViewById(id = R.id.noticeSRL) private SmartRefreshLayout noticeSRL;
    @ViewById(id = R.id.noticeRLV) private RecyclerView noticeRLV;
    private RecyclerAdapter<NoticeCM> noticeAdapter = new RecyclerAdapter<>();
    private SmartRefresher noticeRefresher;
    private RecyclerViewPageLoader noticeLoader;
    private NoticeVM vm;

    public NoticeView(Context context) {
        super(context);
        init(context, null);
    }

    public NoticeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        RecyclerViewUtils.linearLayout(noticeRLV).vertical().dividerDp(Color.TRANSPARENT, 10, 0, 1);
        noticeRLV.setAdapter(noticeAdapter);
        noticeAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener<NoticeCM>() {
            @Override public void onItemClick(ViewGroup parent, View view, int position, NoticeCM model) {

//                MessageActivity.startActivity(model.notice);
                UiUtils.show(String.format("点击了：%d", position));

            }
        });
        noticeRefresher = new SmartRefresher(noticeSRL, new SmartRefresher.OnRefreshSuccessListener() {
            @Override public void onRefreshSuccess(SmartRefresher smartRefresher) {
                bind(vm);
            }
        });
        noticeLoader = new RecyclerViewPageLoader(noticeRLV, noticeAdapter, null);
    }

    @Override public void bind(IViewModel model) {
        vm = (NoticeVM) model;

        noticeRefresher.updateExecuteBody(vm.taskInfo, vm.loadDataPerPageOnExe());
        noticeLoader.updateExecuteBody(vm.taskInfo, vm.loadDataPerPageOnExe());

        noticeAdapter.setData(vm.noticeCMList);
        noticeAdapter.notifyDataSetChanged();
        noticeLoader.notifyDataSetChanged();

    }
}