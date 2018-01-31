package com.example.beaverduck.functionflyer.engine.assets;

import android.graphics.Bitmap;

import com.example.beaverduck.functionflyer.engine.GamePanel;

/*
Allows for easy manipulation of the graphics in order to quickly fix graphic imperfections
  - Flipping Horizontally
  - Flipping Vertically
  - Resizing based on a scale
  - Resizing based on specific pixel sizes
  - Resizing to cover the full screen
*/
public class ChangeableImage {
    private Bitmap bitmap;
    public ChangeableImage(Bitmap bitmap){
        this.bitmap = bitmap;
    }//end ChangeableImage

    public ChangeableImage flipX(){
        Bitmap newBitmap = Bitmap.createBitmap(bitmap);
        for(int x = 0; x < bitmap.getWidth(); x++){
            int xPos = newBitmap.getWidth() - x - 1;
            for(int y = 0; y < newBitmap.getHeight(); y++){
                newBitmap.setPixel(xPos, y, bitmap.getPixel(x, y));
            }//end for
        }//end for
        return new ChangeableImage(newBitmap);
    }//end flipX

    //Resizes image according to a scale (resize(2f, 2f) would result in an image twice as large)
    public ChangeableImage resize(float xScale, float yScale){
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * xScale), (int)(bitmap.getHeight() * yScale), false);
        return new ChangeableImage(newBitmap);
    }//end resize

    //Resizes image according to a specific width and height(2, 2) would result in a 2 by 2 pixel image

    public Bitmap getBitmap() {
        return bitmap;
    }//end getBitmap

    //Resizes image, according to one dimension, to the GamePanel's Width or Height, depending on the condition of boolean x
    public ChangeableImage fullscreen(boolean x){
        float scale = x ? (float)GamePanel.getWIDTH()/bitmap.getWidth() : (float)GamePanel.getHEIGHT()/bitmap.getHeight();
        return resize(scale, scale);
    }//end fullscreen
}//end class
