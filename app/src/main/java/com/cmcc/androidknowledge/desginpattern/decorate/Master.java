package com.cmcc.androidknowledge.desginpattern.decorate;

public abstract class Master extends Speciality{
     private Speciality speciality;

     public Master(Speciality speciality){
         this.speciality = speciality;
     }

    @Override
    public void attackSpeciality() {
        speciality.attackSpeciality();
    }
}
