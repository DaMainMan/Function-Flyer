package com.example.beaverduck.functionflyer.menu.base;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.menu.base.label.Label;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Menu {
    /*
    Basic abstract menu class which manages exiting and entering capabilities, label selection, and
    a title.
     */
    private ArrayList<Label> labels;
    private int[] orderX, orderY;
    private int selectedOption, exitingOption, optionSelected;
    private boolean entering, exitX;
    private Label title;
    private boolean exitFromRight, enterFromRight;

    /*
    Initializes initial enter/exit conditions, sets exiting and selected option to invalid state,
    sorts options, and initializes the titles
     */
    public Menu(Label title, boolean exitX, boolean enterFromRight){
        this.exitX = exitX;
        this.title = title;
        entering = true;
        exitingOption = -1;
        selectedOption = -1;
        labels = getOptions();
        this.orderX = new int[labels.size()];
        this.orderY = new int[labels.size()];
        HashMap orderX = new HashMap();
        HashMap orderY = new HashMap();
        for (int i = 0; i < labels.size(); i++) {
            Label label = labels.get(i);
            orderX.put(i, label.getArea().left);
            orderY.put(i, label.getArea().top);
            label.reset(enterFromRight);
        }//end for
        orderX = HashMapSorter.sortByValues(orderX);
        orderY = HashMapSorter.sortByValues(orderY);
        for (int i = 0; i < orderX.size(); i++) {
            this.orderX[i] = ((Integer)orderX.keySet().toArray()[i]);
            this.orderY[i] = ((Integer)orderY.keySet().toArray()[i]);
        }//end for
        if(title != null) this.title.reset(enterFromRight);
    }//end constructor

    protected abstract ArrayList<Label> getOptions();

    public void update(){
        for(int i = 0; i < labels.size(); i++){
            Label label = labels.get(i);
            label.update();
            if(i == selectedOption && isFinished()) label.select();
        }//end for
        if(title != null) title.update();
        if(exitingOption >= 0){
            if(title != null){
                if(title.isFinished())title.exit(exitFromRight);
            }//end if
            if(exitingOption < orderX.length){
                labels.get((exitX ? orderX : orderY)[exitingOption]).exit(exitFromRight);
                exitingOption++;
            }//end if
            else if(isFinished()){
                onExit(optionSelected);
                exitingOption = -1;
                selectedOption = -1;
                for(Label label : labels){
                    label.reset(enterFromRight);
                }//end for
                if(title != null)title.reset(enterFromRight);
            }//end if else
        }//end if
        else if(entering) entering = !isFinished();
    }//end update

    public void draw(Canvas canvas, int left){
        if(title != null)title.draw(canvas, left);
        for(Label label : labels){
            label.draw(canvas, left);
        }//end for
    }//end draw

    protected abstract void select(int selectedOption);
    protected abstract void onExit(int selectedOption);

    protected boolean isFinished(){
        for(Label label : labels){
            if(!label.isFinished()) return false;
        }//end for
        return true;
    }//end isFinished

    protected void exit(boolean exitFromRight, boolean enterFromRight){
        exitingOption++;
        this.exitFromRight = exitFromRight;
        this.enterFromRight = enterFromRight;
    }//end exit

    public void onTouchEvent(MotionEvent motionEvent){
        if(isFinished()) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (int i = 0; i < labels.size(); i++) {
                        Label label = labels.get(i);
                        if (label.getArea().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            selectedOption = i;
                            i = labels.size();
                        }//end if
                    }//end for
                    break;
                case MotionEvent.ACTION_UP:
                    if (selectedOption != -1) {
                        select(selectedOption);
                        optionSelected = selectedOption;
                        selectedOption = -1;
                    }//end if
                    break;
            }//end switch
        }//end if
    }//end onMotionEvent

    public abstract void onBackPressed();

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
        optionSelected = selectedOption;
    }
}//end class