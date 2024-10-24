package com.pjs.model;

import com.pjs.enums.BoardItemType;

public class BoardItem {

    private final int start;
    private final int end;
    private final BoardItemType boardItemType;

    public BoardItem(int start, int end, BoardItemType boardItemType) {
        this.start = start;
        this.end = end;
        this.boardItemType = boardItemType;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public BoardItemType getBoardItemType() {
        return boardItemType;
    }
}
