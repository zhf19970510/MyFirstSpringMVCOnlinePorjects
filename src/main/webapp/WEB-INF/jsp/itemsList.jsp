<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fix" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":"
            + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>所有商品</title>

    <script type="text/javascript">
        function deleteItems() {
            document.itemsForm.action="itemsManager/deleteItems";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" action="">
    <table width="100%" border="1">
        <tr>
            <td><input type="button" value="查询"/>
                <input type="button" value="批量删除" onclick="deleteItems()"/></td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>订购日期</td>
            <td>商品描述</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>

                <td><input type="checkbox" value="${item.id}" name="delete_id"/>${item.name}</td>
                <td>${item.price}</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"/></td>
                <td>${item.detail}</td>
                <td align="center"><a href="itemsManager/editItems?id=${item.id}">修改</a></td>
                <td><a href="itemsManager/viewItems/${item.id}">查看商品</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
