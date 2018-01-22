<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fileoperation.Txt2String"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请稍等</title>
</head>
<body>
文件上传成功，系统正在分析，请稍候<br>
<%
request.setCharacterEncoding("UTF-8");
String localpath = (String)request.getAttribute("localpath");
String readfromfile = Txt2String.ReadStringFromTxt(localpath);
Date now = new Date();
SimpleDateFormat dateFormat = new 	SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//可以方便地修改日期格式
String nowtime = dateFormat.format( now );
//String output = new String( readfromfile.getBytes("GBK"),"UTF-8");
out.println(readfromfile);
Txt2String.WriteStringToFile(getServletContext().getRealPath("/uploadFiles/") + nowtime + ".txt", readfromfile);

%>

</body>
</html>