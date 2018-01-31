package com.example.beaverduck.functionflyer.levels.base.tutorial;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.GameLevel;

public class TutorialScreen {
    //Displays at the beginning of certain levels to teach the user new mechanics
    private GameLevel gameLevel;
    private static final int OBJECT_ID = 8;
    private int x, y, animation;
    public TutorialScreen(int animation){
        Bitmap frame = Assets.getFrame(OBJECT_ID, animation, 0);
        x = (GamePanel.getWIDTH() - frame.getWidth())/2;
        y = (GamePanel.getHEIGHT() - frame.getHeight())/2;
        this.animation = animation;
    }

    public void draw(Canvas canvas, int left){
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, animation, 0), x + left, y, new Paint());
    }

    public void onTouchEvent(MotionEvent e){
        if(e.getAction() == MotionEvent.ACTION_DOWN){
            gameLevel.advanceTutorial();
        }
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }
}
