package com.example.beaverduck.functionflyer.levels.base.value;

public class Number extends Value {
    //Used to store coefficients which may or may not be subject to change by the sliders
    private float number;
    private int x, y;
    private String string;
    public Number(float number){
        this.number = number;
        setNumbers(1);
    }//end constructor

    public Number(Operator operator, float number){
        super(operator);
        this.number = number;
        setNumbers(1);
    }

    @Override
    public float getValue(float x) {
        return number;
    }//end getValue

    @Override
    public String toString() {
        return string;
    }//end toString

    @Override
    public Number getNumber(int number) {
        return number < getNumbers() ? this : null;
    }

    public void setNumber(double number) {
        this.number = (float)number;
    }
}//end class