package com.scut.team.model;

import cn.bmob.v3.BmobObject;

/**
 * 评论
 *
 * Created by jay on 16/1/2.
 */
public class Comment extends BmobObject{
    /** 创建评论的用户的ObjectId */
    private String creator;

    /** 创建评论的用户的用户名 */
    private String creatorName;

    /** 评论内容 */
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
