<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
	<script type="text/javascript" src="../js/jquery-3.0.0.min.js"></script>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>三角形判断</title>
</head>
<body>
<h2>三角形判断</h2>
<div style="border: 1px solid #ccc; width: 600px;">  
<p>请输入三个不大于200的正整数<br>我们将对三边是否构成三角形进行判断,并判断是否是特殊三角形</p>
<hr>
a:<input id="a" type="text" size="9">
b:<input id="b" type="text" size="9">
c:<input id="c" type="text" size="9">
<input type="submit" id="check" value="check" /><br><br>
结果: <span id = "result"></span><br><br>
</div>
</body>
<script type="text/javascript">   

$(document).ready(function(){
	  
	$("#check").click(function(){
		var postUrl = "/myapp-study/triangle/check";
		var params = {
				a:  $("#a").val(),  
                b:  $("#b").val(),
                c:  $("#c").val()
		}
		
		$.post(postUrl,params,function(result){
			
			$("#result").html(result.msg);
			
		});
		
	});
	  
});
</script>
</html>