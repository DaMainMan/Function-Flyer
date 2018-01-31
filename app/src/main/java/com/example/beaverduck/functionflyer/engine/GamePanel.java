package com.example.beaverduck.functionflyer.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.gamestate.GameStateManager;
/*
Controls the timing and rendering for the game
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private boolean running;
    private Thread thread;
    private Canvas canvas;
    private GameStateManager gsm;
    private static int WIDTH, HEIGHT, LEFT;
    private Context context;

    //Takes the activity and derives the resource folders
    public GamePanel(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        this.context = context;
    }//end constructor

    //Starts the game thread and enables running
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        running = true;
        thread.start();
    }//end surfaceCreated

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }//end surfaceChanged

    //Disables running and safely ends the thread
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry){
            try {
                running = false;
                thread.join();
                retry = false;
            }
            catch (Exception e){
                e.printStackTrace();
            }//end try catch
        }//end while
    }//end surfaceDestroyed


    //Takes touch input and gives it to GameStateManager
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        event.setLocation(event.getX() - LEFT, event.getY());
        if(gsm != null) gsm.onTouchEvent(event);
        return true;
    }//end onTouchEvent

    //Updates the GameStateManager
    public void update() {
        gsm.update();
    }//end update

    //Draws the GameStateManager
    @Override
    public void draw(Canvas canvas) {
        if(canvas != null) {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            gsm.draw(canvas, LEFT);
            canvas.drawRect(0, 0, LEFT + 1, canvas.getHeight(), paint);
            canvas.drawRect(LEFT + WIDTH, 0, canvas.getWidth(), canvas.getHeight(), paint);
        }
    }//end draw

    //Controls the update timing and rendering of the game
    @Override
    public void run() {
        try {
            canvas = getHolder().lockCanvas();
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            if(width/height > 1.7777778) width = (float) (height*1.7777778);
            else height= (float) (width*1/1.7777778);
            GamePanel.WIDTH = (int) width;
            GamePanel.HEIGHT = (int) height;
            GamePanel.LEFT = (canvas.getWidth()-WIDTH)/2;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(canvas != null) getHolder().unlockCanvasAndPost(canvas);
        }//end try catch finally
        Assets.loadAssets(context);
        gsm = new GameStateManager();

        long lastTime = System.nanoTime(), timer = System.currentTimeMillis();
        double fps = 60, nspt = 1000000000/fps, delta = 0;
        int frames = 0, updates = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime)/nspt;
            lastTime = now;
            while (delta >= 1){
                update();
                delta--;
                updates++;
            }//end while
            canvas = getHolder().lockCanvas();
            draw(canvas);
            try {
                getHolder().unlockCanvasAndPost(canvas);
            }
            catch (IllegalArgumentException e){
                System.out.println("Illegal Argument Thrown");
            }
            frames++;
            if(System.currentTimeMillis() - timer >= 1000){
                //System.out.println("FPS: " + frames + ", Ticks: " + updates);
                frames = 0;
                updates = 0;
                timer += 1000;
            }//end if
        }//end while
    }//end run

    public static int getWIDTH() {
        return WIDTH;
    }//end getWidth

    public static int getHEIGHT() {
        return HEIGHT;
    }//end getHeight

    public boolean isRunning() {
        return running;
    }

    public void onBackPressed(){
        gsm.onBackPressed();
    }
}//end class