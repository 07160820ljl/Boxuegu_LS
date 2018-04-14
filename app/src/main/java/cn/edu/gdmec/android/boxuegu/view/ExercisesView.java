package cn.edu.gdmec.android.boxuegu.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.boxuegu.R;
import cn.edu.gdmec.android.boxuegu.adapter.ExercisesAdapter;
import cn.edu.gdmec.android.boxuegu.bean.ExercisesBean;

/**
 * Created by Administrator on 2018/4/13.
 */

public class ExercisesView {
    private ListView lv_list;
    private ExercisesAdapter adapter;
    private List<ExercisesBean> eb1;
    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;

    public ExercisesView(Activity context) {
        mContext = context;
        //为之后将Layout转化为View时用
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
    }

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_exercises, null);
        lv_list = (ListView) mCurrentView.findViewById(R.id.lv_list);
        adapter = new ExercisesAdapter(mContext);
        initData();
        adapter.setData(eb1);
        lv_list.setAdapter(adapter);
    }

    /**
     * 设置数据
     */
    private void initData() {
        eb1 = new ArrayList<ExercisesBean>();
        for (int i = 0; i < 10; i++) {
            ExercisesBean bean = new ExercisesBean();
            bean.id = (i + 1);
            switch (i) {
                case 0:
                    bean.title = "第1章Android基础入门";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title = "第2章Android UI 开发";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title = "第3章Activity";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title = "第4章数据存储";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title = "第5章SQLite数据库";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title = "第6章广播接受者";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_2);
                    break;
                case 6:
                    bean.title = "第7章服务";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_3);
                    break;
                case 7:
                    bean.title = "第8章内容提供者";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_4);
                    break;
                case 8:
                    bean.title = "第9章网络编程";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_1);
                    break;
                case 9:
                    bean.title = "第10章高级编程";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_2);
                    break;
                default:
                    break;
            }
            eb1.add(bean);
        }

    }

    /**
     * 获取当前在导航栏上方显示对应的View
     */
    public View getView() {
        if (mCurrentView == null) {
            createView();
        }
        return mCurrentView;
    }

    /**
     * 显示当前导航栏上方对应的View 界面
     */
    public void showView() {
        if (mCurrentView == null) {
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }
}
