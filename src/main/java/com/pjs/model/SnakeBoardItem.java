package com.pjs.model;

import com.pjs.enums.BoardItemType;

public class SnakeBoardItem extends BoardItem {

    public SnakeBoardItem(int start, int end) {
        super(start, end, BoardItemType.SNAKE);
    }
}
