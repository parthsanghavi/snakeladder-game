package com.pjs.model;

import com.pjs.enums.BoardItemType;

public class LadderBoardItem extends BoardItem {

    public LadderBoardItem(int start, int end) {
        super(start, end, BoardItemType.LADDER);
    }
}
