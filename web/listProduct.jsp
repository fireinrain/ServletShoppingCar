<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/31
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align="center" border="1" cellspacing="0">
    <tr>
        <td>(编号)id</td>
        <td>(名称)name</td>
        <td>价格(price)</td>
        <td>购买</td>
    </tr>

    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>

            <td>
                <form action="/addOrderItem" method="post">
                    数量：<input type="text" value="1" name="num">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" value="购买">
                </form>
            </td>

        </tr>


    </c:forEach>


</table>