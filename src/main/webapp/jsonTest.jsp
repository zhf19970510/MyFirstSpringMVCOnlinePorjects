<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jsonTest.jsp</title>
    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        //请求JSON，响应JSON
        var dataParam={"name":"手机","price":2000};
        function requestJson() {
            $.ajax({
                url:"requestJson",
                type:"post",
                contentType:"application/json;charset=utf-8",
                //请求JSON数据,使用JSON表示商品信息
                data:JSON.stringify(dataParam),
                success:function (data) {
                    alert(data);
                }
            });
        }
        //请求key,value  响应JSON
        function responseJson() {
            $.ajax({
                url:"responseJson",
                type:"post",
                //请求键值对数据,使用JSON表示商品信息
                data:"name=手机&price=2000",
                success:function (data) {
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" value="请求JSON，响应JSON" onclick="requestJson()" />
    <input type="button" VALUE="请求key/value，响应JSON" onclick="responseJson()" />
</body>
</html>
