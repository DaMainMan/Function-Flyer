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
import com.example.beaverduck.functionflyer.levels.base.value.TrigExpression;
import com.example.beaverduck.functionflyer.levels.base.value.TrigFunction;
import com.example.beaverduck.functionflyer.levels.base.value.Value;
import com.example.beaverduck.functionflyer.levels.base.value.Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class Level10 extends GameLevel {

    public Level10() {
        super(1, "0 * sin(0x+-0) + 0", 2.645f);
    }
        //answer: y = 3 sin (1/2x - 5) + 2
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{
                new Slider(-5, 5, 1, 0, true),
                new Slider(-1, 1, 0.25, 1, false),
                new Slider(-5, 5, 1, 2, true),
                new Slider(-5, 5, 1, 3, false)};
        //195, 485, 720, 1000
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<>(Arrays.asList(new TutorialScreen(6)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -3f)),
                new MediumAsteroid(new Position(17, -5f)),
                new MediumAsteroid(new Position(10, -2f)),
                new MediumAsteroid(new Position(16, -1f)),
                new MediumAsteroid(new Position(20, 2f)),
                new MediumAsteroid(new Position(2, -5f)),
                new MediumAsteroid(new Position(6, 4f)),
                new MediumAsteroid(new Position(2, 1f)),
                new MediumAsteroid(new Position(13, 1f)),
                new LargeAsteroid(new Position(18, 4f)),
                new LargeAsteroid(new Position(22, 5f)),
                new LargeAsteroid(new Position(1, -2f)),
                new LargeAsteroid(new Position(7, -5f)),
                new LargeAsteroid(new Position(13, -4f)),
                new LargeAsteroid(new Position(15, 2f)),
                new LargeAsteroid(new Position(19, -3f)),
                new LargeAsteroid(new Position(5, 5f)),
                new LargeAsteroid(new Position(7, 3f)),
                new LargeAsteroid(new Position(23, -1f))));
    }//end setAsteroids

    @Override
    protected Value getFunction() {
        Expression expression = new Expression();

        TrigExpression trigExpression = new TrigExpression(Operator.MULTIPLY);
        trigExpression.setFunction(TrigFunction.SINE);
        Expression parenthesis = new Expression();

        parenthesis.addValue(new Number(0));
        parenthesis.addValue(new Variable(Operator.MULTIPLY));
        parenthesis.addValue(new Number(0));

        trigExpression.setParenthesis(parenthesis);

        expression.addValue(new Number(0));
        expression.addValue(trigExpression);
        expression.addValue(new Number(0));

        return expression;
    }
}
