<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/31
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

<c:if test="${!empty user}">
    <div align="center">
        当前用户：${user.name}
    </div>
</c:if>


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
                <!--action="/addOrderItem" method="post"  -->
                <form id="form-data">
                    数量：<input type="text" value="1" name="num" >
                    <input type="hidden" name="pid" value="${product.id}" >
                    <input type="button" value="加入购物车" class="btns" >
                </form>
                <span class="message" style="color:green"></span>
            </td>

        </tr>


    </c:forEach>

    <tr>
        <td align="center" colspan="4"><a href="/listOrderItem.jsp">我的购物车</a></td>
    </tr>
</table>

<!--  -->
<script src="js/addOrderItem.js">
   //ajax加入购物车
</script>
</body>
</html>

