package com.opensource.jiangbiao.csdn.pagebeauty.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RefreshThread extends Thread{

    private String url;
    private WebClient webClient;

    public RefreshThread(String url) {
        this.url = url;
        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        this.webClient = webClient;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            try {
                HtmlPage htmlPage = webClient.getPage(url);
                System.out.println(url+" refresh time "+i++);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
