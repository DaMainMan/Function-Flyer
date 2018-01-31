package com.example.beaverduck.functionflyer.gamestate;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class GameState {

    protected GameStateManager gsm;

    //All gamestate will have the ability to change, and know the current gamestate

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }//end constructor
    public abstract void draw(Canvas canvas, int left);
    public abstract void update();
    public abstract void onTouchEvent(MotionEvent e);

    public GameStateManager getGsm() {
        return gsm;
    }//end getGsm

    public abstract void onBackPressed();
}//end GameState