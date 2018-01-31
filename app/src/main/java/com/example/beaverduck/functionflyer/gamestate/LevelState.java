
package com.example.beaverduck.functionflyer.gamestate;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.levels.Level1;
import com.example.beaverduck.functionflyer.levels.Level10;
import com.example.beaverduck.functionflyer.levels.Level11;
import com.example.beaverduck.functionflyer.levels.Level12;
import com.example.beaverduck.functionflyer.levels.Level2;
import com.example.beaverduck.functionflyer.levels.Level3;
import com.example.beaverduck.functionflyer.levels.Level4;
import com.example.beaverduck.functionflyer.levels.Level5;
import com.example.beaverduck.functionflyer.levels.Level6;
import com.example.beaverduck.functionflyer.levels.Level7;
import com.example.beaverduck.functionflyer.levels.Level8;
import com.example.beaverduck.functionflyer.levels.Level9;
import com.example.beaverduck.functionflyer.levels.base.GameLevel;

import java.util.ArrayList;
public  class LevelState extends GameState {
    private ArrayList<GameLevel> levels;
    private int level;
    //Adds one instance of every level to the list
    public LevelState(GameStateManager gsm) {
        super(gsm);
        levels = new ArrayList<>();
        levels.add(new Level1());//0
        levels.add(new Level2());//1
        levels.add(new Level3());//2
        levels.add(new Level4());//3
        levels.add(new Level5());//4
        levels.add(new Level6());//5
        levels.add(new Level7());//6
        levels.add(new Level8());//7
        levels.add(new Level9());//8
        levels.add(new Level10());//9
        levels.add(new Level11());//10
        levels.add(new Level12());//11
        for(GameLevel level : levels){
            level.setLevelState(this);
        }//end for
    }//end constructor

    //draws the selected level to the screen
    @Override
    public void draw(Canvas canvas, int left) {
        levels.get(level).draw(canvas, left);
    }//end draw

    //updates the selected level
    @Override
    public void update() {
        levels.get(level).update();
    }//end update

    //gives touch event to selected level
    @Override
    public void onTouchEvent(MotionEvent e) {
        levels.get(level).onTouchEvent(e);
    }//end onMotionEvent

    @Override
    public void onBackPressed() {
        levels.get(level).onBackPressed();
    }

    public void setLevel(int level) {
        if(level < levels.size()) this.level = level;
        else gsm.setGameState(0);
    }//end setLevel

    public int getLevel() {
        return level;
    }
}