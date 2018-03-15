package cn.edu.gdmec.android.boxuegu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ASUS on 2018/3/15.
 */

public class AnalysisUtils {
    /**
     * 从Sharedpreferences中读取登录用户名
     */
    public static String readLoginUserName(Context context){
        SharedPreferences sp = context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        String userName = sp.getString("loginUserName","");
        return userName;

    }
}
