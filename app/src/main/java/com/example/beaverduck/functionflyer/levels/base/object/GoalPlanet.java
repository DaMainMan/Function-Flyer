package com.example.beaverduck.functionflyer.levels.base.object;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

import java.util.ArrayList;
import java.util.Arrays;

public class GoalPlanet extends GameObject {
    private static final int OBJECT_ID = 6, RADIUS = 50;
    private Bitmap frame;
    private float degrees;

    //The x value of the planet will always be on the right side, so only the y value needs to be specified
    public GoalPlanet(float goalPlanetY) {
        super(new Position(23, goalPlanetY), 50);
    }//end constructor

    //Returns the animation from assets
    @Override
    protected ArrayList<Animation> getAnimations() {
        return new ArrayList<>(Arrays.asList(new Animation(OBJECT_ID, 0, true, 1)));
    }

    //Sets the degree value and sets the rotation of the sprite accordingly
    @Override
    public void update() {
        super.update();
        degrees += 0.25;
        frame = getFrame();
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees);
        frame = Bitmap.createBitmap(frame, 0, 0, frame.getWidth(), frame.getHeight(), matrix, true);
        position.setSpriteXOffset(frame.getWidth()/2);
        position.setSpriteYOffset(frame.getHeight()/2);
    }

    @Override
    public void draw(Canvas canvas, int left) {
        if(frame != null) canvas.drawBitmap(frame, position.getScrX() + left, position.getScrY(), new Paint());
    }
}
