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

    // Deklaration af entity's
    private Entity player;
    private Entity overstePanelVaeg;
    private Entity startWall;
    private Entity slutWall[] = new Entity[2];
    private Entity wall[][] = new Entity[30][30];
    private Entity coin[] = new Entity[100];
    private int pointCounter = 0;

    // Her kan man sætte ting som skal være klare inden spillet starter
    @Override
    protected void initGame() {

        player = Entities.builder()
                .type(EntityType.PLAYER)
                .at(12, 505)
                .viewFromNodeWithBBox(new Circle(10, Color.BLUE))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        overstePanelVaeg = Entities.builder()
                .type(EntityType.WALL)
                .at(0, 50)
                .viewFromNodeWithBBox(new Rectangle(700, 5, Color.BLACK))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        startWall = Entities.builder()
                .type(EntityType.WALL)
                .at(5, 488)
                .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        // den øverste væg ved slutningen af labyrinten
        slutWall[0] = Entities.builder()
                .type(EntityType.WALL)
                .at(690, 118)
                .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        // den nedeste væg ved slutningen af labyrinten
        slutWall[1] = Entities.builder()
                .type(EntityType.SLUTWALLLVL1)
                .at(690, 580)
                .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        // laver coins til level 1
        coin[0] = Entities.builder()
                .type(EntityType.COIN)
                .at(190, 190)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[1] = Entities.builder()
                .type(EntityType.COIN)
                .at(160, 190)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[2] = Entities.builder()
                .type(EntityType.COIN)
                .at(130, 190)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[3] = Entities.builder()
                .type(EntityType.COIN)
                .at(381, 190)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[4] = Entities.builder()
                .type(EntityType.COIN)
                .at(133, 250)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[5] = Entities.builder()
                .type(EntityType.COIN)
                .at(163, 250)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[6] = Entities.builder()
                .type(EntityType.COIN)
                .at(193, 250)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[7] = Entities.builder()
                .type(EntityType.COIN)
                .at(193, 220)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[8] = Entities.builder()
                .type(EntityType.COIN)
                .at(351, 220)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[9] = Entities.builder()
                .type(EntityType.COIN)
                .at(536, 220)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[10] = Entities.builder()
                .type(EntityType.COIN)
                .at(536, 250)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[11] = Entities.builder()
                .type(EntityType.COIN)
                .at(536, 280)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[12] = Entities.builder()
                .type(EntityType.COIN)
                .at(381, 220)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[13] = Entities.builder()
                .type(EntityType.COIN)
                .at(381, 160)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[14] = Entities.builder()
                .type(EntityType.COIN)
                .at(381, 130)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[15] = Entities.builder()
                .type(EntityType.COIN)
                .at(40, 282)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[16] = Entities.builder()
                .type(EntityType.COIN)
                .at(70, 282)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[17] = Entities.builder()
                .type(EntityType.COIN)
                .at(100, 282)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[18] = Entities.builder()
                .type(EntityType.COIN)
                .at(130, 282)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[19] = Entities.builder()
                .type(EntityType.COIN)
                .at(410, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[20] = Entities.builder()
                .type(EntityType.COIN)
                .at(380, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[21] = Entities.builder()
                .type(EntityType.COIN)
                .at(350, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[22] = Entities.builder()
                .type(EntityType.COIN)
                .at(320, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[23] = Entities.builder()
                .type(EntityType.COIN)
                .at(320, 470)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[24] = Entities.builder()
                .type(EntityType.COIN)
                .at(320, 440)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[25] = Entities.builder()
                .type(EntityType.COIN)
                .at(350, 436)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[26] = Entities.builder()
                .type(EntityType.COIN)
                .at(350, 406)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[27] = Entities.builder()
                .type(EntityType.COIN)
                .at(350, 375)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[28] = Entities.builder()
                .type(EntityType.COIN)
                .at(320, 375)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[29] = Entities.builder()
                .type(EntityType.COIN)
                .at(505, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[30] = Entities.builder()
                .type(EntityType.COIN)
                .at(535, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[31] = Entities.builder()
                .type(EntityType.COIN)
                .at(565, 500)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[32] = Entities.builder()
                .type(EntityType.COIN)
                .at(505, 530)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[33] = Entities.builder()
                .type(EntityType.COIN)
                .at(505, 560)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        coin[34] = Entities.builder()
                .type(EntityType.COIN)
                .at(505, 590)
                .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                .with(new CollidableComponent(true))
                .buildAndAttach(getGameWorld());

        // fylder et område ud med rektangler
        for (int y = 65, arrayY = 0; y < 680; y = y + 31, arrayY++) {
            for (int x = 9, arrayX = 0; x < 680; x = x + 31, arrayX++) {
                wall[arrayX][arrayY] = Entities.builder()
                        .type(EntityType.WALL)
                        .at(x, y)
                        .viewFromNodeWithBBox(new Rectangle(30, 30, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());
            }
        }

        // fjerner de rektangler som vi ikke skal bruge så der bliver tegnet en vej i labyrinten
        removeLevel1Walls();

        // Afspiller en lyd når man bevæger sig
        getGameState().<Integer>addListener("pixelsMoved", (prev, now) -> {
            if (now % 70 == 0) { //Bib lyd for hver 70 pixelsMoved
                getAudioPlayer().playSound("drop.wav");
            }
        });

    }

    // fjerner coins fra en level
    private void removeCoins() {
        try {
            for (int i = 0; i < 100; i++) {
                coin[i].removeFromWorld();
            }
        } catch (Exception e) {

        }
    }

    private void removeLevel1Walls() {

        // fjerner nogen rektangeler på en x og y koordinat for at tegne vejen hvor man kan gå
        wall[0][14].removeFromWorld();
        wall[1][14].removeFromWorld();
        wall[2][14].removeFromWorld();
        wall[3][14].removeFromWorld();
        wall[4][14].removeFromWorld();
        wall[5][14].removeFromWorld();
        wall[1][13].removeFromWorld();
        wall[1][12].removeFromWorld();
        wall[1][11].removeFromWorld();
        wall[2][11].removeFromWorld();
        wall[3][11].removeFromWorld();
        wall[3][10].removeFromWorld();
        wall[3][9].removeFromWorld();
        wall[2][9].removeFromWorld();
        wall[1][9].removeFromWorld();
        wall[1][8].removeFromWorld();
        wall[1][7].removeFromWorld();
        wall[2][7].removeFromWorld();
        wall[3][7].removeFromWorld();
        wall[4][7].removeFromWorld();
        wall[4][6].removeFromWorld();
        wall[5][6].removeFromWorld();
        wall[6][6].removeFromWorld();
        wall[6][7].removeFromWorld();
        wall[6][8].removeFromWorld();
        wall[6][9].removeFromWorld();
        wall[5][9].removeFromWorld();
        wall[5][10].removeFromWorld();
        wall[5][11].removeFromWorld();
        wall[5][12].removeFromWorld();
        wall[5][13].removeFromWorld();
        wall[6][5].removeFromWorld();
        wall[6][4].removeFromWorld();
        wall[5][4].removeFromWorld();
        wall[4][4].removeFromWorld();
        wall[3][4].removeFromWorld();
        wall[2][4].removeFromWorld();
        wall[1][4].removeFromWorld();
        wall[1][3].removeFromWorld();
        wall[1][2].removeFromWorld();
        wall[1][1].removeFromWorld();
        wall[2][1].removeFromWorld();
        wall[3][1].removeFromWorld();
        wall[4][1].removeFromWorld();
        wall[5][1].removeFromWorld();
        wall[6][1].removeFromWorld();
        wall[7][1].removeFromWorld();
        wall[7][2].removeFromWorld();
        wall[7][3].removeFromWorld();
        wall[8][3].removeFromWorld();
        // bruger for loops til at tegne de lige veje
        for (int i = 4; i < 17; i++) {
            wall[8][i].removeFromWorld();
        }
        for (int i = 7; i > 0; i--) {
            wall[i][16].removeFromWorld();
        }
        wall[1][17].removeFromWorld();
        wall[1][18].removeFromWorld();
        wall[9][9].removeFromWorld();
        for (int i = 2; i < 11; i++) {
            wall[i][18].removeFromWorld();
        }
        wall[10][17].removeFromWorld();
        wall[10][16].removeFromWorld();
        wall[11][16].removeFromWorld();
        wall[12][16].removeFromWorld();
        wall[12][17].removeFromWorld();
        wall[12][18].removeFromWorld();
        wall[13][18].removeFromWorld();
        wall[14][18].removeFromWorld();
        for (int i = 17; i > 9; i--) {
            wall[14][i].removeFromWorld();
        }
        wall[13][14].removeFromWorld();
        wall[12][14].removeFromWorld();
        wall[11][14].removeFromWorld();
        wall[10][14].removeFromWorld();
        wall[10][13].removeFromWorld();
        wall[10][12].removeFromWorld();
        wall[11][12].removeFromWorld();
        wall[11][11].removeFromWorld();
        wall[11][10].removeFromWorld();
        wall[10][10].removeFromWorld();
        wall[13][10].removeFromWorld();
        wall[13][9].removeFromWorld();
        wall[12][9].removeFromWorld();
        wall[12][8].removeFromWorld();
        wall[11][8].removeFromWorld();
        wall[10][8].removeFromWorld();
        for (int i = 7; i > 0; i--) {
            wall[10][i].removeFromWorld();
        }
        wall[11][1].removeFromWorld();
        wall[12][1].removeFromWorld();
        wall[13][1].removeFromWorld();
        wall[14][1].removeFromWorld();
        wall[12][2].removeFromWorld();
        wall[12][3].removeFromWorld();
        wall[12][4].removeFromWorld();
        wall[12][5].removeFromWorld();
        wall[11][5].removeFromWorld();
        for (int i = 2; i < 8; i++) {
            wall[14][i].removeFromWorld();
        }
        wall[15][7].removeFromWorld();
        wall[16][7].removeFromWorld();
        wall[17][7].removeFromWorld();
        wall[17][6].removeFromWorld();
        wall[17][5].removeFromWorld();
        wall[16][4].removeFromWorld();
        wall[16][3].removeFromWorld();
        wall[16][2].removeFromWorld();
        for (int i = 17; i < 22; i++) {
            wall[i][2].removeFromWorld();
        }
        wall[16][8].removeFromWorld();
        wall[16][9].removeFromWorld();
        wall[16][10].removeFromWorld();
        wall[17][10].removeFromWorld();
        wall[17][11].removeFromWorld();
        wall[17][12].removeFromWorld();
        wall[18][12].removeFromWorld();
        wall[18][13].removeFromWorld();
        wall[18][14].removeFromWorld();
        wall[17][14].removeFromWorld();
        wall[16][14].removeFromWorld();
        wall[16][15].removeFromWorld();
        wall[16][16].removeFromWorld();
        wall[16][17].removeFromWorld();
        for (int i = 17; i < 22; i++) {
            wall[i][17].removeFromWorld();
        }

    }

    private void removeLevel2Walls() {

        // fjerner nogen rektangeler på en x og y koordinat for at tegne vejen hvor man kan gå
        wall[0][9].removeFromWorld();
        wall[1][9].removeFromWorld();
        wall[1][10].removeFromWorld();
        wall[2][10].removeFromWorld();
        wall[3][10].removeFromWorld();
        wall[3][9].removeFromWorld();
        wall[3][8].removeFromWorld();
        wall[3][7].removeFromWorld();
        wall[2][7].removeFromWorld();
        wall[1][7].removeFromWorld();
        wall[1][6].removeFromWorld();
        wall[1][5].removeFromWorld();
        wall[2][5].removeFromWorld();
        wall[3][5].removeFromWorld();
        wall[4][5].removeFromWorld();
        wall[5][5].removeFromWorld();
        for (int i = 6; i < 15; i++) {
            wall[5][i].removeFromWorld();
        }
        wall[4][12].removeFromWorld();
        wall[3][12].removeFromWorld();
        wall[2][12].removeFromWorld();
        wall[1][12].removeFromWorld();
        wall[1][13].removeFromWorld();
        wall[1][14].removeFromWorld();
        wall[1][15].removeFromWorld();
        wall[2][15].removeFromWorld();
        wall[3][15].removeFromWorld();
        wall[4][15].removeFromWorld();
        wall[4][16].removeFromWorld();
        wall[5][16].removeFromWorld();
        wall[6][16].removeFromWorld();
        wall[6][15].removeFromWorld();
        wall[6][14].removeFromWorld();
        wall[5][17].removeFromWorld();
        for (int i = 1; i < 9; i++) {
            wall[i][18].removeFromWorld();
        }
        wall[8][17].removeFromWorld();
        wall[8][16].removeFromWorld();
        wall[8][15].removeFromWorld();
        wall[8][14].removeFromWorld();
        wall[8][13].removeFromWorld();
        wall[8][12].removeFromWorld();
        wall[7][12].removeFromWorld();
        wall[7][11].removeFromWorld();
        wall[7][10].removeFromWorld();
        wall[7][9].removeFromWorld();
        wall[7][8].removeFromWorld();
        wall[7][7].removeFromWorld();
        wall[8][7].removeFromWorld();
        wall[8][6].removeFromWorld();
        wall[8][5].removeFromWorld();
        wall[8][4].removeFromWorld();
        wall[7][4].removeFromWorld();
        wall[6][4].removeFromWorld();
        wall[6][3].removeFromWorld();
        wall[5][3].removeFromWorld();
        wall[4][3].removeFromWorld();
        wall[3][3].removeFromWorld();
        wall[2][3].removeFromWorld();
        wall[1][3].removeFromWorld();
        wall[1][2].removeFromWorld();
        wall[1][1].removeFromWorld();
        wall[2][1].removeFromWorld();
        wall[3][1].removeFromWorld();
        wall[4][1].removeFromWorld();
        wall[5][1].removeFromWorld();
        wall[6][1].removeFromWorld();
        wall[7][1].removeFromWorld();
        wall[7][2].removeFromWorld();
        wall[8][2].removeFromWorld();
        wall[9][2].removeFromWorld();
        wall[10][2].removeFromWorld();
        wall[10][1].removeFromWorld();
        for (int i = 11; i < 19; i++) {
            wall[i][1].removeFromWorld();
        }
        wall[10][3].removeFromWorld();
        wall[10][4].removeFromWorld();
        wall[10][5].removeFromWorld();
        wall[11][5].removeFromWorld();
        wall[12][5].removeFromWorld();
        wall[13][5].removeFromWorld();
        wall[14][4].removeFromWorld();
        wall[14][3].removeFromWorld();
        wall[14][2].removeFromWorld();
        wall[15][4].removeFromWorld();
        wall[15][5].removeFromWorld();
        wall[16][5].removeFromWorld();
        wall[17][5].removeFromWorld();
        wall[18][5].removeFromWorld();
        wall[18][4].removeFromWorld();
        wall[18][3].removeFromWorld();
        wall[18][2].removeFromWorld();
        wall[13][6].removeFromWorld();
        wall[13][7].removeFromWorld();
        wall[12][7].removeFromWorld();
        wall[11][7].removeFromWorld();
        wall[10][7].removeFromWorld();
        wall[10][8].removeFromWorld();
        wall[9][8].removeFromWorld();
        wall[9][9].removeFromWorld();
        wall[9][10].removeFromWorld();
        wall[9][11].removeFromWorld();
        wall[10][11].removeFromWorld();
        wall[10][12].removeFromWorld();
        wall[10][13].removeFromWorld();
        wall[10][14].removeFromWorld();
        wall[11][14].removeFromWorld();
        wall[11][15].removeFromWorld();
        wall[11][16].removeFromWorld();
        wall[10][16].removeFromWorld();
        wall[10][17].removeFromWorld();
        wall[10][18].removeFromWorld();
        for (int i = 11; i < 19; i++) {
            wall[i][18].removeFromWorld();
        }
        wall[13][17].removeFromWorld();
        wall[13][16].removeFromWorld();
        wall[13][15].removeFromWorld();
        wall[13][14].removeFromWorld();
        wall[13][13].removeFromWorld();
        wall[12][13].removeFromWorld();
        wall[12][12].removeFromWorld();
        wall[12][11].removeFromWorld();
        wall[12][10].removeFromWorld();
        wall[12][9].removeFromWorld();
        wall[13][9].removeFromWorld();
        wall[14][9].removeFromWorld();
        wall[14][8].removeFromWorld();
        wall[15][8].removeFromWorld();
        wall[15][7].removeFromWorld();
        wall[15][6].removeFromWorld();
        wall[18][17].removeFromWorld();
        wall[18][16].removeFromWorld();
        wall[17][16].removeFromWorld();
        wall[16][16].removeFromWorld();
        wall[15][16].removeFromWorld();
        wall[15][15].removeFromWorld();
        wall[15][14].removeFromWorld();
        wall[16][14].removeFromWorld();
        wall[17][14].removeFromWorld();
        wall[18][14].removeFromWorld();
        wall[18][13].removeFromWorld();
        wall[18][12].removeFromWorld();
        wall[17][12].removeFromWorld();
        wall[16][12].removeFromWorld();
        wall[15][12].removeFromWorld();
        wall[15][11].removeFromWorld();
        wall[15][10].removeFromWorld();
        wall[16][10].removeFromWorld();
        wall[17][10].removeFromWorld();
        wall[17][9].removeFromWorld();
        wall[17][8].removeFromWorld();
        wall[17][7].removeFromWorld();
        wall[18][7].removeFromWorld();
        wall[19][7].removeFromWorld();
        wall[20][7].removeFromWorld();
        wall[21][7].removeFromWorld();

    }

    private void removeLevel3Walls() {

        // fjerner nogen rektangeler på en x og y koordinat for at tegne vejen hvor man kan gå
        for (int i = 0; i < 19; i++) {
            wall[i][10].removeFromWorld();
        }
        for (int i = 9; i > 0; i--) {
            wall[1][i].removeFromWorld();
        }
        for (int i = 2; i < 19; i++) {
            wall[i][1].removeFromWorld();
        }
        wall[18][2].removeFromWorld();
        wall[18][3].removeFromWorld();
        for (int i = 18; i > 1; i--) {
            wall[i][3].removeFromWorld();
        }
        for (int i = 9; i > 4; i--) {
            wall[3][i].removeFromWorld();
        }
        wall[18][9].removeFromWorld();
        wall[18][8].removeFromWorld();
        wall[18][7].removeFromWorld();
        wall[18][6].removeFromWorld();
        wall[18][5].removeFromWorld();
        wall[19][5].removeFromWorld();
        wall[20][5].removeFromWorld();
        wall[21][5].removeFromWorld();
        for (int i = 16; i > 3; i--) {
            wall[i][5].removeFromWorld();
        }
        for (int i = 16; i > 3; i--) {
            wall[i][7].removeFromWorld();
        }
        wall[16][6].removeFromWorld();
        for (int i = 11; i < 19; i++) {
            wall[18][i].removeFromWorld();
        }
        for (int i = 17; i > 0; i--) {
            wall[i][18].removeFromWorld();
        }
        for (int i = 17; i > 0; i--) {
            wall[i][16].removeFromWorld();
        }
        wall[1][17].removeFromWorld();
        wall[16][11].removeFromWorld();
        wall[16][12].removeFromWorld();
        wall[16][13].removeFromWorld();
        wall[16][14].removeFromWorld();
        for (int i = 1; i < 16; i++) {
            wall[i][14].removeFromWorld();
        }
        for (int i = 1; i < 16; i++) {
            wall[i][12].removeFromWorld();
        }
        wall[1][13].removeFromWorld();

    }

    private void returnAllWallsToTheGame() {

        // fylder et område ud med rektangler
        for (int y = 65, arrayY = 0; y < 680; y = y + 31, arrayY++) {
            for (int x = 9, arrayX = 0; x < 680; x = x + 31, arrayX++) {
                wall[arrayX][arrayY] = Entities.builder()
                        .type(EntityType.WALL)
                        .at(x, y)
                        .viewFromNodeWithBBox(new Rectangle(30, 30, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());
            }
        }

    }

    // fjerner alle walls fra spillet
    private void removeAllWalls() {
        try {
            for (int arrayY = 0; arrayY < 20; arrayY++) {
                for (int arrayX = 0; arrayX < 22; arrayX++) {
                    wall[arrayX][arrayY].removeFromWorld();
                }
            }
        } catch (Exception e) {

        }
    }

    // Her kan man tilføje fysik til spillet
    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.COIN) {

            // order of types is the same as passed into the constructor
            @Override
            protected void onCollisionBegin(Entity player, Entity coin) {

                // fjerner coin når man samler den op
                coin.removeFromWorld();

                // spiller collectcoin.wav når man samler den op
                getAudioPlayer().playSound("collectcoin.wav");

                // tilføjer 100 point til pointCounter
                pointCounter = pointCounter + 100;

                // opdaterer pointText
                pointText.setText("Point: " + pointCounter);
            }
        });


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

        // Håndtere kolisioner mellem en Player type og SlutWallLVL1 type
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.SLUTWALLLVL1) {
            @Override
            protected void onCollision(Entity player1, Entity slutWall1) {

                // fjerner spilleren fra verdenen i level 1
                player.removeFromWorld();

                // fjerner startWall i level 1
                startWall.removeFromWorld();

                // fjerner slutWall[0] i level 1
                slutWall[0].removeFromWorld();

                // fjerner slutWall[1] i level 1
                slutWall[1].removeFromWorld();

                // fjerner coins som man ikke samler op fra level 1
                removeCoins();

                // fjerner alle walls
                removeAllWalls();

                // Tilføjer alle walls tilbage igen
                returnAllWallsToTheGame();

                // fjerner walls til level 2
                removeLevel2Walls();

                // skaber en ny startWall til level 2
                startWall = Entities.builder()
                        .type(EntityType.WALL)
                        .at(5, 333)
                        .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // skaber en ny spiller til level 2
                player = Entities.builder()
                        .type(EntityType.PLAYER)
                        .at(12, 350)
                        .viewFromNodeWithBBox(new Circle(10, Color.BLUE))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // skaber en ny slutWall[1] til level 2
                slutWall[1] = Entities.builder()
                        .type(EntityType.SLUTWALLLVL2)
                        .at(690, 272)
                        .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // laver coins til level 2
                coin[0] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(253, 190)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[1] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(226, 190)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[2] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(197, 190)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[3] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(195, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[4] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(165, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[5] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(135, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[6] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(102, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[7] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(73, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[8] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(43, 159)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[9] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(133, 437)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[10] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(101, 437)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[11] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(71, 437)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[12] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(40, 437)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[13] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(40, 468)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[14] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(40, 498)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[15] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(40, 529)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[16] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(70, 529)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[17] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(100, 529)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[18] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(130, 529)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[19] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(163, 499)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[20] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(193, 499)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[21] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(195, 529)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[22] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(195, 562)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[23] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(163, 562)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());


                // sætter level teksten til Level 2
                levelText.setText("Level 2");

            }
        });

        // Håndtere kolisioner mellem en Player type og SlutWallLVL2 type
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.PLAYER, EntityType.SLUTWALLLVL2) {
            @Override
            protected void onCollision(Entity player1, Entity slutWall1) {

                // fjerner spilleren fra verdenen i level 2
                player.removeFromWorld();

                // fjerner startWall i level 2
                startWall.removeFromWorld();

                // fjerner slutWall[1] i level 2
                slutWall[1].removeFromWorld();

                // fjerner coins som man ikke samler op fra level 2
                removeCoins();

                // fjerner alle walls
                removeAllWalls();

                // Tilføjer alle walls tilbage igen
                returnAllWallsToTheGame();

                // fjerner walls til level 3
                removeLevel3Walls();

                // skaber en ny startWall til level 3
                startWall = Entities.builder()
                        .type(EntityType.WALL)
                        .at(5, 363)
                        .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // skaber en ny spiller til level 3
                player = Entities.builder()
                        .type(EntityType.PLAYER)
                        .at(12, 380)
                        .viewFromNodeWithBBox(new Circle(10, Color.BLUE))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // skaber en ny slutWall[1] til level 3
                slutWall[1] = Entities.builder()
                        .type(EntityType.SLUTWALLLVL3)
                        .at(690, 211)
                        .viewFromNodeWithBBox(new Rectangle(5, 50, Color.BLACK))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // laver coins til level 3
                coin[0] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(250, 158)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[1] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(220, 158)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                coin[2] = Entities.builder()
                        .type(EntityType.COIN)
                        .at(190, 158)
                        .viewFromNodeWithBBox(new Circle(15, Color.YELLOW))
                        .with(new CollidableComponent(true))
                        .buildAndAttach(getGameWorld());

                // sætter level teksten til Level 3
                levelText.setText("Level 3");

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

   /*     input.addAction(new UserAction("Play Sound") {
            @Override
            protected void onActionBegin() {
                getAudioPlayer().playSound("drop.wav");
            }
        }, KeyCode.F); */
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);

    }

    private Text levelText = new Text("Level 1"); // laver en tekst til vores level numre
    private Text pointText = new Text("Point: " + pointCounter); // laver en tekst til vores level numre


    // Her kan man tilføje tekst elementer
    @Override
    protected void initUI() {

        levelText.setTranslateX(15); // dens x position
        levelText.setTranslateY(35); // dens y position
        levelText.setFont(new Font("Arial Rounded MT Bold", 28)); // sætter fontet til at være Arial Rounded MT Bold med størrelse 28

        pointText.setTranslateX(530); // dens x position
        pointText.setTranslateY(35); // dens y position
        pointText.setFont(new Font("Arial Rounded MT Bold", 28)); // sætter fontet til at være Arial Rounded MT Bold med størrelse 28

        Text skridtTaeller = new Text();
        skridtTaeller.setTranslateX(200); // dens x position
        skridtTaeller.setTranslateY(35); // dens y position

        skridtTaeller.textProperty().bind(getGameState().intProperty("pixelsMoved").asString());
/*
        Texture mazeTexture = getAssetLoader().loadTexture("Maze3D.gif");
        mazeTexture.setTranslateX(45);
        mazeTexture.setTranslateY(150);
*/

        // tilføjer vores tekst objekter til spillet
        getGameScene().addUINode(levelText);
        getGameScene().addUINode(pointText);
        getGameScene().addUINode(skridtTaeller);
        //getGameScene().addUINode(mazeTexture);
    }

    public static void main(String[] args) {
        // Starter spillet
        launch(args);
    }
}