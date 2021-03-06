package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class LudumJam33Game extends StateBasedGame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FPS = 60;
    public static final String VERSION = "1.0",
            TITLE = "Ludum Jam 33: Abduction";
    public static final String ICON = "/res/img/gui/icon.tga";
    private static AppGameContainer app;

    public LudumJam33Game(String appName) {
        super(appName);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        AnimHelper.setupAnimations();
        SoundHelper.loadSounds();
        addState(new StartScreen());
        addState(new Tutorial());
    	addState(new InGame());
    	addState(new UpgradeScreen());
    	addState(new WinScreen());
    }

    @Override
    protected void preRenderState(GameContainer container, Graphics g)
            throws SlickException {
        super.preRenderState(container, g);
        g.setBackground(new Color(255,255,255)); 
        container.setShowFPS(false);
        //g.setAntiAlias(true);
    }
    
    public static void begin(String[] args) {
        try {
            app = new AppGameContainer(new LudumJam33Game(TITLE + " v" + VERSION));
            app.setIcon(ICON);
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setVSync(true);
            app.setForceExit(false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static AppGameContainer getAGContainer() {
        return app;
    }
}