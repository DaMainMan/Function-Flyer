package com.example.beaverduck.functionflyer.levels.base.object;

import android.graphics.Bitmap;

import com.example.beaverduck.functionflyer.engine.assets.Assets;

public class Animation {
    //Handles the timing and 'stores' the frames for animated textures
    private boolean repeat;
    private double frameNumber, frameRate;
    private int object, animation, length;

    public Animation(int object, int animation, boolean repeat, double frameRate){
        this.object = object;
        this.animation = animation;
        this.repeat = repeat;
        this.frameRate = frameRate;
        frameNumber = -1;
        start();
        length = Assets.getAnimationLength(object, animation);
    }//end constructor

    public void update(){
        //Controls the frame rate and frame number
        if(frameNumber >= 0) {
            frameNumber += frameRate;
            if(frameNumber >= length) {
                frameNumber = repeat ? 0 : -1;
            }
            else if(frameNumber < 0){
                frameNumber = repeat ? length-1 : frameNumber;
            }//end if else
        }//end if
    }//end update

    public Bitmap getFrame(int frame){
        return Assets.getFrame(object, animation, frame);
    }//end getFrame

    public Bitmap getFrame() {
        return Assets.getFrame(object, animation, (int)frameNumber);
    }//end getFrame

    public double getFrameNumber() {
        return frameNumber;
    }//end getFrameNumber

    public int getLength(){
        return length;
    }//end getLength

    public void start(){
        frameNumber = (frameNumber == -1 ? 0 : frameNumber >= length ? length - 1 : frameNumber);
    }//end start
}//end class