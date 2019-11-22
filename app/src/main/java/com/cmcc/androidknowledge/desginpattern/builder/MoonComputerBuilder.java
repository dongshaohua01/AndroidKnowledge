package com.cmcc.androidknowledge.desginpattern.builder;

public class MoonComputerBuilder extends Builder {

    private Computer computer = new Computer();
    @Override
    public void buildCpu(String cpu) {
        computer.setmCpu(cpu);
    }

    @Override
    public void buildMainboard(String mainboard) {
        computer.setmMainboard(mainboard);
    }

    @Override
    public void buildRam(String ram) {
          computer.setmRam(ram);
    }

    @Override
    public Computer create() {
        return computer;
    }
}
