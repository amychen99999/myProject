package com.paperscissorsstonegame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ComputerTest {
    private Computer computer;

    @Before
    public void SetUp() { computer = new Computer(); }

    @After
    public void TearDown() { computer = null; }

    @Test
    public void TsetPlayMessage() {
        computer.SetTest();
        computer.SetComPlay(1);
        computer.Play();
        assertEquals(R.string.player_win, computer.GetMessage(2));
        computer.SetComPlay(2);
        computer.Play();
        assertEquals(R.string.player_draw, computer.GetMessage(2));
        computer.SetComPlay(3);
        computer.Play();
        assertEquals(R.string.player_lose, computer.GetMessage(2));
    }
}