// Vores spils package navn
package com.erikogniels.labyrintspil;

//Imports som skal bruges til FXGL
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
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
        settings.setWidth(700);
        settings.setHeight(700);
        settings.setTitle("Labyrint Spil");
        settings.setVersion("1.0");
    }

    private Entity player;

    // Her kan man sætte ting som skal være klare inden spillet starter
    @Override
    protected void initGame() {
        player = Entities.builder()
                .at(350, 350)
                .viewFromNode(new Circle(10, Color.BLUE))
                .buildAndAttach(getGameWorld());
    }

    // Her kan man indsætte kode til at håndtere input
    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.translateX(2); // går 2 pixels til højre
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.translateX(-2); // går 2 pixels til venstre
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.translateY(-2); // går 2 pixels op
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.translateY(2); // går 2 pixels ned
            }
        }, KeyCode.DOWN);
    }

    // Her kan man tilføje tekst
    @Override
    protected void initUI() {
        Text level1Text = new Text("Level 1"); // laver en tekst
        level1Text.setTranslateX(15); // dens x position
        level1Text.setTranslateY(35); // dens y position
        level1Text.setFont(new Font("Arial Rounded MT Bold", 28)); // sætter fontet til at være Arial Rounded MT Bold med størrelse 28

        getGameScene().addUINode(level1Text); // add to the scene
    }

    public static void main(String[] args) {
        // Starter spillet
        launch(args);
    }
}