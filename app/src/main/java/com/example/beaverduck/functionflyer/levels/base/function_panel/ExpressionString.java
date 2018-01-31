package com.example.beaverduck.functionflyer.levels.base.function_panel;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;

import java.util.ArrayList;

public class ExpressionString {
    //This class stores and renders the text for the expression on to the function panel
    private static final int TEXT_SIZE = 100;
    private int x, y;
    private ArrayList<String> components;
    public ExpressionString(String string){
        components = new ArrayList<>();
        parseString(string);
        x = GamePanel.getWIDTH()/30;
        y = GamePanel.getHEIGHT() * 28/30;
    }//end constructor

    private void parseString(String string){
        //the components are order dependent. (number, not number, number, not number), until the end of the string
        string = "y = " + string;
        char[] chars = string.toCharArray();
        String component = "";
        for(int i = 0; i < chars.length; i++){
            char character = chars[i];
            if(isDigit(character) && i == 0){
                addComponent(component);
                component = "";
            }
            else if(i != 0 && isDigit(character) && chars[i-1] != '-' && chars[i-1] != '.' && !isDigit(chars[i-1])){
                addComponent(component);
                component = "";
            }
            else if(character == '-'){
                addComponent(component);
                component = "";
            }
            else if(i != 0 && !isDigit(character) && isDigit(chars[i-1])){
                addComponent(component);
                component = "";
            }//end if else
            component += String.valueOf(character);
            if(i == chars.length-1) addComponent(component);
        }//end for
    }//end parseString

    private void addComponent(String component){
        components.add(component);
    }//end addComponent

    public void setNumber(double number, int dir, int digits){
        String numberString = number + "";
        char[] chars = numberString.toCharArray();
        numberString = "";
        int digitCount = 0;
        boolean decimal = false;
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            numberString += character;
            if(isDigit(character) && decimal) digitCount++;
            else if(character == '.')decimal = true;
            if(digitCount == digits) i = chars.length;
        }//end for
        components.set(1 + dir * 2, numberString);
    }//end setNumber

    //returns the text bounds of the number at directory dir
    public Rect getNumberBounds(int dir){
        int component = dir*2+1;
        String preNumber = "";
        for (int i = 0; i < component; i++) {
            preNumber += components.get(i);
        }//end for
        Rect bounds = new Rect(), preNumberBounds = new Rect();
        Paint textPaint = new Paint();
        textPaint.setTypeface(Assets.getFont());
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.getTextBounds(preNumber, 0, preNumber.length(), preNumberBounds);
        String number = components.get(component);
        textPaint.getTextBounds(number, 0, number.length(), bounds);
        bounds.set(preNumberBounds.right+x, bounds.top, preNumberBounds.right+bounds.right+x, bounds.bottom);
        return bounds;
    }//end getNumberBounds

    //returns the entire string put together to render
    private String getExpressionString(){
        String string = "";
        for(int i = 0; i < components.size(); i++){
            String component = components.get(i);
            string += component;
        }
        return string;
    }

    public String getNumber(int dir){
        for(int i = 0; i < components.size(); i++){
        }
        return components.get(1 + dir * 2);
    }//end getNumber

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

    //draws the expression
    public void draw(Canvas canvas, int left){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(56, 56, 56));
        paint.setTextSize(TEXT_SIZE);
        paint.setTypeface(Assets.getFont());
        canvas.drawText(getExpressionString(), x + left, y, paint);
    }//end draw
}//end class