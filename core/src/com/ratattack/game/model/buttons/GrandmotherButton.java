package com.ratattack.game.model.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.ratattack.game.GameSettings;
import com.ratattack.game.gamecontroller.GameController;
import com.ratattack.game.model.shootingStrategy.NormalBulletStrategy;
import com.ratattack.game.model.shootingStrategy.ShootingStrategy;

public class GrandmotherButton {

    Button button;
    ShootingStrategy strategy;
    Stage stage = GameController.getInstance().getStage();
    Texture grandMotherTexture = new Texture("grandma_normal_bullet.png");

    int id;
    int currentUpgrade = 0;

    public GrandmotherButton(int laneWidth, int i) {
        id = i;

        button = new Button(new TextureRegionDrawable(new TextureRegion(grandMotherTexture)));

        // The size and position must be like this
        button.setSize(grandMotherTexture.getWidth(), grandMotherTexture.getHeight());
        button.setPosition(laneWidth*i + (float)((laneWidth/2) - (grandMotherTexture.getWidth()/2)), GameSettings.grandmotherLine);

        strategy = new NormalBulletStrategy();

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent inputEvent, float xpos, float ypos) {
                strategy.shoot((int) button.getX() + grandMotherTexture.getWidth()/3, GameSettings.finishLine);
            }
        });

        stage.addActor(button);
    }

    public Button getButton() {
        return button;
    }

    public void upgrade() {
        // Checking if the balance is high enough in order to pay for upgrades
        // The price is inculded in the upgrade
        if (currentUpgrade != ShootingStrategy.shootingStrategies.length - 1) {
            currentUpgrade += 1;
            button.getStyle().down = new TextureRegionDrawable(new TextureRegion(new Texture(ShootingStrategy.grandmaTextures[currentUpgrade])));
            button.getStyle().up = new TextureRegionDrawable(new TextureRegion(new Texture(ShootingStrategy.grandmaTextures[currentUpgrade])));
            strategy = ShootingStrategy.shootingStrategies[currentUpgrade];
        }
    }
}
