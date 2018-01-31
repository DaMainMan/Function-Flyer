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

public class Level9 extends GameLevel {

    public Level9() {
        super(1, "0 * sin(x)", -2.539f);
    }
        //answer: 3 * sin(x)
    @Override
    protected Slider[] getNumberSliders() {
        return new Slider[]{new Slider(-5, 5, 1, 0, true)};
        //200
    }

    @Override
    protected ArrayList<TutorialScreen> setTutorials() {
        return new ArrayList<TutorialScreen>(Arrays.asList(new TutorialScreen(5)));
    }

    @Override
    protected ArrayList<Asteroid> setAsteroids() {
        return new ArrayList<>(Arrays.asList(
                new MediumAsteroid(new Position(6, -3f)),
                new MediumAsteroid(new Position(17, -5f)),
                new MediumAsteroid(new Position(3, 3f)),
                new MediumAsteroid(new Position(15, -1f)),
                new MediumAsteroid(new Position(2, -5f)),
                new MediumAsteroid(new Position(6, 4f)),
                new MediumAsteroid(new Position(14, 5f)),
                new MediumAsteroid(new Position(21, -1f)),
                new LargeAsteroid(new Position(10, 3f)),
                new LargeAsteroid(new Position(18, 4f)),
                new LargeAsteroid(new Position(22, 5f)),
                new LargeAsteroid(new Position(1, -2f)),
                new LargeAsteroid(new Position(5, 1f)),
                new LargeAsteroid(new Position(7, -5f)),
                new LargeAsteroid(new Position(13, -4f)),
                new LargeAsteroid(new Position(17, 2f)),
                new LargeAsteroid(new Position(19, -3f))));
    }//end setAsteroids

    @Override
    protected Value getFunction() {
        Expression expression = new Expression();

        TrigExpression trigExpression = new TrigExpression(Operator.MULTIPLY);
        trigExpression.setFunction(TrigFunction.SINE);

        trigExpression.setParenthesis(new Variable());
        expression.addValue(new Number(0));
        expression.addValue(trigExpression);

        return expression;
    }
}
