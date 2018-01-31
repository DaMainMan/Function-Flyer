package com.example.beaverduck.functionflyer.levels.base.object.asteroid;

import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

public class MediumAsteroid extends Asteroid {
    private static final int RADIUS = 20;
    public MediumAsteroid(Position position) {
        super(position, RADIUS);
    }//end constructor

    @Override
    protected int getAnimation() {
        return 0;
    }//end getAnimation
}//end class
