<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>某某化肥有限公司网页模板</title>
    ﻿<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="decorator" content="default"/>
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="images/favicon.png">
<link rel='icon' href='favicon.ico' type='image/x-ico' />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/default.min.css?t=227" />
<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript" src="lib/jquery/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="lib/amazeui/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script type="text/javascript" src="lib/handlebars/handlebars.min.js"></script>
<script type="text/javascript" src="lib/iscroll/iscroll-probe.js"></script>
<script type="text/javascript" src="lib/amazeui/amazeui.min.js"></script>
<script type="text/javascript" src="lib/raty/jquery.raty.js"></script>
<script type="text/javascript" src="js/main.min.js?t=1"></script>
</head>
<body>

    <div class="am-cf"></div>
    <div class="am-slider am-slider-default" data-am-flexslider="{playAfterPaused: 8000}">
        <ul class="am-slides">
        	<c:forEach items="${bans }" var="ban">
        		 <li><img style="height:80%;" src="/ssh_xymh/${ban.content }" title="${ban.title }"/></li>
        	</c:forEach>
        </ul>
    </div>

    <div class="cm-mian">
        <div class="cml-g">
            <!-- <div class="am-u-sm-3 am-u-md-3 am-u-lg-3">
                <div class="cm-type">
                    <ul>
                        <li class="on"><a href="#">新闻资讯</a></li>
                        <li><a href="#">公司动态</a></li>
                        <li><a href="#">行业新闻</a></li>
                        <li><a href="#">农技知识</a></li>
                        <li><a href="#">新闻快讯</a></li>
                    </ul>
                </div>
            </div> -->
           <!--  <div class="am-u-sm-9 am-u-md-9 am-u-lg-9"> -->
            <div class="">
                   <div class="cm-article">
                       <!-- <div class="cm-title">
                           <div class="cm-title-nav">当前位置：<span><a href="#">网站首页</a></span>><span><a href="#">新闻资讯</a></span>><span>公司动态</span></div>
                       </div> -->
                       <ol class="breadcrumb">
							<li><a href="#">网站首页</a></li>
							<li class="active"><a href="#">新闻资讯</a></li>
							<%-- <li class="active">${obj.title }</li> --%>
						</ol>
                       <div class="cm-new-list cm-content">
                               <ul  class="cm-new-list-ul">
                               		<c:forEach items="${pagers.datas }" var="news">
                               			<li><a href="/ssh_xymh//news/newDetail.do?id=${news.id}"><span>${news.title }</span><i><fmt:formatDate value="${news.addTime}" type="both"/></i></a></li>
                               		</c:forEach>
                                   <!-- <li class="on"><a href="./new_info.html"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li>
                                   <li><a href="#"><span>专家预言：有机肥将瓜分化肥半个天下</span><i>2017-05-01</i></a></li> -->
                               </ul>

                          <!--  <div class="cm-page">
                               <ul>
                                   <li class="disabled"><a href="javascript:;">首页</a></li>
                                   <li class="on"><a href="javascript:;">1</a></li>
                                   <li class="item"><a href="javascript:;">2</a></li>
                                   <li class="item"><a href="javascript:;">3</a></li>
                                   <li class="item"><a href="javascript:;">4</a></li>
                                   <li class="item"><a href="javascript:;">5</a></li>
                                   <li class="item"><a href="javascript:;">6</a></li>
                                   <li class="item"><a href="javascript:;">尾页</a></li>
                               </ul>
                           </div> -->
                       </div>
                   </div>
            </div>
        </div>
    </div>
    
</body>
</html>