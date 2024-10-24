package com.pjs;

public class Main {

    public static void main(String[] args) {
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame();
        snakeLadderGame.initGame(9);
        snakeLadderGame.addSnake(5);
        snakeLadderGame.addLadder(4);
        snakeLadderGame.printBoard();
        snakeLadderGame.startGame();
    }
}