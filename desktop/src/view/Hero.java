package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import viewmodel.GameManager;

public class Hero extends Actor {
    private Texture texture;
    GameManager gameManager;
    public Hero(GameManager gameManager){
        super();
        this.gameManager = gameManager;
    }
}
