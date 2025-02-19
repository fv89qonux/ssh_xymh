<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>校园门户网站首页</title>
		<link rel="stylesheet" type="text/css" href="/ssh_xymh//resource/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/ssh_xymh//resource/css/popup.css"/>
			<script src="/ssh_xymh//resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<body>
		<%@ include file="/common/menu.jsp" %>
		<!--inside content start-->
		<div class="inside_wrap">
			<div class="inside_con">
				<div class="adr">
					<a href="index.html">首页</a>&nbsp;>&nbsp;学科资源
				</div>
				<div class="inside_box">
					<!-- <div class="sidemenu fl">
						<div class="s_title">新闻快讯</div>
					</div> -->
					<div class="ic_wrap fr">
						<ul class="news_list">
						 <c:forEach items="${pagers.datas}" var="data" varStatus="l">
		                 	<li><a href="${ctx }/xkzy/detail.do?id=${data.id}">${data.title }</a><span class="date">[
		                 	<fmt:formatDate value="${data.addTime}" type="both"/>]
		                 	</span></li>
		                 
		                 </c:forEach>
						</ul>
						<!--分页-->
						<div class="record">
	                        <!-- 分页开始 -->
			      <pg:pager  url="/ssh_xymh//xkzy/findByObj2.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
					<pg:last>  
						共${pagers.total}记录,共${pageNumber}页,  
					</pg:last>  
						当前第${curPage}页 
			        <pg:first>  
			    		<a href="${pageUrl}">首页</a>  
					</pg:first>  
					<pg:prev>  
			    		<a href="${pageUrl}">上一页</a>  
					</pg:prev>  
			       	<pg:pages>  
			        	<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">[${pageNumber }]</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">${pageNumber}</a>  
			            	</c:otherwise>  
			        	</c:choose>  
			    	</pg:pages>
			             
			        <pg:next>  
			    		<a href="${pageUrl}">下一页</a>  
					</pg:next>  
					<pg:last>  
						<c:choose>  
			            	<c:when test="${curPage eq pageNumber}">  
			                	<font color="red">尾页</font>  
			            	</c:when>  
			            	<c:otherwise>  
			               		<a href="${pageUrl}">尾页</a>  
			            	</c:otherwise>  
			        	</c:choose> 
			    		  
					</pg:last>
				</pg:pager>
				 </div>
	                    </div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!--footer start-->
		<%@ include file="/common/footer.jsp" %>
		
			<script src="/ssh_xymh//resource/js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="/ssh_xymh//resource/js/common.js"></script>
		<script src="/ssh_xymh//resource/js/jquery.slides.min..js"></script>
	</body>
	</body>
</html>
</head>