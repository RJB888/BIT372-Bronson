package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }

    public static float toKilogram(float lbs) {
        return lbs * 0.45359237f; }

    public static float toMilliliter(int oz){
        return (float) (oz * 29.5735);
    }

    public static float toMeter(float ft){
        return (float) (ft * 0.3048);
    }
}
