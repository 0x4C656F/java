package com.space_invaders;

import javafx.scene.image.Image;

public class StormShip extends EnemyShip {
    public static int size = 40;
    public StormShip(int x, int y) {
        super(new Image(StormShip.class.getResourceAsStream("/images/storm-ship.png")), x, y ,size);
        this.moveSpeed = 50;
        this.hp = 1;
        this.coinReward = 1;
    }
}
