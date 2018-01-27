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

    public static void main(String[] args) {
        // Starter spillet
        launch(args);
    }
}