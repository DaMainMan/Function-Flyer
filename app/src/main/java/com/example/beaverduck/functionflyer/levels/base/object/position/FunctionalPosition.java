package com.example.beaverduck.functionflyer.levels.base.object.position;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;

public class FunctionalPosition extends Position {
    //This class moves the player according to the set function
    private float velocity, cosine, sine, h, targetX, targetY, distance;
    private GameLevel gameLevel;
    public FunctionalPosition(float x, float y, float velocity) {
        super(x, y);
        this.velocity = velocity;
        reset();
    }//end constructor

    //Determines and returns the degrees the player is facing from the sine
    public float getDegrees(){
        return  (180 - (float)Math.toDegrees(Math.asin(sine))) - 90;
    }//end getDegrees

    public void update(){
        if(distance != 0) {
            x += cosine * velocity;
            y += sine * velocity;
            distance += velocity;
            if(distance >= h){
                distance = 0;
                x = targetX;
                y = targetY;
            }//end if
        }//end if
    }//end update

    public boolean isFinished(){
        return distance == 0;
    }//end isFinished

    //Sets the direction of the rocket towards the next point, determined by the x interval given
    public void setTargetPosition(float targetX){
        this.targetX = targetX;
        targetY = gameLevel.getPanel().getExpression().getValue(targetX);
        float o = targetX - x, a = (targetY - y)/Position.getyScale();
        h = (float)Math.sqrt(o * o + a * a);
        cosine = o/h;
        sine = a/h;
        distance += velocity;
    }//end setTargetPosition


    //resets the current and target position to make the rocket face foreword from the origin.
    public void reset() {
        x = 0;
        y = 0;
        float targetX = 1, targetY = 0;;
        float o = targetX - x, a = targetY - y;
        h = (float)Math.sqrt(o * o + (a * a)/yScale);
        cosine = o/h;
        sine = a/h;
    }//end reset

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }//end setGameLevel
}//end class