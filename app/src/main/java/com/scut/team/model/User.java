package com.scut.team.model;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * 用户类
 *
 * Created by jay on 16/1/2.
 */
public class User extends BmobUser{
    /** 用户拥有的Board (Board的ObjectId) */
    private List<String> boards;

    public List<String> getBoards() {
        if(null == boards){
            /** 避免一堆的判空操作 */
            boards = new ArrayList<>();
        }

        return boards;
    }

    public void setBoards(List<String> boards) {
        this.boards = boards;
    }
}
