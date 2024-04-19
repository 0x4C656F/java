package com.space_invaders;

import javafx.scene.image.Image;

public class BossShip extends EnemyShip {
    public static int size = 120;
    
    public BossShip(int x, int y) {
        super(new Image(StormShip.class.getResourceAsStream("/images/boss-ship.png")), x, y ,size);
        this.moveSpeed = 20;
        this.hp = 10;
        this.coinReward = 10;
    }
    
}
