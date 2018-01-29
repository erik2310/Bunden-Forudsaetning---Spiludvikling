package com.erikogniels.labyrintspil;

import com.almasb.fxgl.settings.GameSettings;

public class InitSettings extends LabyrintSpilApp {

    // Default no-arg constructor
    InitSettings() {
    }

    // Her kan man ændre indstillinger for spillet
    protected void getInitSettings(GameSettings settings) {
        settings.setWidth(700);
        settings.setHeight(700);
        settings.setTitle("Labyrint Spil");
        settings.setVersion("1.0");
    }

}
