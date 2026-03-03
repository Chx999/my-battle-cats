package com.chx.game;

public class Unit {
    // Position and movement
    public float x, y;
    public float speed;

    public boolean isEnemy;

    // Aboout atack
    public float scope;
    public int hp;
    public int atk;
    public int attakCoolDown;
    public int attckTimer;

    public Unit(float x, float y, float speed, boolean isEnemy) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.isEnemy = isEnemy;

        this.hp = 10;
        this.atk = 2;
        this.attakCoolDown = 1;
        this.attckTimer = 0;


    }

    public void update(float delta,boolean blocked) {
        if (!blocked){
            if (isEnemy) x += speed * delta;
            else x -= speed * delta;
        }
    }

    public void attack(float delta,Unit target){
        this.attckTimer += delta;
        if(attckTimer >= attakCoolDown){
            target.hp -= atk;
            attckTimer = 0;
        }
    }
}
