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

public class Level5 extends GameLevel {

    public Level5() {
        super(3, "0x^2", 13.225f);
    }
        //answer: y = (1/40)x^2
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-0.1, .1, 0.005, 0, true)};
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>(Arrays.asList(new TutorialScreen(3)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -9f)),
                new MediumAsteroid(new Position(17, -15f)),
                new MediumAsteroid(new Position(10, -6f)),
                new MediumAsteroid(new Position(3, 9f)),
                new MediumAsteroid(new Position(16, -3f)),
                new MediumAsteroid(new Position(20, 6f)),
                new MediumAsteroid(new Position(2, -15f)),
                new MediumAsteroid(new Position(6, 12f)),
                new MediumAsteroid(new Position(14, 15f)),
                new MediumAsteroid(new Position(10, 0f)),
                new LargeAsteroid(new Position(10, 9f)),
                new LargeAsteroid(new Position(15, 2f)),
                new LargeAsteroid(new Position(18, 12f)),
                new LargeAsteroid(new Position(20, 15f)),
                new LargeAsteroid(new Position(1, -6f)),
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
        expression.addValue(new Number(Operator.POWER, 2));
        return expression;
    }
}
