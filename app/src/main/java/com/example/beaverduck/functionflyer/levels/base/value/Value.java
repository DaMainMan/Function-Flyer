package com.example.beaverduck.functionflyer.levels.base.value;

public abstract class Value {
    //The value class is used to store and calculate the value of an expression with a variable
    /* All types of values must have the following
    * An operator to determine what operation to preform between it and another value
    * A value of the amount of numbers it contains to allow the sliders to edit a specific one
    * The ability to return a value when given a value for x
     */
    protected Operator operator;
    private int numbers;
    public Value(){
        operator = Operator.ADD;
        numbers = 0;
    }//end constructor

    public Value(Operator operator){
        this.operator = operator;
        numbers = 0;
    }

    public abstract float getValue(float x);//end getValue

    public void setOperator(Operator operator) {
        this.operator = operator;
    }//end setOperator

    public Operator getOperator() {
        return operator;
    }//end getOperator

    public abstract Number getNumber(int number);

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}