# pagebeauty
This is a project to help csdn user increament their blogs page view .
# 利用HtmlUnit实现的可以动态刷CSDN博客的访问量。

## 修改参数
PageBeautyApplication.class中
List<Blog> blogs = spyBlog.spyBlogFromUrl("https://blog.csdn.net/qq_24210767");
将你的博客的url修改到这里，然后运行就可以自动的去获取你的全部博客并刷新。
每隔一分钟刷新一次。一个小时可以增加60个访问量。
一直启动就可以保证访问量的持续上升。
