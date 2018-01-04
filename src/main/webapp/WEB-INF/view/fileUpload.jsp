<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/base.css" rel="stylesheet" type="text/css">
<link href="resources/js/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/js/lib/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<title>文件上传示例</title>
</head>
<body>
<div class="container" style="margin-top:20px;">

    <button type="button" class="btn btn-success" id="download">文件下载</button>
    
	<form action="file/upload.do" method="POST" enctype="multipart/form-data" style="margin-top:20px;">
	  <div class="form-group">
	    <label for="file">方式一：普通表单方式上传文件：页面会跳转</label>
	    <input type="file" class="form-control" id="file" name="file" placeholder="表单方式上传文件">
	  </div>	
	  <button type="submit" class="pull-right btn btn-info">上传文件</button>
	</form>
	
	
	<form enctype="multipart/form-data" id="fileForm" style="margin-top:50px;">
	  <div class="form-group">
	    <label for="file">方式二：利用jquery.From插件上传文件：页面不会跳转</label>
	    <input type="file" class="form-control" id="file" name="file"  placeholder="表单方式上传文件">
	  </div>	
	  <button type="button" id="btnSubmit" class="pull-right btn btn-info">上传文件</button>
	</form>
	
	<form id="downloadFile" style="display:none" method="post" action="file/download.do">
        <input type="hidden" id="user_id" name="user_id" value="" />
        <input type="hidden" id="file_name" name="file_name" value="" />
        <input type="hidden" id="req_name" name="req_name" value="" />
    </form>
	
</div>	
<script type="text/javascript" src="resources/js/lib/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/lib/jQuery.Form.js"></script>
<script type="text/javascript" src="resources/js/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(function(){
	$("#download").click(function(){
		 //var req_name = encodeURI(encodeURI(req_name));
         //var file_name = encodeURI(encodeURI(file_name));   //要是是中文要进行编解码前后台都要
         var form=$("#downloadFile");//定义一个form表单
         //$("#user_id").val(users_id);
         //$("#file_name").val(file_name);
         //$("#req_name").val(req_name);
         form.submit();//表单提交
	})
	
	$("#btnSubmit").click(function(){		
 		 var fileName=$("#filename").val();
         /* if(fileName==""||fileName.indexOf(".xls")!=0){
             $a.messager.warn("请上传xlsx格式的文件！");
             return false;
         } */
         
         var options  = {
             url:"file/upload.do",
             type:'post',
             success:function(data){
             	console.log(data);
             },
             complete:function(xhr){
                 var obj = JSON.parse(xhr["responseText"])
                 if(obj.status==200){
             /*    	 var obj = document.getElementById('fileForm') ; 
                	 obj.select(); 
                	 document.selection.clear();  */
                	 alert(obj.message);
                	
                	//清空表单操作 
                 	var form = document.getElementById('fileForm') ; 
                 	form.outerHTML=form.outerHTML;  
                	 
                 }else {
                	 alert(obj.message);
                 }
             },
             error: function(xhr,status,msg){

             }
         };
         $("#fileForm").ajaxSubmit(options);
	})
})

</script>
</body>
</html>