package com.example.lab4;

import java.io.Serializable;

public class Data implements Serializable {
    private String ShipId;
    private String ShipName;
    private String ShipModel;
    private String ShipType;
    private String ShipRole;
    private String ShipActive;

    public Data(String shipId, String shipName, String shipModel, String shipType, String shipRole, String shipActive) {
        this.ShipId = shipId;
        this.ShipName = shipName;
        this.ShipModel = shipModel;
        this.ShipType = shipType;
        this.ShipRole = shipRole;
        this.ShipActive = shipActive;
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

    public String getShipModel() {
        return ShipModel;
    }

    public void setShipModel(String shipModel) {
        ShipModel = shipModel;
    }

    public String getShipType() {
        return ShipType;
    }

    public void setShipType(String shipType) {
        ShipType = shipType;
    }

    public String getShipRole() {
        return ShipRole;
    }

    public void setShipRole(String shipRole) {
        ShipRole = shipRole;
    }

    public String getShipActive() {
        return ShipActive;
    }

    public void setShipActive(String shipActive) {
        ShipActive = shipActive;
    }
}
