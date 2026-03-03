package com.chx.game;

public class Unit {
    public float x, y;
    public float speed;
    public boolean isEnemy;

    public Unit(float x, float y, float speed, boolean isEnemy) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.isEnemy = isEnemy;
    }

    public void update(float delta) {
        if (isEnemy) x += speed * delta;
        else x -= speed * delta;
    }
}
