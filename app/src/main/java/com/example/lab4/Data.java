package com.example.lab4;

import java.io.Serializable;

public class Data implements Serializable {
    private String ShipId;
    private String ShipName;

    public Data(String shipId, String shipName){
        this.ShipId = shipId;
        this.ShipName = shipName;
    }

    public String getShipId() {
        return ShipId;
    }

    public void setShipId(String shipId) {
        ShipId = shipId;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }
}
