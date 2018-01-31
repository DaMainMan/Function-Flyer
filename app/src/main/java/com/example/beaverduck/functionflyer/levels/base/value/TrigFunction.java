package com.example.beaverduck.functionflyer.levels.base.value;
public enum TrigFunction {
    //Defines the trigonometric operation performed in a trig expression
    SINE{
        @Override
        public float perform(float value) {
            return (float)Math.sin(value);
        }
    },
    COSINE{
        @Override
        public float perform(float value) {
            return (float) Math.cos(value);
        }
    },
    TANGENT {
        @Override
        public float perform(float value) {
            return (float) Math.tan(value);
        }
    };
    public abstract float perform(float value);
}
