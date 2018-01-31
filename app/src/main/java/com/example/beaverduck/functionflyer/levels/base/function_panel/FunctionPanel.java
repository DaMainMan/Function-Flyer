package com.example.beaverduck.functionflyer.levels.base.function_panel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.GameLevel;
import com.example.beaverduck.functionflyer.levels.base.value.Value;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;

public class FunctionPanel {
    //Handles the sliders, and the expression string
    private Value expression;
    private ExpressionString expressionString;
    private Slider[] sliders;
    private ImageLabel launchButton;
    private boolean launchButtonSelected;
    public static final int OBJECT_ID = 2;
    private GameLevel gameLevel;
    private Slider selectedSlider;
    private int height;

    public FunctionPanel(Value expression, String expressionString, Slider[] sliders, GameLevel gameLevel){
        this.gameLevel = gameLevel;
        launchButton = new ImageLabel(17, 16, 0, 0);
        launchButton.setPosition(GamePanel.getWIDTH() * 29/30 - launchButton.getWidth(), GamePanel.getHEIGHT() * 28/30 - launchButton.getHeight());
        launchButtonSelected = false;
        this.expression = expression;
        this.expressionString = new ExpressionString(expressionString);
        for(Slider slider : sliders){
            slider.setPanel(this);
        }//end for
        selectedSlider = null;
        this.sliders = sliders;
        height = Assets.getFrame(OBJECT_ID, 0, 0).getHeight();
    }//end constructor

    public void draw(Canvas canvas, int left){
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, 0, 0), left, GamePanel.getHEIGHT() - height, new Paint());
        //draws the function panel background
        expressionString.draw(canvas, left);
        for (Slider slider : sliders) {
            slider.draw(canvas, left);
        }//end for
        launchButton.draw(canvas, left);
    }//end draw

    public void update(){
        launchButton.update();
        if(launchButtonSelected) launchButton.select();
        for(Slider slider : sliders){
            slider.update();
        }//end slider
    }//end update

    public ExpressionString getExpressionString() {
        return expressionString;
    }//end getExpressionString

    public Value getExpression() {
        return expression;
    }//end getExpression


    public void onTouchEvent(MotionEvent e){
        if(launchButton.getArea().contains((int)e.getX(), (int)e.getY())){
            switch (e.getAction()){
                case MotionEvent.ACTION_DOWN:
                    launchButtonSelected = true;
                    break;
                case MotionEvent.ACTION_UP:
                    launchButtonSelected = false;
                    gameLevel.launch();
                    break;
            }//end switch
        }//end if
        else{
            launchButtonSelected = false;
            if(e.getAction() == MotionEvent.ACTION_DOWN) {
                selectedSlider = null;
                for (Slider slider : sliders) {
                    if (slider.getArea().contains((int) e.getX(), (int) e.getY())) {
                        selectedSlider = slider;
                    }//end if
                }//end for
            }//end if
            else {
                if(selectedSlider != null)selectedSlider.onTouchEvent(e);
            }//end else
        }//end else
    }//end onTouchEvent

    //resets the sliders to their initial position
    public void reset(boolean sliders) {
        if(sliders) {
            for (Slider slider : this.sliders) {
                slider.reset();
            }//end for
        }//end if
        selectedSlider = null;
    }//end reset
}//end class