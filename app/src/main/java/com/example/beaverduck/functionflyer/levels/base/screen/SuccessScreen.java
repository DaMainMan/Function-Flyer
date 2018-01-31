package com.example.beaverduck.functionflyer.levels.base.screen;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;
import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class SuccessScreen extends Screen {
    public SuccessScreen(GameLevel gameLevel) {
        super(new ImageLabel(23, 23), true, true, gameLevel);
    }//end constructor

    @Override
    protected ArrayList<Label> getOptions() {
        int left = (GamePanel.getWIDTH()-WIDTH)/2, top = (GamePanel.getHEIGHT()-HEIGHT)/2,
        buttonSize = Assets.getFrame(1, 26, 0).getWidth(), segment = (WIDTH-buttonSize*3)/4;
        return new ArrayList<Label>(Arrays.asList(
                new ImageLabel(30, 29, left + segment, 700),
                new ImageLabel(26, 25, left + segment*2 + buttonSize, 700),
                new ImageLabel(28, 27, left + segment*3 + buttonSize*2, 700)));
    }//end getOptions

    @Override
    protected void select(int selectedOption) {
        exit(true, true);
    }//end select

    @Override
    protected void onExit(int selectedOption) {
        switch (selectedOption){
            case 0:
                gameLevel.getLevelState().getGsm().setGameState(0);
                break;
            case 2:
                if(gameLevel.getLevelState().getLevel() < 12) {
                    gameLevel.getLevelState().setLevel(gameLevel.getLevelState().getLevel() + 1);
                }//end if
        }//end switch
        gameLevel.reset(true);
    }//end onExit

    @Override
    public void onBackPressed() {

    }//end onBackPressed
}//end class
