package com.space_invaders;

public enum Direction {
    UP,   
    DOWN,  
    CUSTOM; 

    private Integer angle;

    private Direction(int angle) {
        this.angle = angle;
    }

    private Direction() {
        this.angle = null; 
    }

    public void setAngle(int angle) {
        if (this == CUSTOM) {
            this.angle = angle;
        } else {
            throw new UnsupportedOperationException("Can't set angle for " + this);
        }
    }

    // Getter method for angle
    public Integer getAngle() {
        return angle;
    }

    public void printDetails() {
        if (this.angle != null) {
            System.out.println("Direction " + this.name() + " at " + this.angle + " degrees.");
        } else {
            System.out.println("Direction " + this.name() + " with no specific angle.");
        }
    }
}
