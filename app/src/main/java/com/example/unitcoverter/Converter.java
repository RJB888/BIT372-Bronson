package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }

    public static float toKilogram(float lbs) {
        return lbs * 0.45359237f; }
}
