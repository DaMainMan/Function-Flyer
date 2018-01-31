package com.example.beaverduck.functionflyer.levels.base.object.position;

public class Position {
    //Stores all the positional data of a game object
    protected float x, y, spriteXOffset, spriteYOffset;
    protected static float xOffset, yOffset, yScale = 1, yConversion, xConversion;
    public Position(float x, float y){
        this.x = x;
        this.y = y;
    }//end constructor

    public void update(){

    }//end update

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }//end setPosition

    public float getScrX(){
        return (x - xOffset) * xConversion - spriteXOffset + 70;
    }//end getScrX

    public float getScrY(){
        return ((-getY()) /yScale - yOffset) * yConversion - spriteYOffset;
    }//end getScrY

    public static float getxOffset() {
        return xOffset;
    }//end getxOffset

    public static float getyOffset() {
        return yOffset;
    }// end getyOffset

    public float getX() {
        return x;
    }//end getX

    public float getY() {
        return y;
    }//end getY

    public static void setxOffset(float xOffset) {
        Position.xOffset = xOffset;
    }//end setxOffset

    public static void setyOffset(float yOffset) {
        Position.yOffset = yOffset;
    }//end setyOffset

    public void setX(float x) {
        this.x = x;
    }//end setX

    public void setY(float y) {
        this.y = y;
    }//end setY

    public void setSpriteXOffset(float spriteXOffset) {
        this.spriteXOffset = spriteXOffset;
    }//end setSpriteXOffset

    public void setSpriteYOffset(float spriteYOffset) {
        this.spriteYOffset = spriteYOffset;
    }//end setSpriteYOffset

    public float getSpriteXOffset() {
        return spriteXOffset;
    }//end getSpriteXOffset

    public float getSpriteYOffset() {
        return spriteYOffset;
    }//end getSpriteYOffset

    public static float getyScale() {
        return yScale;
    }//end getyScale

    public static void setyScale(float yScale) {
        Position.yScale = yScale;
    }//end setyScale

    public static void setyConversion(float yConversion) {
        Position.yConversion = yConversion;
    }//end getyConversion

    public static float getyConversion() {
        return yConversion;
    }//end getyConversion

    public static float getxConversion() {
        return xConversion;
    }//end getxConversion

    public static void setxConversion(float xConversion) {
        Position.xConversion = xConversion;
    }//end setxConversion

    //returns the distance on screen between itself and another position
    public float distance(Position position){
        float o = getScrX() + spriteYOffset - (position.getScrX() + position.getSpriteXOffset()),
                a = getScrY() + spriteYOffset - (position.getScrY() + position.getSpriteYOffset());
        return (float)Math.sqrt(o * o + a * a);
    }//end distance
}//end class