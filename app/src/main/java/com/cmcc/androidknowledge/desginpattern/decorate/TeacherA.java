package com.cmcc.androidknowledge.desginpattern.decorate;

public class TeacherA extends Master {

    public TeacherA(Speciality speciality) {
        super(speciality);
    }

    public void teacherAttackSpeciality(){
        System.out.println("小仙女学会唱歌");
    }

    @Override
    public void attackSpeciality() {
        super.attackSpeciality();
        teacherAttackSpeciality();
    }
}
