package com.example.andrew.apaquett_fueltrack;

public class UserLog {

    public int date;
    public String station;
    public float odometer;
    public String fuelType;
    public float amount;
    public float unitCost;
    public float totalCost;

    UserLog() {

    }

    @Override
    public String toString(){
        return ("Date: " + date + "\nStation: " + station + "\nOdometer: " + odometer
                + "\nFuel Type: " + fuelType + "\nAmount: " + amount
                + "\nUnit Cost: " + unitCost + "\nTotal Cost: " + totalCost);
    }

    // for testing, basically
    UserLog(int dateIN, String stationIN, float odometerIN, String fuelTypeIN,
        float amountIN, float unitCostIN, float totalCostIN) {

        date = dateIN;
        station = stationIN;
        odometer = odometerIN;
        fuelType = fuelTypeIN;
        amount = amountIN;
        unitCost = unitCostIN;
        totalCost = totalCostIN;
    }
}
