<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/1
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>


<h1 align="center">${user.name}的购物车</h1>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>商品名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>小计</td>
        <td>删除</td>
    </tr>

    <c:forEach items="${orderitems}" var="orderitem" varStatus="st">
        <tr>
            <td>${orderitem.product.name}</td>
            <td>${orderitem.product.price}</td>
            <td>${orderitem.num}</td>
            <td><fm:formatNumber type="number" value="${orderitem.num*orderitem.product.price}" pattern="0.00" maxFractionDigits="2"/></td>
            <td><a href="/deleteOrderItem?id=${orderitem.product.id}">删除</a></td>

        </tr>
    </c:forEach>

    <c:if test="${!empty orderitems}">
        <tr>
            <td colspan="4" align="center"><a href="/createOrder">生成订单</a></td>
        </tr>
    </c:if>

</table>
