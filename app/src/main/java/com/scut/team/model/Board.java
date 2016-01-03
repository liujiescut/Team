package com.scut.team.model;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Board类
 *
 * Created by jay on 16/1/2.
 */
public class Board extends BmobObject{
    /** Board的名称 */
    private String name;

    /** Board的创建者 */
    private User owner;

    /** Board的成员的ObjectId */
    private List<String> members;

    /** Board所拥有的CardList的ObjectId */
    private List<String> cardLists;

    public List<String> getCardLists() {
        if(null == cardLists){
            /** 避免一堆的判空操作 */
            cardLists = new ArrayList<>();
        }

        return cardLists;
    }

    public void setCardLists(List<String> cardLists) {
        this.cardLists = cardLists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<String> getMembers() {
        if(null == members){
            /** 避免一堆的判空操作 */
            members = new ArrayList<>();
        }

        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
