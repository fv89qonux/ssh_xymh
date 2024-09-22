<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
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
    <style type="text/css">
        html, body { margin: 0; padding: 0; }
        .iw_poi_title { color: #CC5522; font-size: 14px; font-weight: bold; overflow: hidden; padding-right: 13px; white-space: nowrap; }
        .iw_poi_content { font: 12px arial,sans-serif; overflow: visible; padding-top: 4px; white-space: -moz-pre-wrap; word-wrap: break-word; }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
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
                        <li class="on"><a href="#">联系我们</a></li>
                        <li><a href="message.html">在线留言</a></li>
                    </ul>
                </div>
            </div> -->
            <div class="">
                    <div class="cm-article">
                       <!--<div class="cm-title">
                           <div class="cm-title-nav">当前位置：<span><a href="#">网站首页</a></span>><span><a href="#">联系我们</a></span></div>
					</div> -->
					<ol class="breadcrumb">
							<li><a href="#">网站首页</a></li>
							<li  class="active"><a href="#">联系我们</a></li>
							<!-- <li class="active">Data</li> -->
						</ol>
                       <div class="cm-content">
                           <div class="">
                               <div class="contact">
                                   <h1>${obj.name }</h1>
                                   <!-- <h2>Daye Aladdin Technology Co、Ltd</h2> -->
                                   <ul>
                                       <li><span>公司电话：</span>${obj.tel }</li>
                                       <li><span>公司地址：</span>${obj.address }</li>
                                       <li><span>公司备案：</span>${obj.beian }</li>
                                       <li><span>邮编：</span>${obj.email }</li>
                                       <li><span>公司网址：</span>${obj.web }</li>
                                       <li><span>公司介绍：</span>${obj.introduce }</li>
                                   </ul>
                               </div>
                           </div>
                       </div>
                   </div>
            </div>
        </div>
    </div>

</body>
</html>