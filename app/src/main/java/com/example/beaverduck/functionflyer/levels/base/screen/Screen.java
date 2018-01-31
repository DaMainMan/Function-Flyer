package com.example.beaverduck.functionflyer.levels.base.screen;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.menu.base.Menu;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

public abstract class Screen extends Menu {
    /*Displays when a level ending condition is met
    * Rocket leaves the screen
    * Rocket crashes into asteroid
    * Rocket contacts goal planet
     */
    protected GameLevel gameLevel;
    protected static final int WIDTH = (int) (640*1.5), HEIGHT = (int) (360*1.5);
    public Screen(Label title, boolean exitX, boolean enterRight, GameLevel gameLevel) {
        super(title, exitX, enterRight);
        this.gameLevel = gameLevel;
    }
}