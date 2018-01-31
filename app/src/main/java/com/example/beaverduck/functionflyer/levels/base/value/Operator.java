package com.example.beaverduck.functionflyer.levels.base.value;

public enum Operator {
    //Used to describe the relationship between two or more values in an expression
    ADD('+', 0, 0){
        @Override
        public float perform(float n1, float n2) {
            return n1 + n2;
        }//end perform
    },//end add
    MULTIPLY('*', 1, 1){
        @Override
        public float perform(float n1, float n2) {
            return n1 * n2;
        }//end perform
    },//end multiply
    DIVIDE('/', 1, 1){
        @Override
        public float perform(float n1, float n2) {
            return n1 /n2;
        }//end perform
    },
    POWER('^', 2, 1){
        @Override
        public float perform(float n1, float n2) {
            return (float)Math.pow(n1, n2);
        }//end perform
    };//end power
    private char character;
    private int priority;
    private float identity;
    Operator(char operatorCharacter, int priority, float identity){
        character = operatorCharacter;
        this.priority = priority;
        this.identity = identity;
    }//end constructor
    public abstract float perform(float n1, float n2);

    public char getCharacter() {
        return character;
    }//end getCharacter

    public int getPriority() {
        return priority;
    }//end getPriority

    public float getIdentity() {
        return identity;
    }//end getIdentity
}//end enum