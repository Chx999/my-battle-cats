package com.chx.game;

public class Unit {
    // Position and movement
    public float x, y;
    public float speed;

    public boolean isEnemy;

    // Aboout atack
    public float scope;
    public float hp;
    public float atk;
    public float attackCoolDown;
    public float attackTimer;

    public Unit(float x, float y, float speed, boolean isEnemy) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.isEnemy = isEnemy;

        this.hp = 10f;
        this.atk = 2f;
        this.attackCoolDown = 1.0f;
        this.attackTimer = 0f;


    }

    public void update(float delta,boolean blocked) {
        if (!blocked){
            if (isEnemy) x += speed * delta;
            else x -= speed * delta;
        }
    }

    public void attack(float delta,Unit target){
        this.attackTimer += delta;
        if(attackTimer >= attackCoolDown){
            target.hp -= atk;
            attackTimer = 0f;
        }
    }
}
