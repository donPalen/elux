package com.test.model;

/**
 * @author aprokofyev on 21.11.2017.
 */
public enum Status {
    ON(10),
    PAUSE(5),
    OFF(0),
    ERROR(-1),
    UNKNOWN(-10);

    private int status;

    Status(int aStatusp) {
        status = aStatusp;
    }

    int getStatus() {
        return status;
    }

}
