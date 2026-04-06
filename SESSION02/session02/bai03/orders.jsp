<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
    <style>
        table { border-collapse: collapse; width: 90%; margin: 20px auto; }
        th, td { border: 1px solid #666; padding: 10px; text-align: center; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>

    <h2>Xin chào, ${userName}! Vai trò: ${role}</h2>

    <h3>Danh sách đơn hàng</h3>
    <table>
        <tr>
            <th>Mã đơn</th>
            <th>Sản phẩm</th>
            <th>Tổng tiền (VNĐ)</th>
            <th>Ngày đặt</th>
        </tr>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.productName}</td>
                <td>
                    <fmt:formatNumber value="${order.totalAmount}" 
                                      type="currency" 
                                      currencySymbol="₫" 
                                      maxFractionDigits="0"/>
                </td>
                <td>
                    <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p><strong>Tổng lượt xem đơn hàng toàn hệ thống: ${totalViewCount}</strong></p>
    <br>
    <a href="/logout">Đăng xuất</a>

</body>
</html>
