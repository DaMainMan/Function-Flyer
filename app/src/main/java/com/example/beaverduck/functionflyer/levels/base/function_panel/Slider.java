package com.example.beaverduck.functionflyer.levels.base.function_panel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.value.Number;

public class Slider {
    private double value, upper, lower, x, y, width, height, circleRadius, startingValue, interval;
    private int functionNumber, digits;
    private Number number;
    private ExpressionString expressionString;
    private static final int OBJECT_ID = 4;
    //the user's way of setting the value of the coefficients which can be controlled by the developer

    public Slider(double lower, double upper, double interval, int functionNumber, boolean above){
        //above controls if it is above or below the expression string
        x = 0;
        this.interval = interval;
        digits = 0;
        String numberString = interval + "";
        boolean decimal = false;
        for(char character : numberString.toCharArray()){
            if(isDigit(character) && decimal) digits++;
            else if(character == '.') decimal = true;
        }
        y = above ? 50 * GamePanel.getHEIGHT()/60 : 57 * GamePanel.getHEIGHT()/60;
        width = Assets.getFrame(OBJECT_ID, 0, 0).getWidth();
        height = Assets.getFrame(OBJECT_ID, 0, 0).getHeight();
        this.lower = lower;
        this.upper = upper;
        this.functionNumber = functionNumber;
        circleRadius = Assets.getFrame(OBJECT_ID, 1, 0).getWidth()/2;
    }//end constructor

    public void update(){
        expressionString.setNumber(value, functionNumber, digits);
        number.setNumber(value);
        Rect bounds = expressionString.getNumberBounds(functionNumber);
        x = bounds.left;
        //adjusts to potential offset caused by changing characters
    }//end update

    //draws the slider background, and the knob where it is determined by the current value
    public void draw(Canvas canvas, int left){
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, 0, 0), (float)x + left, (float)y, paint);
        double cx = x + (value - lower)/(upper - lower) * width - circleRadius,
                cy = y + (height/2 - circleRadius);
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, 1, 0), (float)cx + left, (float)cy, paint);
    }//end draw

    //sets the slider knob to where the touch event is
    public void onTouchEvent(MotionEvent event){
        value = event.getX() <= x ? lower :
                event.getX() >= x + width ? upper :
                        Math.floor(((event.getX()-x)/width*(upper-lower)+lower)/interval)*interval;
    }//end onTouchEvent

    public double getValue() {
        return value;
    }//end getValue

    public void setPanel(FunctionPanel panel) {
        expressionString = panel.getExpressionString();
        number = panel.getExpression().getNumber(functionNumber);
        startingValue = Float.parseFloat(expressionString.getNumber(functionNumber));
        reset();
    }//end set panel

    public void reset(){
        value = startingValue;
        update();
    }//end reset

    private boolean isDigit(char character){
        return character == '0' ||
                character == '1' ||
                character == '2' ||
                character == '3' ||
                character == '4' ||
                character == '5' ||
                character == '6' ||
                character == '7' ||
                character == '8' ||
                character == '9';
    }//end isDigit

    //Returns the bounds in which it will accept touch events
    public Rect getArea(){
        Rect rect = new Rect();
        double width = this.width*1.5, height=this.height*1.5, x = this.x-(this.width-width)/2, y = this.y + (this.height-height)/2;
        rect.set((int)(x), (int)(y), (int)(x + width), (int)(y + height));
        return rect;
    }
}//end class slider