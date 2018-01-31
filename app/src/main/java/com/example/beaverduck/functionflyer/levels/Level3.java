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

public class Level3 extends GameLevel {

    public Level3() {
        super(2, "0x+0", 6.75f);
    }
        //answer: y = 1/4x + 1
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-1, 1, 0.05, 0, true), new Slider(-5, 5, 1, 1, false)};
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>(Arrays.asList(new TutorialScreen(2)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -6f)),
                new MediumAsteroid(new Position(17, -10f)),
                new MediumAsteroid(new Position(10, -4f)),
                new MediumAsteroid(new Position(3, 6f)),
                new MediumAsteroid(new Position(16, -2f)),
                new MediumAsteroid(new Position(2, -10f)),
                new MediumAsteroid(new Position(6, 8f)),
                new MediumAsteroid(new Position(14, 10f)),
                new LargeAsteroid(new Position(6, 0f)),
                new LargeAsteroid(new Position(10, 6f)),
                new LargeAsteroid(new Position(18, 8f)),
                new LargeAsteroid(new Position(22, 10f)),
                new LargeAsteroid(new Position(1, -4f)),
                new LargeAsteroid(new Position(7, -10f)),
                new LargeAsteroid(new Position(13, -8f)),
                new LargeAsteroid(new Position(19, -6f)),
                new LargeAsteroid(new Position(23, -2f))));
    }//end setAsteroids


    @Override
    protected Value getFunction() {
        Expression expression = new Expression();
        expression.addValue(new Number(0));
        expression.addValue(new Variable(Operator.MULTIPLY));
        expression.addValue(new Number(0));

        return expression;
    }

}
