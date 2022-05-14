package com.example.mentz.model;

import java.util.List;

public class Location {

    private String id;
    private String name;
    private String type;
    private String streetName;
    private String disassembledName;

    private List<Double> coord;
    private List<Integer> productClasses;
    private String matchQuality;
    private String isBest;
    private Boolean isGlobalId;

    private Properties properties;
    private Parent parent;

    public Location(List<Double> coord, String disassembledName, String id, String isBest, Boolean isGlobalId, String matchQuality, String name, Parent parent, List<Integer> productClasses, Properties properties, String streetName, String type) {
        this.coord = coord;
        this.disassembledName = disassembledName;
        this.id = id;
        this.isBest = isBest;
        this.isGlobalId = isGlobalId;
        this.matchQuality = matchQuality;
        this.name = name;
        this.parent = parent;
        this.productClasses = productClasses;
        this.properties = properties;
        this.streetName = streetName;
        this.type = type;
    }

    //Getter
    public String getId() {
        return id;
    }
    public Parent getParent() {
        return parent;
    }
    public Properties getProperties() {
        return properties;
    }
    public Boolean getGlobalId() {
        return isGlobalId;
    }
    public String getIsBest() {
        return isBest;
    }
    public String getMatchQuality() {
        return matchQuality;
    }
    public List<Integer> getProductClasses() {
        return productClasses;
    }
    public List<Double> getCoord() {
        return coord;
    }
    public String getDisassembledName() {
        return disassembledName;
    }
    public String getStreetName() {
        return streetName;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    //Setter
    public void setId(String id) {
        this.id = id;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void setGlobalId(Boolean globalId) {
        isGlobalId = globalId;
    }
    public void setIsBest(String isBest) {
        this.isBest = isBest;
    }
    public void setMatchQuality(String matchQuality) {
        this.matchQuality = matchQuality;
    }
    public void setProductClasses(List<Integer> productClasses) {
        this.productClasses = productClasses;
    }
    public void setCoord(List<Double> coord) {
        this.coord = coord;
    }
    public void setDisassembledName(String disassembledName) {
        this.disassembledName = disassembledName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
}
