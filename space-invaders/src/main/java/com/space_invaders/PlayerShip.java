package com.space_invaders;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
public class PlayerShip extends Ship{
    public static int size = 50;
    public PlayerShip( int x, int y) {
        super(new Image(PlayerShip.class.getResourceAsStream("/images/player-ship.png")), x, y, size);
        this.moveSpeed = 50;
        this.hp = 3;
    }
    @Override
    public void hit(){
        super.hit();
        if(hp == 2){
            setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/player-ship-broken-1.png"))));

        }
        else if(hp == 1){
            setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/images/player-ship-broken-2.png"))));
        }
        
    }

    public int getHp(){return hp;}
    public int setHp(int hp){return this.hp = hp;}

    class OverrideControls implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.LEFT) {
                moveLeft();
            } else if (event.getCode() == KeyCode.RIGHT) {
                moveRight();
            } 
            if (event.getCode() == KeyCode.SPACE) {
                shoot();
            }
            event.consume();
        }
    }

    public void shoot(){
        if(hp <= 0){
            return;
        }
        int bulletWidth = size / 12;
        int xCoord = (int) getTranslateX() + size / 2 - bulletWidth/ 2;
        int yCoord = (int) ((int) getTranslateY() + size / 2 - bulletWidth * 2);
        Bullet bullet = new Bullet(xCoord, yCoord,bulletWidth, Direction.UP);
        MainController.addBullet(bullet);
        ((AnchorPane)getParent()).getChildren().add(bullet);
        bullet.toBack();
    }

    
}
