package com.scut.team.ui.activitys;

import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;
import com.yydcdut.sdlv.SlideAndDragListView;

/**
 * 程序主界面
 */
public class MainActivity extends BasePageActivity {
    private SlideAndDragListView mListView;
    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        mListView = (SlideAndDragListView)findViewById(R.id.main_lv_my_board);
    }
}
