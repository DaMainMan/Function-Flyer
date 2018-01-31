package com.example.beaverduck.functionflyer.engine.assets;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;

import com.example.beaverduck.functionflyer.R;
import com.example.beaverduck.functionflyer.engine.GamePanel;
import com.example.beaverduck.functionflyer.levels.base.object.position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/*
Access all graphics being used in the game from the resources
*/
public class Assets {
    private static ArrayList<ArrayList<ArrayList<Bitmap>>> images;
    private static ArrayList<MediaPlayer> sounds;
    private static Typeface font;
    private static ArrayList<Integer> pausedAudio;

    public static void loadAssets(Context context){
        pausedAudio = new ArrayList<>();
        Resources resources = context.getResources();
        AssetManager assetManager = context.getApplicationContext().getAssets();
        images = new ArrayList<>();
        sounds = new ArrayList<>();
        font = Typeface.createFromAsset(assetManager, String.format(Locale.US, "fonts/%s", "futura.ttf"));
        loadImages(resources);
    }//end Assets


    /*
    Create an array of all labels/buttons being used in the game

    NOTE: Comment after each line indicates the number
    which can be used to reference that graphic later in the code.
    */


    private static void loadImages(Resources resources){
        loadPlayer(resources);//0
        loadLabels(resources);//1
        loadFunctionPanel(resources);//2
        loadLevel(resources);//3
        loadSlider(resources);//4
        loadMainMenu(resources);//5
        loadPlanet(resources);//6
        loadAsteroid(resources);//7
        loadTutorialScreens(resources);//8
        loadMenuBackground(resources);//9
    }
    private static void loadLabels(Resources resources){
        ArrayList<ArrayList<Bitmap>> labels = new ArrayList<>();
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffarrow))));//0
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffarrowpressed))));//1
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fftestbutton))));//2
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fftestbuttonpressed))));//3
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton1))));//4
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton2))));//5
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton3))));//6
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton4))));//7
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffarrow)).flipX().getBitmap())));//8
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffarrowpressed)).flipX().getBitmap())));//9
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffexitbutton))));//10
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffexitbuttonpressed))));//11
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton1pressed))));//12
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton2pressed))));//13
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton3pressed))));//14
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fflevelbutton4pressed))));//15
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fftestbutton))));//16
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.fftestbuttonpressed))));//17
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffmainmenuplaybutton))));//18
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffmainmenuplaybuttonpressed))));//19
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffmainmenucreditsbutton))));//20
        labels.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffmainmenucreditsbuttonpressed))));//21
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffmainmenudesign)).fullscreen(false).getBitmap())));//22
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffsuccessscreenbackground)).resize(2f, 2f).getBitmap())));//23
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fffailscreenbackground)).resize(2f, 2f).getBitmap())));//24
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffretrybutton)).resize(2f, 2f).getBitmap())));//25
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffretrybuttonpressed)).resize(2f, 2f).getBitmap())));//26
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffnextlevelbutton)).resize(2f, 2f).getBitmap())));//27
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffnextlevelbuttonpressed)).resize(2f, 2f).getBitmap())));//28
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffexittolevelselectbutton)).resize(2f, 2f).getBitmap())));//29
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffexittolevelselectbuttonpressed)).resize(2f, 2f).getBitmap())));//30
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffcreditscreen)).fullscreen(false).getBitmap())));//31
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffgalaxyonetext)).resize(1.75f, 1.75f).getBitmap())));//32
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffgalaxytwotext)).resize(1.75f, 1.75f).getBitmap())));//33
        labels.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffgalaxythreetext)).resize(1.75f, 1.75f).getBitmap())));//34
        images.add(labels);
    }//end loadLabels

    private static void loadFunctionPanel(Resources resources){
        ArrayList<ArrayList<Bitmap>> functionPanel = new ArrayList<>();
        functionPanel.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fffunctionpanel)).fullscreen(true).getBitmap())));
        images.add(functionPanel);
    }//end loadFunctionPanel

    private static void loadLevel(Resources resources){
        ArrayList<ArrayList<Bitmap>> level = new ArrayList<>();
        Bitmap spacebg = loadImage(resources, R.drawable.ffspacebg);
        float scale = (float)GamePanel.getWIDTH()/spacebg.getWidth();
        spacebg = new ChangeableImage(spacebg).resize(scale, scale).getBitmap();
        Position.setyConversion(spacebg.getHeight()/12);
        Position.setxConversion(Position.getyConversion());
        Position.setxOffset(-218/Position.getxConversion());
        Position.setyOffset(-6);
        level.add(new ArrayList<>(Arrays.asList(spacebg)));//0
        images.add(level);
    }//end loadLevel

    private static void loadPlanet(Resources resources){
        ArrayList<ArrayList<Bitmap>> planet = new ArrayList<>();
        planet.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffgoalplanet))));//0
        images.add(planet);
    }//end loadPlanet

    private static void loadPlayer(Resources resources){
        ArrayList<ArrayList<Bitmap>> player = new ArrayList<>();
        ArrayList<Bitmap> flameAnimation = new ArrayList<>(Arrays.asList(
                loadImage(resources, R.drawable.ffrocketpixel),
                loadImage(resources, R.drawable.ffrocketpixel2),
                loadImage(resources, R.drawable.ffrocketpixel3))),
        offAnimation = new ArrayList<>(Arrays.asList(
                loadImage(resources, R.drawable.ffrocketpixelnofire)
        ));
        player.add(offAnimation);//0
        player.add(flameAnimation);//1
        player.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffrocketparticletrail)).resize(4f, 4f).getBitmap())));//2
        images.add(player);
    }//end loadPlayer

    private static void loadAsteroid(Resources resources){
        ArrayList<ArrayList<Bitmap>> asteroids = new ArrayList<>();
        asteroids.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffasteroidmedium))));
        asteroids.add(new ArrayList<>(Arrays.asList(loadImage(resources, R.drawable.ffasteroidlarge))));
        images.add(asteroids);
    }//end loadAsteroid

    private static void loadMainMenu(Resources resources){
        ArrayList<ArrayList<Bitmap>> menus = new ArrayList<>();
        Bitmap resource = loadImage(resources, R.drawable.ffmainmenudesign);
        float scale = (float)GamePanel.getWIDTH()/resource.getWidth();
        resource = new ChangeableImage(resource).resize(scale, scale).getBitmap();
        menus.add(new ArrayList<>(Arrays.asList(resource)));
        images.add(menus);
    }//end loadMainMenu

    private static void loadSlider(Resources resources){
        ArrayList<ArrayList<Bitmap>> slider = new ArrayList<>();
        slider.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffslider)).resize(2.75f, 2.75f).getBitmap())));
        slider.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffsliderbutton)).resize(2.75f, 2.75f).getBitmap())));
        images.add(slider);
    }//end loadSlider

    private static void loadTutorialScreens(Resources resources){
        ArrayList<ArrayList<Bitmap>> tutorials = new ArrayList<>();
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxyonelevelonepartone)).resize(2f, 2f).getBitmap())));//35
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxyoneleveloneparttwo)).resize(2f, 2f).getBitmap())));//36
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxyonelevelthreepartone)).resize(2f, 2f).getBitmap())));//37
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxytwolevelonepartone)).resize(2f, 2f).getBitmap())));//38
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxytwoleveltwopartone)).resize(2f, 2f).getBitmap())));//39
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxythreelevelonepartone)).resize(2f, 2f).getBitmap())));//40
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxythreeleveltwopartone)).resize(2f, 2f).getBitmap())));//41
        tutorials.add(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.fftutorialscreengalaxythreelevelthreepartone)).resize(2f, 2f).getBitmap())));//42
        images.add(tutorials);
    }

    private static void loadMenuBackground(Resources resources){
        ArrayList<ArrayList<Bitmap>> spaceBG = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(new ChangeableImage(loadImage(resources, R.drawable.ffspacebackground)).fullscreen(true).getBitmap()))));
        images.add(spaceBG);
    }

    private static Bitmap loadImage(Resources resources, int id){
        Bitmap bitmap = BitmapFactory.decodeResource(resources, id);
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/4, bitmap.getHeight()/4, false);
    }//end loadImage

    public static Bitmap getFrame(int object, int animation, int frame){
        return images.get(object).get(animation).get(frame);
    }//end getFrame

    public static int getAnimationLength(int object, int animation){
        return images.get(object).get(animation).size();
    }//end getAnimationLength

    public static Typeface getFont() {
        return font;
    }//end getFont

    public static MediaPlayer getAudio(int audio){
        return sounds.get(audio);
    }

    public static void pauseAudio() {
        if(sounds != null) {
            pausedAudio = new ArrayList<>();
            for (int i = 0; i < sounds.size(); i++) {
                MediaPlayer mediaPlayer = sounds.get(i);
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    pausedAudio.add(i);
                }
            }
        }
    }

    public static void resumeAudio(){
        if(pausedAudio != null && sounds != null) {
            for (int i = 0; i < pausedAudio.size(); i++) {
                sounds.get(pausedAudio.get(i)).start();
            }
        }
    }
}//end class