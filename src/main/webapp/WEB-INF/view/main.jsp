<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/base.css" rel="stylesheet" type="text/css">
<link href="resources/js/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/js/lib/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<title>测试首页</title>
</head>
<body style="background-color:#cecece;">
 <div class="container">
  <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse">
          <span class="sr-only"></span>
        </button>
        <span class="navbar-brand" style="color:white;font-family:"微软雅黑";"><span style="margin-left:20px;">相关技术学习平台</span></span>
      </div>
     <ul id="menu" class="nav navbar-nav" style="margin-left:8%;">
      <li class="active">
        <a rel="./main.do" class="dropdown-toggle" data-toggle="dropdown">首页</a>
      </li>
      <li class="dropdown">
         <a rel="#" class="dropdown-toggle" data-toggle="dropdown">文件流操作</a>
         <ul class="dropdown-menu" role="menu">
	          <li><a rel="./fileUpload.do">文件上传</a></li>
	          <li><a rel="/excelWriteRead.do">poi读写操作</a></li>
	     </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="pull-right" style="margin-right:50px;">
        <div style="font-size: 12px;color:white;margin-top: 5px">
            <div>
              <label for="username">欢迎：</label>
              <span title="角色：admin">admin</span>
            </div>
            <div style="text-align: right;">
              <a href="#" id="loginOut" style="color:#fff;">安全退出</a>
            </div>  
        </div>
      </li>
    </ul>
  </nav>
    <iframe id="mainIframe" name="mainIframe" src="./fileUpload.do" scrolling="auto" frameborder="0" style="width:100%;height:100%;border:1px solid #ddd;"></iframe> 
    <div class="footer">
    <!--   <a href="http://www.bosssoft.com.cn" target="_blank" style="color:black;">博思软件</a>
      <span>©2001-2017</span>
      <span>Version：1.0</span> -->
    </div>
  </div>
  <script type="text/javascript" src="resources/js/lib/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="resources/js/lib/jQuery.Form.js"></script>
  <script type="text/javascript" src="resources/js/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  $(function(){
		main.init();
		$("#mainIframe").height($(window).height()*0.85);
	});
	var main={
		init:function(){
			this.initcomponent();
		},
		initcomponent:function(){
			$("#loginOut").click(function(){
				window.location.href="./main.do";
			});
			$("#menu").find("li").each(function(){
				$(this).click(function(){
				       	$(this).addClass("active").siblings().removeClass("active");	       		 
				       	 var rel=$(this).find("a").attr("rel");
				       	 if(rel!="#"){
				       	     	main.iframeInit(rel);
				       	  }else{
				       	     	
				       	 }  
				 })
			})
		},
		iframeInit:function(rel){
			$("#mainIframe").attr("src",rel);
		}
	}
  </script>
</body>
</html>