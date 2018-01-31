package com.example.beaverduck.functionflyer.gamestate;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.assets.Assets;

import java.util.ArrayList;

/*
Differentiate between when the user is playing the game or in the menus in order to
maximize efficiency by only running menu classes when in the menus, and vice versa.
*/
public class GameStateManager {
    private ArrayList<GameState> states;
    private int gameState;

    /*
    Create an array which holds the two possible states of the game
      - menuState: User is navigating through main menu/level select
      - levelState: User is in the middle of playing a level

    NOTE: The comment after each line shows the number that can be used to reference
    that specific game state later in the code.
    */
    public GameStateManager() {
        MenuState menuState = new MenuState(this);
        LevelState levelState = new LevelState(this);
        menuState.setStates(levelState);
        states = new ArrayList<>();
        states.add(menuState);//0
        states.add(levelState);//1
        gameState = 0;
    }//end constructor

    //updates the selected gamestate
    public void update() {
        states.get(gameState).update();
        if(!Assets.getAudio(0).isPlaying()){
            Assets.getAudio(0).start();
        }
    }//end update

    //draws the selected gamestate
    public void draw(Canvas canvas, int left) {
        states.get(gameState).draw(canvas, left);
    }//end draw

    //Sends touch event to selected
    public void onTouchEvent(MotionEvent e) {
        states.get(gameState).onTouchEvent(e);
    }//end onTouchEvent

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }//end setGamestate

    public void onBackPressed() {
        states.get(gameState).onBackPressed();
    }
}//end class
