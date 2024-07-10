package com.java.basics.executor.FactoryMain.service.impl;

import com.java.basics.executor.FactoryMain.service.CarModel;
import com.java.basics.executor.FactoryMain.service.CarType;

public class SUVModel implements CarModel {
    @Override
    public CarType getType() {
        return CarType.SUV;
    }
}
