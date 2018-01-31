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

public class Level7 extends GameLevel {

    public Level7() {
          super(1, "0(0x+-0)^2+0", 4.22f);
    }
        //answer: y = 1/4(1/4x-1)^2 - 2
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-2, 2, .25, 0, true), new Slider(-2, 2, .25, 1, false), new Slider(-5, 5, 1, 2, true), new Slider(-5, 5, 1, 4, false)};
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>();
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(17, -5f)),
                new MediumAsteroid(new Position(3, 3f)),
                new MediumAsteroid(new Position(2, -3f)),
                new MediumAsteroid(new Position(6, 4f)),
                new MediumAsteroid(new Position(14, 5f)),
                new MediumAsteroid(new Position(8, -1f)),
                new LargeAsteroid(new Position(2, 0f)),
                new LargeAsteroid(new Position(10, 3f)),
                new LargeAsteroid(new Position(18, 4f)),
                new LargeAsteroid(new Position(22, 5f)),
                new LargeAsteroid(new Position(5, 1f)),
                new LargeAsteroid(new Position(7, -5f)),
                new LargeAsteroid(new Position(13, -4f)),
                new LargeAsteroid(new Position(15, 2f)),
                new LargeAsteroid(new Position(19, -3f)),
                new LargeAsteroid(new Position(23, -1f))));
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
}//end class Level7
