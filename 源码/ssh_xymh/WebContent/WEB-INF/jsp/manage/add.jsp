<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demo</title>
</head>
<body>
  <form action="/ssh_xymh//manage/exAdd.do" method="post" enctype="multipart/form-data">
  <div style="width: 800px;border: 1px solid red;margin: 0 auto;margin-top: 200px">
   <table width="100%" border="1" cellpadding="2" cellspacing="0">
   <tr>
     <td colspan="7" style="color: red;font-weight: bold;text-align: center;">demo测试数据添加</td>
   </tr>
  <!--  private String name;
	private String nickname;
	private String sex;
	private String images;
	 *  @Fields Password : password -->
   <tr>
     <td colspan="2" align="center">姓名</td> <td colspan="5"><input type="text" name="name"/></td>
   </tr>
   <tr>
     <td colspan="2" align="center">昵称</td> <td colspan="5"><input type="text" name="nickname"/></td>
   </tr>
   <tr>
    <td colspan="2" align="center">性别</td> <td colspan="5"><input type="text" name="sex"/></td>
   </tr>
   <tr>
    <td colspan="2" align="center">密码</td> <td colspan="5"><input type="text" name="password"/></td>
   </tr>
   <tr>
    <td colspan="2" align="center">头像</td> <td colspan="5"><input type="file" name="file"/></td>
   </tr>
   <tr>
    <td colspan="7" align="center"><input type="submit" value="提交"/></td>
   </tr>
   </table>
  </div>    
  </form>              
</body>
</html>