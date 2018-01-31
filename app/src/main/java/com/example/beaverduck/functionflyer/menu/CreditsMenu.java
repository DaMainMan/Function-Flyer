package com.example.beaverduck.functionflyer.menu;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.gamestate.MenuState;
import com.example.beaverduck.functionflyer.menu.base.Menu;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class CreditsMenu extends Menu {
    MenuState menuState;

    public CreditsMenu(MenuState menuState) {
        super(new ImageLabel(31, 31, 0, 0), true, true);
        this.menuState = menuState;
    }

    @Override
    protected ArrayList<Label> getOptions() {
        return new ArrayList<Label>(Arrays.asList(
                new ImageLabel(11, 10, GamePanel.getWIDTH()/50, GamePanel.getHEIGHT()/50)));
    }

    @Override
    protected void select(int selectedOption) {
        switch (selectedOption) {
            case 0:
                exit(false, true);
                break;
        }
    }

    @Override
    protected void onExit(int selectedOption) {
        switch (selectedOption) {
            case 0:
                menuState.setMenu(0);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        setSelectedOption(0);
        exit(false, true);
    }
}