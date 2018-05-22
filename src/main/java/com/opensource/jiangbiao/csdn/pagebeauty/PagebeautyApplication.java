package com.opensource.jiangbiao.csdn.pagebeauty;

import com.opensource.jiangbiao.csdn.pagebeauty.model.Blog;
import com.opensource.jiangbiao.csdn.pagebeauty.service.RefreshBlog;
import com.opensource.jiangbiao.csdn.pagebeauty.service.SpyBlog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class PagebeautyApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(PagebeautyApplication.class, args);
		SpyBlog spyBlog=new SpyBlog();
		List<Blog> blogs = spyBlog.spyBlogFromUrl("https://blog.csdn.net/qq_24210767");
		RefreshBlog refreshBlog=new RefreshBlog();
		refreshBlog.RefreshBlog(blogs);

	}
}
