package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(0.0, Converter.toCelcius(32),0.01);
    }

    @Test
    public void lbs_conversion_to_kg() {
        assertEquals(1.0, Converter.toKilogram(2.2f), 0.01);
        assertEquals(0, Converter.toKilogram(0.0f), 0.01);
        assertEquals(10.6376, Converter.toKilogram(23.452f), 0.01);
    }

}