package com.test.controller;

import com.test.model.Appliance;
import com.test.model.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplianceStub {
    private static Map<Long, Appliance> applianceMap = new HashMap<Long, Appliance>();
    private static Long idIndex = 3L;

    //populate initial
    static {
        Appliance a = new Appliance(1L, "EWF1286GDW2", "Front loader washing machine", Status.UNKNOWN);
        applianceMap.put(1L, a);
        Appliance b = new Appliance(2L, "EWF1286GDW3", "Front loader washing machine", Status.UNKNOWN);
        applianceMap.put(2L, b);

    }

    public static List<Appliance> list() {
        return new ArrayList<Appliance>(applianceMap.values());
    }

    public static Appliance create(Appliance appliance) {
        idIndex += idIndex;
        appliance.setId(idIndex);
        applianceMap.put(idIndex, appliance);
        return appliance;
    }

    public static Appliance get(Long id) {
        return applianceMap.get(id);
    }

    public static Appliance update(Long id, Appliance appliance) {
        applianceMap.put(id, appliance);
        return appliance;
    }

    public static Appliance delete(Long id) {
        return applianceMap.remove(id);
    }
}
