package com.example.beaverduck.functionflyer.levels.base;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.object.GameObject;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

public class LevelBounds {
    private int height;
    public LevelBounds(){
        height = Assets.getFrame(GameLevel.OBJECT_ID, 0, 0).getHeight();
    }

    public boolean inside(GameObject object){
        Position position = object.getPosition();
        float radius = object.getRadius(), x = position.getScrX(), y = position.getScrY();
        return  !(x - radius > GamePanel.getWIDTH() || x + radius < 0 || y - radius > height || y + radius < 0);
    }
}
