package com.ratattack.game;

public class GameSettings {

    // Constants for spawntime and lane number
    public static long ratSpawnrate = 8000;
    public static long startRatSpawnRate = 8000;
    public static final long startGrandChildSpawnrate = 10000;
    public static final int gameLaneNr = 4;
    public static final int tutorialLaneNr = 2;

    public static final int finishLine = 150; //Pixels from bottom
    public static boolean debug = false;


    // Constants for adding difficulty to game
    public static final int[] ratSpeed = {-3, -7, -11, -15};
    public static final int[] spawnRates = {8000, 6000, 4000, 2000};
    public static final int[] changeLevelScore = {100, 200, 300, 400};

    //Setup for rendering on screen
    public static int grandmotherLine = 20;


    //Health and strength constants
    public static final int ratStartHealth = 20;
    public static final int grandChildStartHealth = 50;

    public static final int normalBulletStrength = 10;
    public static final int tripleBulletStrength = 10;
    public static final int bigBulletStrength = 20;
    public static final int fastBulletStrength = 10;
    public static final int freezeBulletStrength = 10;

    //Velocity constants
    public static final int freezeVelocity = -2;
    public static final int startSpeedRat = -3;
    public static final int startSpeedGrandchild = -1;

}
