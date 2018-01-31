package com.example.beaverduck.functionflyer.gamestate;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.menu.CreditsMenu;
import com.example.beaverduck.functionflyer.menu.MainMenu;
import com.example.beaverduck.functionflyer.menu.base.Menu;
import com.example.beaverduck.functionflyer.menu.galaxy.Galaxy1Menu;
import com.example.beaverduck.functionflyer.menu.galaxy.Galaxy2Menu;
import com.example.beaverduck.functionflyer.menu.galaxy.Galaxy3Menu;

import java.util.ArrayList;

public class MenuState extends GameState {
    private ArrayList<Menu> menus;
    private int menu;
    private static final int OBJECT_ID = 9;
    private LevelState levelState;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        menus = new ArrayList<>();
        menus.add(new MainMenu(this));//0
        menus.add(new Galaxy1Menu(this));//1
        menus.add(new Galaxy2Menu(this));//2
        menus.add(new Galaxy3Menu(this));//3
        menus.add(new CreditsMenu(this));//4
        menu = 0;
    }//end constructor

    public void setStates(LevelState levelState){
        this.levelState = levelState;
    }//end setStates

    @Override
    public void draw(Canvas canvas, int left) {
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, 0, 0), left, 0, new Paint());
        menus.get(menu).draw(canvas, left);
    }//end draw

    @Override
    public void update() {
        menus.get(menu).update();
    }//end update

    @Override
    public void onTouchEvent(MotionEvent e) {
        menus.get(menu).onTouchEvent(e);
    }//end onTouchEvent

    @Override
    public void onBackPressed() {
        menus.get(menu).onBackPressed();
    }

    public LevelState getLevelState() {
        return levelState;
    }//setLevelState

    public void setMenu(int menu) {
        this.menu = menu;
    }//end setMenu
}//end class
