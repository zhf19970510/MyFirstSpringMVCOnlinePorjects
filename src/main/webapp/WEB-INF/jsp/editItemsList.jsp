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
        function updateItems() {
            document.itemsForm.action="itemsManager/updateItemsList";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" action="">
    <table width="100%" border="1">
        <tr>
            <td><input type="button" value="查询"/>
                <input type="button" value="批量修改" onclick="updateItems()"/></td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>订购日期</td>
            <td>商品描述</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach items="${items}" var="item" varStatus="s">
            <tr>

                <td><input type="checkbox" value="${item.id}" name="delete_id"/>
                   <input type="text" name="itemsList[${s.index}].name" value="${item.name}" />
                </td>
                <td><input type="text" name="itemsList[${s.index}].price" value="${item.price}" /></td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"/></td>
                <td>${item.detail}</td>
                <td align="center"><a href="itemsManager/editItems?id=${item.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
