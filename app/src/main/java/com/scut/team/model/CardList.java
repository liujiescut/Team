package com.scut.team.model;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * 卡片列表
 *
 * Created by jay on 16/1/2.
 */
public class CardList extends BmobObject{
    /** List名 */
    private String name;

    /** List所在Board的ObjectId */
    private String board;

    /** List所在Board的名字 */
    private String boardName;

    /** 拥有的卡片的ObjectId */
    private List<String> cards;

    public List<String> getCards() {
        if(null == cards){
            /** 避免一堆的判空操作 */
            cards = new ArrayList<>();
        }

        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
