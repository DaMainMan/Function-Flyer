package com.example.beaverduck.functionflyer.levels;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.levels.base.function_panel.Slider;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.Asteroid;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.LargeAsteroid;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.MediumAsteroid;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;
import com.example.beaverduck.functionflyer.levels.base.tutorial.TutorialScreen;
import com.example.beaverduck.functionflyer.levels.base.value.Number;
import com.example.beaverduck.functionflyer.levels.base.value.Value;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1 extends GameLevel {
    public Level1() {
        super(1, "0", 4);
    }
        //answer: y = 4
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{
                new Slider(-5, 5, 1, 0, true),
        };
        //195
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>(Arrays.asList(new TutorialScreen(0), new TutorialScreen(1)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -3f)),
                new MediumAsteroid(new Position(17, -5f)),
                new MediumAsteroid(new Position(10, -2f)),
                new MediumAsteroid(new Position(3, 3f)),
                new MediumAsteroid(new Position(16, -1f)),
                new MediumAsteroid(new Position(20, 2f)),
                new MediumAsteroid(new Position(2, -5f)),
                new LargeAsteroid(new Position(10, 3f)),
                new LargeAsteroid(new Position(1, -2f)),
                new LargeAsteroid(new Position(5, 1f)),
                new LargeAsteroid(new Position(7, -5f)),
                new LargeAsteroid(new Position(13, -4f)),
                new LargeAsteroid(new Position(15, 2f)),
                new LargeAsteroid(new Position(19, -3f)),
                new LargeAsteroid(new Position(23, -1f))));
    }//end setAsteroids


    @Override
    protected Value getFunction() {
        return new Number(0);
    }//end getFunction
}//end class Level1