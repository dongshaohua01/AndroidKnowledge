package com.cmcc.androidknowledge.desginpattern.decorate;

public class TeacherB extends Master {

    public TeacherB(Speciality speciality) {
        super(speciality);
    }

    public void teacherAttackSpeciality(){
        System.out.println("小仙女学会弹钢琴");
    }

    @Override
    public void attackSpeciality() {
        super.attackSpeciality();
        teacherAttackSpeciality();
    }
}
