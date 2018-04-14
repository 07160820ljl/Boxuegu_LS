package cn.edu.gdmec.android.boxuegu.bean;

/**
 * Created by ASUS on 2018/3/30.
 */

public class ExercisesBean {
    public int id;
    public String title;
    public String content;
    public int background;
    public int subjectId;
    public String subject;
    public String a;
    public String b;
    public String c;
    public String d;
    public int answer;
    /**
     * select 为0表示所选项是对的，1表示选中的A选项是错的，2表示选中的B选项是错的，
     * 3表示选中的C选项是错的，4表示选中的D选项是错的
     */
    public int select;
}
