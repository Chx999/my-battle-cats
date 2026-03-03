package com.chx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleScreen extends ScreenAdapter {
    private ShapeRenderer sr;
    private List<Unit> units;
    private List<Unit> unitsToRemove;

    @Override
    public void show() {
        sr = new ShapeRenderer();
        units = new ArrayList<>();
        unitsToRemove = new ArrayList<>();
    }

    @Override
    public void render(float delta) {
        unitsToRemove.clear();
        // 友方单位生成
        if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            units.add(new Unit(720, 140, 80, false));
        }

        // 敌方单位生成
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            units.add(new Unit(80, 140, 80, true));
        }

        for (Unit u : units) {
            boolean blocked = false;
            Unit target = null;

            for (Unit v : units){
                // check if the units are blocked

                if (v == u) continue;
                // Check if the units are in the same equip
                if (v.isEnemy == u.isEnemy){
                    continue;
                }else{
                    if (u.isEnemy){
                        if (v.x > u.x){
                            if (v.x - u.x <= 20){
                                blocked = true;
                                target = v;
                                break;
                            }
                        }
                    }else{
                        if (u.x > v.x){
                            if (u.x - v.x <= 20){
                                blocked = true;
                                target = v;
                                break;
                            }
                        }
                    }
                }
            }

            u.update(delta,blocked);
            if (blocked && target != null && target.hp > 0){
                u.attack(delta,target);
            }

            //Check if the units is dead
            if (u.hp <= 0){
                unitsToRemove.add(u);
            }
        }

        units.removeAll(unitsToRemove);


        Gdx.gl.glClearColor(0.95f, 0.95f, 0.95f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sr.begin(ShapeRenderer.ShapeType.Filled);

        sr.setColor(Color.DARK_GRAY);
        sr.rect(0, 100, 800, 5);

        sr.setColor(Color.RED);
        sr.rect(20, 105, 40, 80);

        sr.setColor(Color.BLUE);
        sr.rect(740, 105, 40, 80);

        for (Unit u : units) {
            if (u.isEnemy) sr.setColor(Color.RED);
            else sr.setColor(Color.BLUE);
            sr.rect(u.x, u.y, 20, 20);
        }

        sr.end();
    }

    @Override
    public void dispose() {
        sr.dispose();
    }
}
