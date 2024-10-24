package com.pjs.model;

import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private final int size;
    private final BoardItem[][] boardItems;

    public Board(int size) {
        this.size = size;
        this.boardItems = new BoardItem[size][size];
    }

    public int getSize() {
        return size;
    }

    public BoardItem[][] getBoardItems() {
        return boardItems;
    }

    public void addSnake(int n) {
        int count = 0;

        while (count < n) {
            int start = ThreadLocalRandom.current().nextInt(0, boardItems.length * boardItems.length - 1);
            int end = ThreadLocalRandom.current().nextInt(0, boardItems.length * boardItems.length - 1);
            if (start <= end) {
                continue;
            }

            SnakeBoardItem snakeBoardItem = new SnakeBoardItem(start, end);
            int boardRow = start / boardItems.length;
            int boardColumn = start % boardItems.length;
            boardItems[boardRow][boardColumn] = snakeBoardItem;

            count++;
        }
    }

    public void addLadder(int n) {
        int count = 0;

        while (count < n) {
            int start = ThreadLocalRandom.current().nextInt(0, boardItems.length * boardItems.length - 1);
            int end = ThreadLocalRandom.current().nextInt(0, boardItems.length * boardItems.length - 1);
            if (start >= end) {
                continue;
            }

            LadderBoardItem ladderBoardItem = new LadderBoardItem(start, end);
            int boardRow = start / boardItems.length;
            int boardColumn = start % boardItems.length;
            boardItems[boardRow][boardColumn] = ladderBoardItem;

            count++;
        }
    }

    public void printBoard(Deque<Player> players) {
        System.out.println("Displaying board !!");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cellNumber = i * size + j;
                if (boardItems[i][j] != null) {
                    System.out.print(cellNumber + " " + boardItems[i][j].getBoardItemType().name() + "-" + boardItems[i][j].getEnd() + "\t");
                } else {
                    System.out.print(cellNumber + "\t\t\t");
                }
                for (Player player : players) {
                    if (cellNumber == player.getCurrentPosition()) {
                        System.out.print(player.getName() + "\t");
                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public BoardItem getBoardItem(int playerPosition) {
        int boardRow = playerPosition / boardItems.length;
        int boardColumn = (playerPosition % boardItems.length);
        return boardItems[boardRow][boardColumn];
    }
}
