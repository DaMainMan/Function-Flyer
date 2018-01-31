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

public class Level6 extends GameLevel {
    public Level6() {
        super(2, "0(x+-0)^2+0", 6.563f);
    }//end constructor
        //answer: 1/16(x-10)^2 - 4;

    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-0.06, .06, 0.02, 0, true), new Slider(-10, 10, 1, 1, false), new Slider(-5, 5, 1, 3, true)};
    }//end getNumberSliders

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<TutorialScreen>(Arrays.asList(new TutorialScreen(4)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -6f)),
                new MediumAsteroid(new Position(17, -10f)),
                new MediumAsteroid(new Position(3, 6f)),
                new MediumAsteroid(new Position(2, -10f)),
                new MediumAsteroid(new Position(6, 8f)),
                new MediumAsteroid(new Position(14, 10f)),
                new MediumAsteroid(new Position(11, -2f)),
                new LargeAsteroid(new Position(10, 6f)),
                new LargeAsteroid(new Position(18, 8f)),
                new LargeAsteroid(new Position(22, 10f)),
                new LargeAsteroid(new Position(1, -4f)),
                new LargeAsteroid(new Position(5, 2f)),
                new LargeAsteroid(new Position(7, -10f)),
                new LargeAsteroid(new Position(13, -8f)),
                new LargeAsteroid(new Position(15, 4f)),
                new LargeAsteroid(new Position(19, -6f)),
                new LargeAsteroid(new Position(23, -2f))));
    }//end setAsteroids


    @Override
    protected Value getFunction() {
        Expression expression = new Expression();
        expression.addValue(new Number(0));
        Expression parenthesis = new Expression(Operator.MULTIPLY);
        parenthesis.addValue(new Variable());
        parenthesis.addValue(new Number(0));
        expression.addValue(parenthesis);
        expression.addValue(new Number(Operator.POWER, 2));
        expression.addValue(new Number(0));
        return expression;
    }//end getFunction
}//end class