package com.space_invaders;

import javafx.animation.AnimationTimer;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
public class Bullet extends Rectangle {
    private int speed = 3;
    public Direction direction;
    public int width;



    public Bullet(double x, double y, int width, Direction direction) {

        super(x, y, width, width*3); 
        this.width = width;

        
        
        this.direction = direction;
        if(direction == Direction.CUSTOM){
        Rotate rotation = new Rotate();
        rotation.setAngle(-90+direction.getAngle());
        rotation.setPivotX(x + width / 2);
        rotation.setPivotY(y + width * 3 / 2);

        // Apply the rotation to the bullet
        getTransforms().add(rotation);
    }

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        switch (direction) {
            case UP:
                this.setFill(Color.LIGHTGREEN);
                dropShadow.setColor(Color.LIGHTGREEN);
                break;
            case DOWN:
                this.setFill(Color.RED);
                dropShadow.setColor(Color.RED);
                break;
            case CUSTOM:
                this.setFill(Color.BLUEVIOLET);
                dropShadow.setColor(Color.BLUEVIOLET);
                break;
        }
        dropShadow.setSpread(0.5); 
        this.setEffect(dropShadow);

        
        
        MainController.addBullet(this);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(MainController.isGameEnded){
                    stop();
                    return;
                }
                if (getTranslateY() < -MainController.FIELD_HEIGHT || getTranslateY() > MainController.FIELD_HEIGHT ){
                    MainController.removeBullet(Bullet.this);
                    stop();
                }
                if(!MainController.bullets.contains(Bullet.this)){
                    stop();
                    return;
                }
        updateRotation(direction);

                moveBullet();
            };
            
        };
        timer.start();
    }
    public void updateRotation(Direction direction) {
        if (direction.getAngle() != null) {
            double angle = direction.getAngle(); 
            setRotate(angle); 
        }
    }
    private void moveBullet() {  
                switch (direction) {
                    case UP:
                        setTranslateY(getTranslateY() - speed);
                        break;
                    case DOWN:
                        setTranslateY(getTranslateY() + speed);
                        break;
                    case CUSTOM:
                    if(direction.getAngle() == null){
                        return;
                    }
                       
                        int angle = direction.getAngle();
                        double rotate = Math.toRadians(angle);
                        Bullet.this.setRotate(rotate);
                        double deltaX = Math.cos(Math.toRadians(angle)) * speed;
                        double deltaY = Math.sin(Math.toRadians(angle)) * speed;
                        setTranslateX(getTranslateX() + deltaX);
                        setTranslateY(getTranslateY() + deltaY);
                        break;
                }
                
            }

}
