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
    <title>editItems.jsp</title>
</head>
<body>
<%--显示错误信息--%>
<c:forEach items="${errors}" var="error">
    ${error.defaultMessage}<br/>

</c:forEach>
<form action="itemsManager/editItemsSubmit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${item.id}"/>
    <table>
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="name" value="${item.name}"></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="price" value="${item.price}"></td>
        </tr>
        <tr>
            <td>商品图片：
            <c:if test="${item.pic != null and (not empty item.pic)}">
                <img src="images/${item.pic}" width="100" height="100" /><br/>
            </c:if>
            <input type="file" name="picFile" />
            </td>
        </tr>
        <tr>
            <td>订购日期：</td>
            <td><input type="text" name="createtime" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy-MM-dd' />"></td>
        </tr>
        <tr>
            <td>商品简介：</td>
            <td><input type="text" name="detail" value="${item.detail}"></td>
        </tr>
        <tr colspan="2" align="center"><input type="submit" value="提交" /></tr>
    </table>
</form>
</body>
</html>