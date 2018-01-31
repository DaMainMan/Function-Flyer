package com.example.beaverduck.functionflyer.levels.base.object.asteroid;

import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

public class LargeAsteroid extends Asteroid {
    private static final int RADIUS = 40;
    public LargeAsteroid(Position position) {
        super(position, RADIUS);
    }//end constructor

    @Override
    protected int getAnimation() {
        return 1;
    }//end getAnimation
}//end class