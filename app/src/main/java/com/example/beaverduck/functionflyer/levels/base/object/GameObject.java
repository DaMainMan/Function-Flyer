package com.example.beaverduck.functionflyer.levels.base.object;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

import java.util.ArrayList;

public abstract class GameObject {
    //The base for all objects in the game. Handles position, animations, collision, etc.
    protected Position position;
    private ArrayList<Animation> animations;
    protected int animationState;
    private int radius;
    protected GameLevel gameLevel;

    //radius determines collision area
    public GameObject(Position position, int radius) {
        this.position = position;
        animations = getAnimations();
        animationState = 0;
        this.radius = radius;
    }//end constructor

    //Allows subclass to specify animations
    protected abstract ArrayList<Animation> getAnimations();

    //Updates position and selected animation
    public void update() {
        position.update();
        animations.get(animationState).update();
    }//end update

    //Allows subclass to specify how it is drawn
    public abstract void draw(Canvas canvas, int left);


    public Position getPosition() {
        return position;
    }//end getPosition

    public Bitmap getFrame() {
        return animations.get(animationState).getFrame();
    }

    //determines whether the 'circles' of collision intersect
    public boolean collidesWith(GameObject object){
        return object.getRadius() + radius >= object.getPosition().distance(position);
    }//end collidesWith

    public int getRadius(){
        return radius;
    }//end getRadius

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }
}//end class