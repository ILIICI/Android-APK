package com.example.dissertation.GettersSetters;

public class ChartModel {
    private String lineX;
    private String lineY;
    private String ordernumber;

    public ChartModel(String lineX, String lineY, String ordernumber) {
        this.lineX = lineX;
        this.lineY = lineY;
        this.ordernumber = ordernumber;
    }

    public ChartModel(String lineX, String ordernumber) {
        this.lineX = lineX;
        this.ordernumber = ordernumber;
    }

    public ChartModel(String lineX) {
        this.lineX = lineX;
    }

    public ChartModel() {

    }

    public String getLineX() {
        return lineX;
    }

    public void setLineX(String lineX) {
        this.lineX = lineX;
    }

    public String getLineY() {
        return lineY;
    }

    public void setLineY(String lineY) {
        this.lineY = lineY;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }
}
