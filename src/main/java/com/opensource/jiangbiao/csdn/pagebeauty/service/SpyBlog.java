package com.opensource.jiangbiao.csdn.pagebeauty.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.opensource.jiangbiao.csdn.pagebeauty.model.Blog;
import org.apache.xpath.SourceTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpyBlog {

    public List<Blog> spyBlogFromUrl(String url) throws IOException {
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setJavaScriptEnabled(false);


            HtmlPage htmlPage = webClient.getPage(url);
            HtmlElement body = htmlPage.getBody();
            HtmlElement articalListPage = body.getOneHtmlElementByAttribute("div","class","article-list");
            List<HtmlElement> articals = articalListPage.getElementsByAttribute("div","class","article-item-box csdn-tracking-statistics");
            List<Blog> blogs = extractBlogFromHtmlElement(articals);

        return blogs;
    }


    public List<Blog> extractBlogFromHtmlElement(List<HtmlElement> articals){
        List<Blog> blogs =new ArrayList<>();
        for(HtmlElement artical:articals){
            HtmlElement h4 = artical.getOneHtmlElementByAttribute("h4","class","text-truncate");
            HtmlElement a = h4.getOneHtmlElementByAttribute("a","target","_blank");
            Blog blog=new Blog();
            blog.setUrl(a.getAttribute("href"));
            blogs.add(blog);
        }
        return blogs;
    }
}
