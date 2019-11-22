package com.cmcc.androidknowledge.desginpattern.appearance;

/**
 * 外观类张无忌
 */
public class ZhangWuJi{
    private JingMai jingMai;
    private ZhaoShi zhaoShi;
    private NeiGong neiGong;

    public ZhangWuJi(){
        jingMai = new JingMai();
        zhaoShi = new ZhaoShi();
        neiGong = new NeiGong();
    }

    /**
     * 使用乾坤大挪移
     */
    public void QianKun(){
        jingMai.JingMai();//开启经脉
        neiGong.QianKun();//使用内功乾坤大挪移
    }

    /**
     * 使用七伤拳
     */
    public void QiShang(){
        jingMai.JingMai();//开启经脉
        neiGong.JiuYang();//使用内功九阳神功
        zhaoShi.QiShangQuan();//使用招式七伤拳
    }

}
