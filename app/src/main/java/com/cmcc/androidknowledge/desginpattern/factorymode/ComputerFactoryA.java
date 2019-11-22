package com.cmcc.androidknowledge.desginpattern.factorymode;

public abstract class ComputerFactoryA {

  public abstract <T extends Computer> T createComputer(Class<T> tClass);
}
