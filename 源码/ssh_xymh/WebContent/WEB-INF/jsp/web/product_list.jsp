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
                    	<c:forEach items="${typeList}" var="type">
                    		<li id="${type.id }"><a href="/ssh_xymh//product/products.do?type=${type.id }">${type.title }</a></li>
                    	</c:forEach>
                    </ul>
                </div>
            </div>
            <div class="am-u-sm-9 am-u-md-9 am-u-lg-9">
                <div class="cm-article">
                    <!-- <div class="cm-title">
                        <div class="cm-title-nav">当前位置：<span><a href="#">网站首页</a></span>><span><a href="#">产品展示</a></span></div>
                    </div> -->
                    <ol class="breadcrumb">
							<li><a href="#">网站首页</a></li>
							<li class="active"><a href="#">产品展示</a></li>
							<%-- <li class="active">${obj.title }</li> --%>
					</ol>
                    <div class="cm-content">
                        <div class="prodoct-list">
                        	<c:forEach items="${pagers.datas }" var="product">
                        		 <div class="am-u-sm-6 am-u-md-6 am-u-lg-3">
                                <a href="/ssh_xymh//product/detail.do?id=${product.id }">
                                    <img src="/ssh_xymh/${product.image}" />
                                    <span class="f-toe">${product.title }</span>
                                </a>
                            </div>
                        	</c:forEach>
                        </div>
                        <!-- <div class="cm-page">
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

<script type="text/javascript">
$(document).ready(function(){
	//设置菜单当前项
	var type = '${type}';
	$("#"+type).addClass("on");
	
});
</script>
</body>
</html>