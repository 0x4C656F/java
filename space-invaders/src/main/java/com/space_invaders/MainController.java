package com.space_invaders;

import java.util.ArrayList;
import java.util.List;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class MainController {

    @FXML
    private AnchorPane field;

    public static final int FIELD_WIDTH = 600;

    public static final int FIELD_HEIGHT = 800;

    public PlayerShip playerShip;

    public static boolean isGameEnded = false;

    public static int coins = 0;

    public static List<Ship> ships = new ArrayList<>();

    public static List<Bullet> bullets = new ArrayList<>();

    private List<ImageView> hpImages = new ArrayList<>();
    
    private long lastCheckTime = 0; 

    public void initialize() {
        loadPlayerShip();

        Turret turret = new Turret( 50, FIELD_HEIGHT-100);
        field.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.H) {
                turret.shoot();
            }
        });

        field.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            System.out.println("Clicked at x: " + x + ", y: " + y);
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
            spawnRandomEnemyShip();
        }));

        HBox scoreBox = new HBox();
        Image scoreImage = new Image(getClass().getResourceAsStream("/images/coin.png"));
        ImageView scoreImageView = new ImageView(scoreImage);
        scoreImageView.setFitWidth(30);
        scoreImageView.setPreserveRatio(true);
        Label scoreLabel = new Label(String.valueOf(coins));
        scoreLabel.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-font-weight: bold;");
        scoreBox.getChildren().addAll(scoreImageView, scoreLabel);
        scoreBox.setLayoutX(FIELD_WIDTH - 80);
        scoreBox.setLayoutY(FIELD_HEIGHT - 40);
        loadHeartImages();
        field.getChildren().addAll(scoreBox, turret);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                scoreLabel.setText(String.valueOf(coins));
                if(playerShip.getHp() <= 0) {
                    this.stop();
                    timeline.stop();    
                    return;
                };

                if (now - lastCheckTime > 300_000_000) { 
                    turret.checkInterception();
                    lastCheckTime = now;
                }
            checkCollision();
            }
        }.start();
    }

    private void loadHeartImages () {
        Image image = new Image(getClass().getResourceAsStream("/images/heart.png"));
        hpImages.clear(); 

        for (int i = 0; i < playerShip.getHp(); i++) {
            ImageView heart = new ImageView(image);
            heart.setFitWidth(30);
            heart.setPreserveRatio(true);
            heart.setLayoutX(10 + i * 30);
            heart.setLayoutY(FIELD_HEIGHT-40);
            field.getChildren().add(heart);
            hpImages.add(heart); 
        }
    }


    private void spawnRandomEnemyShip() {
        int randomXCoord = (int) (Math.random() * FIELD_WIDTH);
        int randomInt = (int) (Math.random() * 20);
        if(randomInt < 19){
            EnemyShip ship = new StormShip(randomXCoord, -StormShip.size);
            field.getChildren().add(ship);
            ships.add(ship);
        } else {
            EnemyShip ship = new BossShip(randomXCoord, -BossShip.size);
            field.getChildren().add(ship);
            ships.add(ship);
        }
    }

    public static void addCoins(int additionalCoins) {
        coins += additionalCoins;
    }

    private void loadPlayerShip() {
        playerShip = new PlayerShip( FIELD_WIDTH/2 - PlayerShip.size/2, 700);
        playerShip.setHp(3);
        ships.add(playerShip);

        field.getChildren().add(playerShip);
        field.setFocusTraversable(true);
        field.requestFocus();
        field.setOnKeyReleased(playerShip.new OverrideControls());
        
    }
    
    public void checkCollision() {
        for (Bullet bullet : bullets) {
            for (Ship ship : ships) {
                if (ship.getBoundsInParent().intersects(bullet.getBoundsInParent())) {
                    if(ship instanceof EnemyShip && (bullet.direction == Direction.UP || bullet.direction == Direction.CUSTOM)){
                        ship.hit();
                        removeBullet(bullet);
                    }
                    else if(ship instanceof PlayerShip && bullet.direction == Direction.DOWN){
                        ship.hit();
                        removeBullet(bullet);

                        if(playerShip.getHp() >= 0 && !hpImages.isEmpty()) {
                            ImageView lastHeart = hpImages.remove(hpImages.size() - 1);
                            field.getChildren().remove(lastHeart);
                        }
    
                        if(playerShip.getHp() == 0){
                            endGame();
                        }  
                    }
                    else{
                        continue;
                    }
                    
                }
            }
        }
    }

    private void endGame(){
        isGameEnded = true;
        field.getChildren().clear();
        ships.clear();
        bullets.clear();

        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.setStyle("-fx-font-size: 32; -fx-text-fill: white; -fx-font-weight: bold;");
        gameOverLabel.setLayoutX(FIELD_WIDTH/2 - 100);
        gameOverLabel.setLayoutY(300);

        Button restartButton = new Button("Restart");
        restartButton.setLayoutX(FIELD_WIDTH/2 - 50);
        restartButton.setLayoutY(400);
        restartButton.setOnAction(event -> {
            isGameEnded = false;
            field.getChildren().clear();
            initialize();
        });


        
        field.getChildren().addAll(gameOverLabel, restartButton);
        
    }

    public static void removeBullet(Bullet bullet) {
        if(!bullets.contains(bullet) ) return;
        bullets.remove(bullet);
        AnchorPane parent  = (AnchorPane)  bullet.getParent();
        parent.getChildren().remove(bullet);
    }

    public static void addBullet(Bullet bullet) {
        bullets.add(bullet);
        
        
    }

    public static void removeShip(Ship ship) {
        if(!ships.contains(ship) ) return;
        ships.remove(ship);
        ((AnchorPane) ship.getParent()).getChildren().remove(ship);
    }
}
