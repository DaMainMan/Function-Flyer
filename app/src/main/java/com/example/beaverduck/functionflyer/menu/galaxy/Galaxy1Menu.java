package com.example.beaverduck.functionflyer.menu.galaxy;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.gamestate.MenuState;
import com.example.beaverduck.functionflyer.menu.base.Menu;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class Galaxy1Menu extends Menu {
    public static final int BUTTON_SIZE = 250, LEVEL_BUTTON_SPACING = 40, Y_OFFSET = 200;
    private MenuState menuState;
    public Galaxy1Menu(MenuState menuState) {
        super(new ImageLabel(32, 32, 0), true, false);
        this.menuState = menuState;
    }//end constructor

    @Override
    protected ArrayList<Label> getOptions() {
        return new ArrayList<Label>(Arrays.asList(
        new ImageLabel(1, 0, GamePanel.getWIDTH()-BUTTON_SIZE, (GamePanel.getHEIGHT() - BUTTON_SIZE)/2),
        new ImageLabel(12, 4, (GamePanel.getWIDTH()-BUTTON_SIZE)/2 - BUTTON_SIZE/2 - LEVEL_BUTTON_SPACING, (GamePanel.getHEIGHT() - BUTTON_SIZE)/2 - BUTTON_SIZE/2 + Y_OFFSET - LEVEL_BUTTON_SPACING),
        new ImageLabel(13, 5, (GamePanel.getWIDTH()-BUTTON_SIZE)/2 + BUTTON_SIZE/2 + LEVEL_BUTTON_SPACING, (GamePanel.getHEIGHT() - BUTTON_SIZE)/2 - BUTTON_SIZE/2 + Y_OFFSET - LEVEL_BUTTON_SPACING),
        new ImageLabel(14, 6, (GamePanel.getWIDTH()-BUTTON_SIZE)/2 - BUTTON_SIZE/2 - LEVEL_BUTTON_SPACING, (GamePanel.getHEIGHT() - BUTTON_SIZE)/2 + BUTTON_SIZE/2 + Y_OFFSET + LEVEL_BUTTON_SPACING),
        new ImageLabel(15, 7, (GamePanel.getWIDTH()-BUTTON_SIZE)/2 + BUTTON_SIZE/2 + LEVEL_BUTTON_SPACING, (GamePanel.getHEIGHT() - BUTTON_SIZE)/2 + BUTTON_SIZE/2 + Y_OFFSET + LEVEL_BUTTON_SPACING),
        new ImageLabel(11, 10, GamePanel.getWIDTH()/50, GamePanel.getHEIGHT()/50)));
    }//end getOptions

    @Override
    protected void select(int selectedOption) {
        switch (selectedOption){
            case 0:
                exit(false, true);
                break;
            case 1:
                exit(true, true);
                break;
            case 2:
                exit(true, true);
                break;
            case 3:
                exit(true, true);
                break;
            case 4:
                exit(true, true);
                break;
            case 5:
                exit(false, true);
        }//end switch
    }//end select

    @Override
    protected void onExit(int optionSelected) {
        switch (optionSelected){
            case 0:
                menuState.setMenu(2);
                break;
            case 1:
                menuState.getGsm().setGameState(1);
                menuState.getLevelState().setLevel(0);
                break;
            case 2:
                menuState.getGsm().setGameState(1);
                menuState.getLevelState().setLevel(1);
                break;
            case 3:
                menuState.getGsm().setGameState(1);
                menuState.getLevelState().setLevel(2);
                break;
            case 4:
                menuState.getGsm().setGameState(1);
                menuState.getLevelState().setLevel(3);
                break;
            case 5:
                menuState.setMenu(0);
        }//end switch
    }//end onExit

    @Override
    public void onBackPressed() {
        setSelectedOption(5);
        exit(true, true);
    }
}//end class