package com.example.beaverduck.functionflyer.levels.base.screen;

import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class FailScreen extends Screen {
    //Screen which displays when the user fails the level
    public FailScreen(GameLevel gameLevel) {
        super(new ImageLabel(24, 24), true, true, gameLevel);
    }

    @Override
    protected ArrayList<Label> getOptions() {
        int left = 800,
                buttonSize = Assets.getFrame(1, 26, 0).getWidth(),
                segment = WIDTH/3;
        return new ArrayList<Label>(Arrays.asList(new ImageLabel(30, 29, left + segment - buttonSize/2, 700),
                new ImageLabel(26, 25, left + segment*2-buttonSize/2, 700)));
    }

    @Override
    protected void select(int selectedOption) {
        exit(true, true);
    }

    //One of two options: retry, or back to menu
    @Override
    protected void onExit(int selectedOption) {
        switch (selectedOption){
            case 0:
                gameLevel.getLevelState().getGsm().setGameState(0);
                break;
        }
        gameLevel.reset(false);
    }

    @Override
    public void onBackPressed() {

    }
}