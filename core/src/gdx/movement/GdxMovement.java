package gdx.movement;
//package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;

public class GdxMovement extends ApplicationAdapter {

    private static final int COLS = 8;
    private static final int ROWS = 8;
    boolean ishit = false;
    SpriteBatch batch;
    Texture Sprite;
    Texture BackGround;
    TextureRegion[] frames;
    TextureRegion CurrentFrame;
    float SpriteX = 0;
    float SpriteY = 0;
    float SpriteSpeed = 400;
    float Time = 0f;
    Animation animation;

    @Override
    public void create() {
        batch = new SpriteBatch();
        BackGround = new Texture(Gdx.files.internal("Moo.jpg"));
        Sprite = new Texture(Gdx.files.internal("T_Vlad_Sword_Walking_48x48.png"));
        TextureRegion[][] tmp = TextureRegion.split(Sprite, Sprite.getWidth() / COLS, Sprite.getHeight() / ROWS);
        frames = new TextureRegion[COLS * ROWS];
        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        animation = new Animation(1f, frames);

    }

    @Override
    public void render() {
        int nH = Gdx.graphics.getHeight(), nW = Gdx.graphics.getWidth();
        if (Time < 8) {
            Time += Gdx.graphics.getDeltaTime();
        } else {
            Time = 0;
        }
        if (ishit == true) {
            SpriteSpeed = 0f;
        }
        // Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        CurrentFrame = animation.getKeyFrame(0);

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            SpriteX -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(56 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            SpriteX += Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(0 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            SpriteY += Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(8 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            SpriteY -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(32 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            SpriteX -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(24 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            SpriteX -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(48 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            SpriteY += Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(16 + Time);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            SpriteY -= Gdx.graphics.getDeltaTime() * SpriteSpeed;
            CurrentFrame = animation.getKeyFrame(40 + Time);
        }

        batch.begin();
        Gdx.gl.glClearColor(.135f, .206f, .235f, 1); //blue background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(BackGround, 100, 100);
        batch.draw(CurrentFrame, (int) SpriteX, (int) SpriteY);
        batch.end();
        System.out.println(SpriteX);
        System.out.println(SpriteY);

    }

    public boolean Contain(int nXMin, int nXMax, int nYMin, int nYMax) {
        if (SpriteY > 80) {
            return true;
        } else if (SpriteY < 0) {
            return true;
        } else if (SpriteX > 120) {
            return true;
        } else if (SpriteX < 0) {
            return true;
        }
        return false;
    }
}
//Left wall: X= -5 Y = 0 to 425
//Right wall: X = 600 Y = 0 to 425
//Bottom: X = 5 to 600 Y = -5
//Top
