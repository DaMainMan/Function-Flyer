package com.example.beaverduck.functionflyer.levels.base.object.asteroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.levels.base.object.Animation;
import com.example.beaverduck.functionflyer.levels.base.object.GameObject;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Asteroid extends GameObject {
    private static final int OBJECT_ID = 7;
    private float degrees, rotationRate;
    private Bitmap frame;
    private GameLevel gameLevel;
    public Asteroid(Position position, int radius) {
        super(position, radius);
        degrees = new Random().nextInt(360);
        rotationRate = (float) (Math.random()-0.5)*2;
        //sets the current rotation and the rotation rate to random values
    }//end constructor

    @Override
    protected ArrayList<Animation> getAnimations() {
        return new ArrayList<>(Arrays.asList(new Animation(OBJECT_ID, getAnimation(), true, 0)));
    }//end getAnimations

    @Override
    public void update() {
        super.update();
        degrees += rotationRate;

        Matrix matrix = new Matrix();
        matrix.setRotate(degrees);
        frame = getFrame();
        frame = Bitmap.createBitmap(frame, 0, 0, frame.getWidth(), frame.getHeight(), matrix, true);
        position.setSpriteXOffset(frame.getWidth()/2);
        position.setSpriteYOffset(frame.getHeight()/2);
        //rotates the sprite according to its degrees value
        if(collidesWith(gameLevel.getPlayer())){
            gameLevel.fail();
        }//end if
        //fails level if collides with player
    }

    protected abstract int getAnimation();

    @Override
    public void draw(Canvas canvas, int left) {
       if(frame != null) canvas.drawBitmap(frame, position.getScrX() + left, position.getScrY(), new Paint());
    }//end draw

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }
}//end class

