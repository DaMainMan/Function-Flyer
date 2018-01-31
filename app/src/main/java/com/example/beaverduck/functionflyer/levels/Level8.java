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

public class Level8 extends GameLevel {

    public Level8() {
        super(3, "0(0x+-0)^2+0", -6.025f);
    }
    //answer: y = -1/10(1/2x-2)^2 + 3
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-1, 1, 0.1, 0, true),  new Slider(-1, 1, 0.1, 1, false), new Slider(-5, 5, 1, 2, true), new Slider(-15, 15, 3, 4, false)};
        //195, 400, 680, 975
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
                new MediumAsteroid(new Position(3, 9f)),
                new MediumAsteroid(new Position(16, -4f)),
                new MediumAsteroid(new Position(2, -15f)),
                new MediumAsteroid(new Position(6, 12f)),
                new MediumAsteroid(new Position(14, 15f)),
                new MediumAsteroid(new Position(20, 5f)),
                new MediumAsteroid(new Position(15, 6f)),
                new LargeAsteroid(new Position(10, -6f)),
                new LargeAsteroid(new Position(18, 12f)),
                new LargeAsteroid(new Position(11, 10f)),
                new LargeAsteroid(new Position(22, 15f)),
                new LargeAsteroid(new Position(1, -6f)),
                new LargeAsteroid(new Position(8, 7f)),
                new LargeAsteroid(new Position(7, -15f)),
                new LargeAsteroid(new Position(13, -12f)),
                new LargeAsteroid(new Position(19, -9f)),
                new LargeAsteroid(new Position(23, 0f))));
    }//end setAsteroids

    @Override
    protected Value getFunction() {

        Expression expression = new Expression();
        expression.addValue(new Number(0));
        Expression parenthesis = new Expression(Operator.MULTIPLY);
        parenthesis.addValue(new Number(0));
        parenthesis.addValue(new Variable(Operator.MULTIPLY));
        parenthesis.addValue(new Number(0));
        expression.addValue(parenthesis);
        expression.addValue(new Number(Operator.POWER, 2));
        expression.addValue(new Number(0));

        return expression;
    }
}
