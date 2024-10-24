package com.pjs;

import com.pjs.model.Board;
import com.pjs.model.BoardItem;
import com.pjs.model.Dice;
import com.pjs.model.Player;
import com.pjs.model.SnakeBoardItem;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeLadderGame {

    private Board board;
    private Dice dice;
    private final Deque<Player> players;

    public SnakeLadderGame() {
        this.players = new LinkedList<>();
    }

    public void initGame(int n) {
        this.board = new Board(n);
        this.dice = new Dice(1);
        Player player1 = new Player("P1", 0);
        Player player2 = new Player("P2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void addSnake(int n) {
        board.addSnake(n);
    }


    public void addLadder(int n) {
        board.addLadder(n);
    }

    public void startGame() {
        while (true) {

            Player playerTurn = findPlayerTurn();
            System.out.println("========================================================");
            System.out.println("Player turn: " + playerTurn.getName() + " with current position: " + playerTurn.getCurrentPosition());
            int cellPosition = dice.rollDice();
            int newPosition = playerTurn.getCurrentPosition() + cellPosition;
            if (newPosition > board.getSize() * board.getSize() - 1) {
                System.out.println("Dice number exceeding the board range");
                continue;
            }
            BoardItem boardItem = board.getBoardItem(newPosition);
            if (boardItem != null && boardItem.getStart() == newPosition) {
                System.out.println("Found: " + boardItem.getBoardItemType().name() + " at position " + newPosition +  " hence moving to position: " + boardItem.getEnd());
                newPosition = boardItem.getEnd();
            }
            playerTurn.setCurrentPosition(newPosition);
            System.out.println("Player turn: " + playerTurn.getName() + " with new position: " + playerTurn.getCurrentPosition());
            printBoard();
            System.out.println("========================================================");

            if (playerTurn.getCurrentPosition() == board.getSize() * board.getSize() - 1) {
                System.out.println("Winner: " + playerTurn.getName());
                break;
            }
        }
    }

    private Player findPlayerTurn() {
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

    public void printBoard() {
        board.printBoard(players);
    }

}
