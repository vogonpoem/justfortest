<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>剧本评估</title>
</head>
<body>
<form id="mainform" method="post" action="upload" enctype="multipart/form-data">
上传文件：<input type="file" id="file" name="file"/><br>
<input type="submit" value="上传"/><br>
<!-- 注意只能传txt文件，以后会用js控制文件类型 -->
</form>
</body>
</html>