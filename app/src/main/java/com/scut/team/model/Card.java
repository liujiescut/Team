package com.scut.team.model;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * 卡片类
 *
 * Created by jay on 16/1/2.
 */
public class Card extends BmobObject{
    /** 卡片的内容 */
    private String content;

    /** 卡片创建者的ObjectId */
    private String creator;

    /** 卡片创建者的名字 */
    private String creatorName;

    /** 该卡片的成员 */
    private List<String> members;

    /** 对该卡片的评论 */
    private List<String> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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

    public List<String> getComments() {
        if(null == comments){
            /** 避免一堆的判空操作 */
            comments = new ArrayList<>();
        }

        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
