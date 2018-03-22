package cn.edu.gdmec.android.boxuegu.activity;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import cn.edu.gdmec.android.boxuegu.R;
import cn.edu.gdmec.android.boxuegu.bean.UserBean;
import cn.edu.gdmec.android.boxuegu.utils.AnalysisUtils;
import cn.edu.gdmec.android.boxuegu.utils.DBUtils;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_back;
    private TextView tv_main_title;
    private TextView tv_nickName,tv_signature,tv_user_name,tv_sex;
    private RelativeLayout rl_nickName,rl_sex,rl_signaure,rl_title_bar;
    private String spUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //从Sharedpreferences中获取登录时的用户名
        spUserName = AnalysisUtils.readLoginUserName(this);
        init();
        initData();
        setListener();
    }

    /**
     * 初始化控件
     */

    private void init() {
        tv_back = ((TextView) findViewById(R.id.tv_back));
        tv_main_title = ((TextView) findViewById(R.id.tv_main_title));
        tv_main_title.setText("个人资料");
        rl_title_bar = ((RelativeLayout) findViewById(R.id.title_bar));
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        rl_nickName= ((RelativeLayout) findViewById(R.id.rl_nickName));
        rl_sex = ((RelativeLayout) findViewById(R.id.rl_sex));
        rl_signaure = ((RelativeLayout) findViewById(R.id.rl_signature));
        tv_nickName = ((TextView) findViewById(R.id.tv_nickName));
        tv_sex = ((TextView) findViewById(R.id.tv_sex));
        tv_user_name = ((TextView) findViewById(R.id.tv_user_name));
        tv_signature = ((TextView) findViewById(R.id.tv_signature));
    }
    /**
     * 获取数据
     */
    private void initData(){
        UserBean bean = null;
        bean = DBUtils.getInstance(this).getUserInfo(spUserName);
        //首先判断一下数据库是否有数据
        if (bean == null){
            bean = new UserBean();
            bean.userName=spUserName;
            bean.nickName = "问答精灵";
            bean.sex="男";
            bean.signature="问答精灵";
            //保存用户信息到数据库
            DBUtils.getInstance(this).saveUserInfo(bean);
        }
        setValue(bean);
    }

    /**
     * 为界面控件设置值
     * @param bean
     */

    public void setValue(UserBean bean) {
        tv_nickName.setText(bean.nickName);
        tv_user_name.setText(bean.userName);
        tv_sex.setText(bean.sex);
        tv_signature.setText(bean.signature);
    }
    /**
     * 设置控件的点击监听事件
     */
    private void setListener(){
        tv_back.setOnClickListener(this);
        rl_nickName.setOnClickListener(this);
        rl_sex.setOnClickListener(this);
        rl_signaure.setOnClickListener(this);
    }

    /**
     * 控件的点击事件
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                this.finish();
                break;
            case R.id.rl_nickName:
                break;
            case R.id.rl_sex:
                String sex = tv_sex.getText().toString();
                sexDialog(sex);
                break;
            case R.id.rl_signature:
                break;
                default:
                    break;
        }

    }
    /**
     * 设置性别的弹出框
     */
    private void sexDialog(String sex) {
        int sexFlag = 0;
        if ("男".equals(sex)) {
            sexFlag = 0;
        } else if ("女".equals(sex)) {
            sexFlag = 1;
        }
        final String items[] = {"男", "女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("性别");
        builder.setSingleChoiceItems(items, sexFlag, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(UserInfoActivity.this, items[which], Toast.LENGTH_SHORT).show();
                setSex(items[which]);
            }
        });
        builder.create().show();
    }
    /**
     * 更新界面上的性别数据
     */
    private void setSex(String sex){
        tv_sex.setText(sex);
        DBUtils.getInstance(UserInfoActivity.this).updateUserInfo("sex",sex,spUserName);
    }
}
