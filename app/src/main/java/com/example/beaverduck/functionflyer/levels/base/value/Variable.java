package com.example.beaverduck.functionflyer.levels.base.value;

public class Variable extends Value {
    //Used to define where the given value for x is used rather than a preset value
    private int x, y;
    private String string;

    public Variable(){
        super();
    }

    public Variable(Operator operator){
        super(operator);
    }

    @Override
    public float getValue(float x) {
        return x;
    }//end getValue

    @Override
    public Number getNumber(int number) {
        return null;
    }
}//end class