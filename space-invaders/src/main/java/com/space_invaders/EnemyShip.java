package com.space_invaders;

import javafx.util.Duration;

import java.util.Random;


import javafx.animation.KeyFrame; 
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
public class EnemyShip extends Ship{

    public int coinReward ;

    public EnemyShip(@SuppressWarnings("exports") Image node, int x, int y, int size) {
        super(node, x, y, size);
        this.moveSpeed = 100 / size;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            shoot();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        initiateRandomMovement();
    }

    private void initiateRandomMovement() {
        boolean moveRight = new Random().nextBoolean();

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.5 * size/40), e -> moveBottom()),
            new KeyFrame(Duration.seconds(0.5 * 2 * size/40), e -> {
                if (moveRight) {
                    moveRight();
                } else {
                    moveLeft();
                }
            }),
            new KeyFrame(Duration.seconds(0.5 * 3 * size/40), e -> moveBottom()),
            new KeyFrame(Duration.seconds(0.5 * 4 * size/40), e -> {
                if (moveRight) {
                    moveLeft();
                } else {
                    moveRight();
                }
            })
        );
        timeline.setOnFinished(e -> initiateRandomMovement()); 
        timeline.setCycleCount(1); 
        timeline.play();
    }


    void animateMovement(double deltaX, double deltaY) {
        TranslateTransition transition = new TranslateTransition(new Duration(300), this);
        transition.setByX(deltaX);
        transition.setByY(deltaY);
        transition.play();
    }

    private void moveBottom() {
        if(hp <= 0){
            return;
        }
        double newY = Math.min(this.getTranslateY() + moveSpeed, 800 - size);
        if (newY != this.getTranslateY()) {
            animateMovement( 0, (double) newY - this.getTranslateY());
        }
    }

    public void shoot(){
        if(hp <= 0){
            return;
        }
        int bulletWidth = size / 12;
        int xCoord = (int) getTranslateX() + size / 2 - bulletWidth/ 2;
        int yCoord = (int) getTranslateY() +  size + bulletWidth * 2;
        Bullet bullet = new Bullet(xCoord, yCoord,bulletWidth, Direction.DOWN);
        ((AnchorPane)getParent()).getChildren().add(bullet);
    }

    @Override
    void destroy() {
        super.destroy();
        MainController.addCoins(coinReward);
    }

  
    
}
