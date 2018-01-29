// Vores spils package navn
package com.erikogniels.labyrintspil;

//Imports som skal bruges til FXGL

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Map;

public class LabyrintSpilApp extends GameApplication {

    // Her kan man ændre indstillinger for spillet
    @Override
    protected void initSettings(GameSettings settings) {
        // Laver et objekt af klassen InitSettings
        InitSettings initSettings = new InitSettings();

        // Får initSettings fra InitSettings klassens getInitSettings metode
        initSettings.getInitSettings(settings);
    }

    private Entity player;
    private Entity wall;

    // Her kan man sætte ting som skal være klare inden spillet starter
    @Override
    protected void initGame() {
        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(350, 350)
                .viewFromNodeWithBBox(new Circle(10, Color.BLUE))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        wall = Entities.builder()
                .type(EntityType.WALL)
                .at(300,200)
               .viewFromNodeWithBBox(new Rectangle(300,50, Color.BLACK))
                .with(new CollidableComponent(true))
               .buildAndAttach(getGameWorld());
    }

    // Her kan man tilføje fysik til spillet
    @Override
    protected void initPhysics() {
        // Håndtere kolisioner mellem en Player type og Wall type
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.WALL) {
            @Override
            protected void onCollision(Entity player, Entity wall) {
                if (getInput().isHeld(KeyCode.RIGHT)) {
                    player.translateX(-2);
                }
                if (getInput().isHeld(KeyCode.LEFT)) {
                    player.translateX(2);
                }
                if (getInput().isHeld(KeyCode.UP)) {
                    player.translateY(2);
                }
                if (getInput().isHeld(KeyCode.DOWN)) {
                    player.translateY(-2);
                }
            }
        });
    }

    // Her kan man indsætte kode til at håndtere input
    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.translateX(2); // går 2 pixels til højre
                getGameState().increment("pixelsMoved", +2);
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.translateX(-2); // går 2 pixels til venstre
                getGameState().increment("pixelsMoved", +2);
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.translateY(-2); // går 2 pixels op
                getGameState().increment("pixelsMoved", +2);
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.translateY(2); // går 2 pixels ned
                getGameState().increment("pixelsMoved", +2);
            }
        }, KeyCode.DOWN);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    // Her kan man tilføje tekst
    @Override
    protected void initUI() {
        Text level1Text = new Text("Level 1"); // laver en tekst
        level1Text.setTranslateX(15); // dens x position
        level1Text.setTranslateY(35); // dens y position
        level1Text.setFont(new Font("Arial Rounded MT Bold", 28)); // sætter fontet til at være Arial Rounded MT Bold med størrelse 28

        Text skridtTaeller = new Text();
        skridtTaeller.setTranslateX(200); // dens x position
        skridtTaeller.setTranslateY(35); // dens y position

        skridtTaeller.textProperty().bind(getGameState().intProperty("pixelsMoved").asString());

        // tilføjer vores tekst objekter til spillet
        getGameScene().addUINode(level1Text);
        getGameScene().addUINode(skridtTaeller);
    }

    public static void main(String[] args) {
        // Starter spillet
        launch(args);
    }
}