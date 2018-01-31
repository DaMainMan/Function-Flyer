package com.example.beaverduck.functionflyer.menu;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.gamestate.MenuState;
import com.example.beaverduck.functionflyer.menu.base.Menu;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu extends Menu {
    MenuState menuState;
    private static final int BUTTON_HEIGHT = 88, BUTTON_SPACING = 120;
    public MainMenu(MenuState menuState) {
        super(new ImageLabel(22, 22, 0, 0), true, true);
        this.menuState = menuState;
    }

    @Override
    protected ArrayList<Label> getOptions() {
        return new ArrayList<Label>(Arrays.asList(
                new ImageLabel(19, 18, GamePanel.getHEIGHT()/2 + BUTTON_SPACING),
                new ImageLabel(21, 20, GamePanel.getHEIGHT()/2 + 2 * BUTTON_SPACING + BUTTON_HEIGHT)));
    }

    @Override
    protected void select(int selectedOption) {
        switch (selectedOption){
            case 0:
                exit(false, true);
                break;
            case 1:
                exit(true, false);
                break;
        }
    }

    @Override
    protected void onExit(int selectedOption) {
        switch (selectedOption){
            case 0:
                menuState.setMenu(1);
                break;
            case 1:
                menuState.setMenu(4);
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}