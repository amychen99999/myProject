package com.paperscissorsstonegame;

public class Computer {
    private int _iComPlay;
    private boolean _isTest;

    public int Play(){
        int iComPlay = (int)(Math.random()*3 + 1);
        if (_isTest) iComPlay = _iComPlay;
        _iComPlay = iComPlay;
        if (iComPlay == 1) {
            return R.string.play_scissors;
        }
        else if (iComPlay == 2) {
            return R.string.play_stone;
        }
        else {
            return R.string.play_paper;
        }
    }
    public int GetMessage(int player) {
        if (player == _iComPlay)
            return R.string.player_draw;
        else if (player - _iComPlay == 1 || player - _iComPlay == -2)
            return R.string.player_win;
        else
            return R.string.player_lose;
    }
    public void SetTest(){
        _isTest = true;
    }
    public void SetComPlay(int iComPlay){
        _iComPlay = iComPlay;
    }
}
