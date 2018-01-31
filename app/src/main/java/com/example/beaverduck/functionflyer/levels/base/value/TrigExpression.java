package com.example.beaverduck.functionflyer.levels.base.value;

public class TrigExpression extends Value{
    //Allows for trigonometric functions to be performed on specific values.
    private TrigFunction function;
    private Value parenthesis;
    public TrigExpression(){
        parenthesis = new Number(1);
        setNumbers(1);
    }

    public TrigExpression(Operator operator){
        super(operator);
        parenthesis = new Number(1);
        setNumbers(1);
    }

    @Override
    public float getValue(float x) {
        return function.perform(parenthesis.getValue(x));
    }

    @Override
    public Number getNumber(int number) {
        if(number < getNumbers()) return parenthesis.getNumber(number);
        return null;
    }
    public void setParenthesis(Value parenthesis) {
        setNumbers(getNumbers() - this.parenthesis.getNumbers());
        this.parenthesis = parenthesis;
        setNumbers(getNumbers() + parenthesis.getNumbers());
    }

    public void setFunction(TrigFunction function) {
        this.function = function;
    }
}
