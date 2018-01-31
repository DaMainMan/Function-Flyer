package com.example.beaverduck.functionflyer.levels.base;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.gamestate.LevelState;
import com.example.beaverduck.functionflyer.levels.base.function_panel.FunctionPanel;
import com.example.beaverduck.functionflyer.levels.base.function_panel.Slider;
import com.example.beaverduck.functionflyer.levels.base.object.GoalPlanet;
import com.example.beaverduck.functionflyer.levels.base.object.Player;
import com.example.beaverduck.functionflyer.levels.base.object.asteroid.Asteroid;
import com.example.beaverduck.functionflyer.levels.base.object.GameObject;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;
import com.example.beaverduck.functionflyer.levels.base.screen.FailScreen;
import com.example.beaverduck.functionflyer.levels.base.screen.SuccessScreen;
import com.example.beaverduck.functionflyer.levels.base.tutorial.TutorialScreen;
import com.example.beaverduck.functionflyer.levels.base.value.Value;
import com.example.beaverduck.functionflyer.menu.base.label.ImageLabel;

import java.util.ArrayList;

public abstract class GameLevel {
    /*
    * This class controls the partially determines the behaviour of objects in specific progressions
    * It allots touch focus to specific components (tutorials, fail/success screen, sliders, buttons, etc.)
    * It renders the space background and draws the y interval text
    *
     */
    public static final int OBJECT_ID = 3, TEXT_SIZE = 40, FUNCTION_PANEL_HEIGHT = 216;

    private int currentTutorial = -1;
    private ArrayList<TutorialScreen> tutorials;

    private ArrayList<GameObject> objects, addedObjects, removedObjects;
    private Player player;
    private GoalPlanet goalPlanet;

    private LevelState levelState;

    private final float yScale;
    private ImageLabel exitButton;
    private FunctionPanel panel;
    private LevelBounds bounds;
    private boolean exitButtonSelected;

    private LevelProgression progression;
    private SuccessScreen successScreen;
    private FailScreen failScreen;

    public GameLevel(float yScale, String function, float goalPlanetY) {
        addedObjects = new ArrayList<>();
        removedObjects = new ArrayList<>();
        this.yScale = yScale;
        panel = new FunctionPanel(getFunction(), function, getNumberSliders(), this);
        bounds = new LevelBounds();
        player = new Player();

        this.goalPlanet = new GoalPlanet(goalPlanetY);
        tutorials = setTutorials();
        if(tutorials.size() > 0){
            for(TutorialScreen tutorialScreen : tutorials){
                tutorialScreen.setGameLevel(this);
            }
            advanceTutorial();
        }
        objects = new ArrayList<>();
        objects.add(player);
        objects.add(this.goalPlanet);
        objects.addAll(setAsteroids());
        for(GameObject gameObject : objects){
            gameObject.setGameLevel(this);
        }
        exitButton = new ImageLabel(11, 10, GamePanel.getWIDTH()/50, GamePanel.getHEIGHT()/50);
        exitButtonSelected = false;
        failScreen = new FailScreen(this);
        successScreen = new SuccessScreen(this);
        reset(true);
    }//end constructor

    protected abstract Slider[] getNumberSliders();

    public void drawInterval(Canvas canvas, int left){
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 255, 255));
        paint.setTextSize(TEXT_SIZE);
        paint.setTypeface(Assets.getFont());
        for (int i = 1; i <= 5; i++){
            canvas.drawText(Integer.toString((int)(i * yScale)), 190 + left,  10 + 95 * (5 - (i - 1)), paint);
            canvas.drawText("-" + Integer.toString((int)(i * yScale)), 180 + left, GamePanel.getHEIGHT() - FUNCTION_PANEL_HEIGHT - (-10 + 95 * (5 - (i - 1))) - 70, paint);
        }//end for
    }//end drawInterval

    public void draw(Canvas canvas, int left){
        canvas.drawBitmap(Assets.getFrame(OBJECT_ID, 0, 0), left, 0, new Paint());
        drawInterval(canvas, left);
        exitButton.draw(canvas, left);
        for(GameObject object : objects){
            object.draw(canvas, left);
        }//end for
        panel.draw(canvas, left);
        if(progression.equals(LevelProgression.TUTORIAL)){
            tutorials.get(currentTutorial).draw(canvas, left);
        }
        else if(progression.equals(LevelProgression.SUCCEEDED)){
            successScreen.draw(canvas, left);
        }
        else if(progression.equals(LevelProgression.FAILED)){
            failScreen.draw(canvas, left);
        }
    }//end draw

    public void update(){
        Position.setyScale(yScale);
        exitButton.update();
        panel.update();
        if(exitButtonSelected) exitButton.select();
        if(progression.equals(LevelProgression.FAILED)){
            failScreen.update();
        }
        else if(progression.equals(LevelProgression.SUCCEEDED)){
            successScreen.update();
        }
        for(GameObject object : objects){
            object.update();
        }//end for
        objects.addAll(addedObjects);
        objects.removeAll(removedObjects);
        addedObjects = new ArrayList<>();
        removedObjects = new ArrayList<>();
    }//end update

    protected abstract ArrayList<TutorialScreen> setTutorials();

    public void onTouchEvent(MotionEvent e){
        if(progression.equals(LevelProgression.TUTORIAL)){
            tutorials.get(currentTutorial).onTouchEvent(e);
        }
        else if(progression.equals(LevelProgression.BUILDING)) {
            if (exitButton.getArea().contains((int) e.getX(), (int) e.getY())) {
                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        exitButtonSelected = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        exitButtonSelected = false;
                        levelState.getGsm().setGameState(0);
                        reset(true);
                        break;
                }//end switch
            }//end if
            else {
                exitButtonSelected = false;
                panel.onTouchEvent(e);
            }//end else
        }//end if
        else if(progression.equals(LevelProgression.SUCCEEDED)){
            successScreen.onTouchEvent(e);
        }
        else if(progression.equals(LevelProgression.FAILED)){
            failScreen.onTouchEvent(e);
        }
    }//end onTouchEvent

    protected abstract ArrayList<Asteroid> setAsteroids();//end setAsteroid
    protected abstract Value getFunction();//end getFunction

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }//end setLevelState

    public void launch(){
        progression = LevelProgression.SIMULATING;
    }//end launch

    public LevelProgression getProgression() {
        return progression;
    }

    public void fail(){
        progression = LevelProgression.FAILED;
    }

    public void succeed(){
        progression = LevelProgression.SUCCEEDED;
    }

    public LevelBounds getBounds() {
        return bounds;
    }

    public Player getPlayer() {
        return player;
    }

    public GoalPlanet getGoalPlanet() {
        return goalPlanet;
    }

    public FunctionPanel getPanel() {
        return panel;
    }

    public void reset(boolean sliders){
        currentTutorial = -1;
        player.reset();
        panel.reset(sliders);
        advanceTutorial();
        //resets the level progression, the expression, and the player position
    }//end reset

    public LevelState getLevelState() {
        return levelState;
    }//end getLevelState

    public void advanceTutorial() {
        currentTutorial++;
        progression = currentTutorial >= tutorials.size() ? LevelProgression.BUILDING : LevelProgression.TUTORIAL;
    }//end advanceTutorial

    public void onBackPressed(){
        if(progression.equals(LevelProgression.BUILDING) || progression.equals(LevelProgression.FAILED)) {
            levelState.getGsm().setGameState(0);
            reset(true);
        }//end if
    }//end onBackPressed

    public void addObject(GameObject object){
        addedObjects.add(object);
    }//end addObject

    public void removeObject(GameObject object){
        removedObjects.add(object);
    }//end removeObject
}//end class