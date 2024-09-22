﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
 <!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>关于我们</title>
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
            <div class="am-u-sm-3 am-u-md-3 am-u-lg-3">
                <div class="cm-type">
                    <ul>
                    	<c:forEach items="${aboutList}" var="about">
                    		<li id="${about.id }"><a href="/ssh_xymh//about/webAbout.do?id=${about.id}">${about.title }</a></li>
                    	</c:forEach>
                        
                       <!--  <li><a href="#">公司简介</a></li>
                        <li><a href="#">企业文化</a></li>
                        <li><a href="#">管理团队</a></li>
                        <li><a href="#">组织架构</a></li>
                        <li><a href="#">荣誉资质</a></li> -->
                    </ul>
                </div>
            </div>
            <div class="am-u-sm-9 am-u-md-9 am-u-lg-9">
                   <div class="cm-article">
                       <%-- <div class="cm-title">
                           <div class="cm-title-nav">当前位置：<span><a href="#">网站首页</a></span>><span><a href="#">关于我们</a></span>><span>${obj.title }</span></div>
                       </div> --%>
                       <ol class="breadcrumb">
							<li><a href="#">网站首页</a></li>
							<li><a href="#">关于我们</a></li>
							<li class="active">${obj.title }</li>
						</ol>
                       <div class="cm-content">
                           ${obj.content }
                       </div>
                   </div>
            </div>
        </div>
    </div>
    
<script type="text/javascript">
$(document).ready(function(){
	//设置菜单当前项
	var id = '${obj.id}';
	$("#"+id).addClass("on");
	
});
</script>

</body>
</html>