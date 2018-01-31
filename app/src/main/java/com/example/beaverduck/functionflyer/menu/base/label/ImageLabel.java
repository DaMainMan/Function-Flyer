package com.example.beaverduck.functionflyer.menu.base.label;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.engine.assets.Assets;
import com.example.beaverduck.functionflyer.levels.base.object.Animation;
/*

 */
public class ImageLabel extends Label {
    private Animation selectedAnimation, unselectedAnimation;
    private Rect area;
    private static final int OBJECT_ID = 1;

    //Instantiates position to a specified x and y position
    public ImageLabel(int selectedAnimation, int unselectedAnimation, int x, int y){
        super();
        this.selectedAnimation = new Animation(OBJECT_ID, selectedAnimation, true, 1);
        this.unselectedAnimation = new Animation(OBJECT_ID, unselectedAnimation, true, 1);
        Bitmap bitmap = this.selectedAnimation.getFrame(0);
        area = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
        setArea(area);
    }//end constructor

    //Instantiates position to a specified y, but a centered x
    public ImageLabel(int selectedAnimation, int unselectedAnimation, int y){
        this(selectedAnimation, unselectedAnimation, 0, y);
        int imgWidth = this.selectedAnimation.getFrame(0).getWidth(),
        imgX = (GamePanel.getWIDTH() - imgWidth)/2;
        area.set(area.left + imgX, area.top, area.right + imgX, area.bottom);
        setArea(area);
    }//end constructor

    //Instantiates position to center label in the screen.
    public ImageLabel(int selectedAnimation, int unselectedAnimation){
        this(selectedAnimation, unselectedAnimation, 0, 0);
        int left = (GamePanel.getWIDTH() - Assets.getFrame(OBJECT_ID, unselectedAnimation, 0).getWidth())/2,
        top = (GamePanel.getHEIGHT() - Assets.getFrame(OBJECT_ID, unselectedAnimation, 0).getHeight())/2;
        area.left += left;
        area.right += left;
        area.top += top;
        area.bottom += top;
        setArea(area);
    }

    //draws the selected or unselected sprite, depending on the condition of boolean selected
    @Override
    public void draw(Canvas canvas, int left) {
        canvas.drawBitmap((selected ? selectedAnimation : unselectedAnimation).getFrame(), area.left + offset + left, area.top, new Paint());
    }//end draw


    public void setPosition(int x, int y){
        area.set(x, y, area.right - area.left + x, area.bottom - area.top + y);
    }//end setPosition

    public int getWidth(){
        return area.right - area.left;
    }

    public int getHeight(){
        return area.bottom - area.top;
    }
}//end class