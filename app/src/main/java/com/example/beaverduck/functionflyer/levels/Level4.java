package com.example.beaverduck.functionflyer.levels;

import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.levels.base.function_panel.Slider;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.Asteroid;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.LargeAsteroid;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.MediumAsteroid;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;
import com.example.beaverduck.functionflyer.levels.base.tutorial.TutorialScreen;
import com.example.beaverduck.functionflyer.levels.base.value.Expression;
import com.example.beaverduck.functionflyer.levels.base.value.Number;
import com.example.beaverduck.functionflyer.levels.base.value.Operator;
import com.example.beaverduck.functionflyer.levels.base.value.Value;
import com.example.beaverduck.functionflyer.levels.base.value.Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class Level4 extends GameLevel {

    public Level4() {
        super(3, "0x+0", 5.4f);
    }
        //answer: y = -1/5x + 10
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-1, 1, 0.1, 0, true), new Slider(-15, 15, 5, 1, false)};
        //195, 415
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>();
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -9f)),
                new MediumAsteroid(new Position(17, -15f)),
                new MediumAsteroid(new Position(10, -6f)),
                new MediumAsteroid(new Position(16, -3f)),
                new MediumAsteroid(new Position(2, -15f)),
                new MediumAsteroid(new Position(6, 12f)),
                new MediumAsteroid(new Position(14, 15f)),
                new MediumAsteroid(new Position(12, 3f)),
                new LargeAsteroid(new Position(20, 3f)),
                new LargeAsteroid(new Position(18, 12f)),
                new LargeAsteroid(new Position(22, 15f)),
                new LargeAsteroid(new Position(1, -6f)),
                new LargeAsteroid(new Position(5, 3f)),
                new LargeAsteroid(new Position(7, -15f)),
                new LargeAsteroid(new Position(13, -12f)),
                new LargeAsteroid(new Position(19, -9f)),
                new LargeAsteroid(new Position(23, -3f))));
    }//end setAsteroids

    @Override
    protected Value getFunction() {
        Expression expression = new Expression();
        expression.addValue(new Number(0));
        expression.addValue(new Variable(Operator.MULTIPLY));
        expression.addValue(new Number(1));

        return expression;
    }
}
