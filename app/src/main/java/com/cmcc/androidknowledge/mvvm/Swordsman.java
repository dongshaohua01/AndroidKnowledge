package com.cmcc.androidknowledge.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cmcc.androidknowledge.BR;

/**
 * 使用Observable动态更新
 */
public class Swordsman extends BaseObservable {

    private String name;
    private String level;

    public Swordsman(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Swordsman() {
    }

    /**
     *    在getter上使用@Bindable注解，在setter中通知更新就可以了。BR是编译时生成的类，其功能与R.java类似，
     * 用@Bindable标记过的getter方法会在BR中生成一个相应的字段。在setter方法中调用notifyPropertyChanged（BR.name）
     * 通知系统BR.name这个字段的数据已经发生了变化并更新UI
     *
     * @return
     */
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
