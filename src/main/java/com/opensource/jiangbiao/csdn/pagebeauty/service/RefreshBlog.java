package com.opensource.jiangbiao.csdn.pagebeauty.service;

import com.opensource.jiangbiao.csdn.pagebeauty.model.Blog;

import java.util.List;

public class RefreshBlog {

    public void RefreshBlog(List<Blog> blogs){
        for(Blog blog:blogs){
            RefreshThread thread=new RefreshThread(blog.getUrl());
            thread.start();
        }
    }

}
