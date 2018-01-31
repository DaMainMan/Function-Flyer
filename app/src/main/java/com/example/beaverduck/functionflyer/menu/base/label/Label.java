package com.example.beaverduck.functionflyer.menu.base.label;

import android.graphics.Canvas;
import android.graphics.Rect;

public abstract class Label {

    protected boolean selected;
    private static final int INITIAL_OFFSET = -3000, FINAL_OFFSET = 3000, VELOCITY = 60;
    private boolean exiting;
    private Rect area;
    protected int offset;
    private boolean right;

    //Used by subclass to specify the area in which the user can touch to select the option
    protected void setArea(Rect area) {
        this.area = area;
    }//end setArea

    //Subclass determines how instance is drawn
    public abstract void draw(Canvas canvas, int left);//end draw

    public void select() {
        selected = true;
    }//end select

    //Returns false if the label is moving on or off the screen, or false otherwise
    public boolean isFinished() {
        return (right ? offset >= getFinalOffset() : offset <= getFinalOffset()) || offset == 0;
    }//end isFinished

    //Resets the offset, so it is off the screen in the specified direction based on boolean right
    public void reset(boolean right) {
        this.right = right;
        offset = getInitialOffset();
        exiting = false;
    }//end reset

    //Triggers the label to exit the screen
    public void exit(boolean right){
        this.right = right;
        exiting = true;
    }//exit

    //Updates offset based off of selected, and the value of offset
    public void update(){
        if(exiting && (right ? offset < getFinalOffset() : offset > getFinalOffset())){
            offset += getVelocity();
        }//end if
        else if((right ? offset >= 0 : offset <= 0) && !exiting) offset = 0;
        else offset += getVelocity();
        selected = false;
    }//end update

    //Returns the selectable area
    public Rect getArea(){
        return area;
    }//end getArea

    //Returns the inital offset based on right
    private int getInitialOffset(){
        return right ? INITIAL_OFFSET : FINAL_OFFSET;
    }//end getInitialOffset

    //Returns the final offset based on boolean right
    private int getFinalOffset(){
        return right ? FINAL_OFFSET : INITIAL_OFFSET;
    }//end getFinalOffset

    private int getVelocity(){
        return right ? VELOCITY : -VELOCITY;
    }//end getVelocity
}//end class