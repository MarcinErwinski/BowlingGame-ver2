/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bowlinggame;

import java.util.Random;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Erwin
 */
public class GameTest {

    BowlingGame game;

    @Before
    public void initialize() {
        game = new BowlingGame();
    }

    @Test
    public void canRollGutterGame() {
        rollMany(0, 20);
        Assert.assertEquals(0, game.getScore());
    }

    @Test
    public void canRollAllOnes() {
        rollMany(1, 20);
        assertEquals(0, game.getScore());
    }

    @Test
    public void canRollSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);
        assertEquals(16, game.getScore());
    }

    @Test
    public void canRollStrike() {
        game.roll(10);
        game.roll(4);
        game.roll(3);
        rollMany(0, 16);
        assertEquals(24, game.getScore());
    }

    @Test
    public void canRollPerfectGame() {
        rollMany(10, 12);
        assertEquals(200, game.getScore());
    }

    private void rollMany(int pins, int rolls) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }


    public static  void main(String[] args) {
       BowlingGame game = new BowlingGame();
        
        for (int i = 0; i < 20; i++) {
         
            game.roll(10);
        }
        System.out.print("Score: " + game.getScore());
    }
}

