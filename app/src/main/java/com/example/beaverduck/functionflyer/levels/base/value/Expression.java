package com.example.beaverduck.functionflyer.levels.base.value;

import java.util.ArrayList;

public class Expression extends Value {
    private ArrayList<Value> terms;
    public Expression(){
        super();
        terms = new ArrayList<>();
    }//end constructor

    public Expression(Operator operator){
        super(operator);
        terms = new ArrayList<>();
    }
    public void addValue(Value term){
        terms.add(term);
        setNumbers(getNumbers() + term.getNumbers());
    }//end addValue

    @Override
    public Number getNumber(int number) {
        if(number < getNumbers()){
            for(Value value : terms){
                if(value.getNumbers() > number) return value.getNumber(number);
                number -= value.getNumbers();
            }
        }
        return null;
    }

    @Override
    public float getValue(float x) {
        ArrayList<Value> terms = (ArrayList<Value>)this.terms.clone();
        for(int i = 0; i < terms.size(); i++){
            Value value = terms.get(i);
            Operator operator =  value.getOperator();
            if(operator.getPriority() == 2){
                terms.remove(i);
                i--;
                Value oldValue = terms.get(i);
                terms.set(i, new Number(oldValue.getOperator(), operator.perform(oldValue.getValue(x), value.getValue(x))));
            }//end if
        }//end for
        for (int i = 0; i < terms.size(); i++) {
            Value value = terms.get(i);
            Operator operator =  value.getOperator();
            if(operator.getPriority() == 1){
                terms.remove(i);
                i--;
                terms.set(i, new Number(operator.perform(terms.get(i).getValue(x), value.getValue(x))));
            }//end if
        }
        float number = 0;
        for (Value value : terms){
            number += value.getValue(x);
        }
        return number;
    }//end getValue
}//end class Expression