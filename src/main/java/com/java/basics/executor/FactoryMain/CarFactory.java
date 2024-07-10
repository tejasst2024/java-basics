package com.java.basics.executor.FactoryMain;

import com.java.basics.executor.FactoryMain.service.CarModel;
import com.java.basics.executor.FactoryMain.service.CarType;
//import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarFactory {

    private static final List<CarModel> carList = new ArrayList<>();

    private static final Map<CarType, CarModel> carTypeCarFactoryMap =  new HashMap<>();

//    @PostConstruct
    private void init() {
        carList.forEach(carModel -> {
            carTypeCarFactoryMap.putIfAbsent(carModel.getType(), carModel);
        });
    }

    private CarModel getModel(CarType carType) {
        return carTypeCarFactoryMap.computeIfAbsent(carType, (key) -> {
            throw new RuntimeException("Test" );
        });
    }

}
