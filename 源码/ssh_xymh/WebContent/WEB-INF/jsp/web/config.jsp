<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/ssh_xymh//resource/css/pintuer.css">
    <link rel="stylesheet" href="/ssh_xymh//resource/css/admin.css">
    <script src="/ssh_xymh//resource/js/jquery.js"></script>
     <script src="/ssh_xymh//resource/js/pintuer.js"></script>  
</head>
<style>
    .file1 {
        position: relative;
        display: inline-block;
        background: #D0EEFF;
        border: 1px solid #99D3F5;
        border-radius: 4px;
        padding: 4px 12px;
        overflow: hidden;
        color: #1E88C7;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
    }
    .file1 input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }
    .file1:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }
</style>
<body>
<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/ssh_xymh//web/save.do" enctype="multipart/form-data"> 
    <input type="hidden" name="id" value="${obj.id}">  
       <div class="form-group">
        <div class="label">
          <label>公司名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name"  data-validate="required:请输入公司名称" value="${obj.name}"/>         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>公司网址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="web"  data-validate="required:请输入公司网址" value="${obj.web}"/>         
          <div class="tips"></div>
        </div>
      </div> 
        <div class="form-group">
        <div class="label">
          <label>公司地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="address" data-validate="required:请输入公司地址" value="${obj.address}"/>         
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>公司邮编：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="email"  data-validate="required:请输入公司邮编" value="${obj.email}"/>         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>公司电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tel"  data-validate="required:请输入公司电话" value="${obj.tel}"/>         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>公司备案：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="beian"  data-validate="required:请输入公司备案" value="${obj.beian}"/>         
          <div class="tips"></div>
        </div>
      </div> 
       <%-- <div class="form-group">
        <div class="label">
          <label>公司介绍：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="introduce"  data-validate="required:请输入公司介绍" value="${obj.introduce}"/>         
          <div class="tips"></div>
        </div>
      </div>  --%>
      
      <div class="form-group">
        <div class="label">
          <label>公司介绍：</label>
        </div>
        <div class="field">
          <textarea class="input" name="introduce" style=" height:90px;">${obj.introduce}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
      
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
$("#zp1").on("change","input[type='file']",function(){
    var filePath = $(this).val();
    var filePath = filePath.split('\\');
    var filePath = filePath[filePath.length-1];
    $('#file').val(filePath);
})

</script>
</html>