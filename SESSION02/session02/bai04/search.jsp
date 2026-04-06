<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Kết quả tìm kiếm sự kiện</title>
    <style>
        table { border-collapse: collapse; width: 95%; margin: 20px auto; }
        th, td { border: 1px solid #666; padding: 10px; text-align: center; }
        .free { color: green; font-weight: bold; }
        .out-of-stock { color: red; font-weight: bold; }
        .low-stock { color: orange; font-weight: bold; }
        .normal-stock { color: blue; }
    </style>
</head>
<body>

    <h2>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h2>
    <p>Tìm thấy <strong>${fn:length(events)}</strong> sự kiện.</p>

    <!-- Trường hợp không tìm thấy -->
    <c:if test="${empty events}">
        <h3 style="color: red;">Không tìm thấy sự kiện nào phù hợp.</h3>
    </c:if>

    <!-- Bảng kết quả khi có dữ liệu -->
    <c:if test="${not empty events}">
        <table>
            <tr>
                <th>STT</th>
                <th>Tên sự kiện</th>
                <th>Ngày tổ chức</th>
                <th>Giá vé</th>
                <th>Vé còn lại</th>
                <th>Thao tác</th>
            </tr>

            <c:forEach var="event" items="${events}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><c:out value="${event.name}"/></td>
                    <td>${event.date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${event.price == 0}">
                                <span class="free">MIỄN PHÍ</span>
                            </c:when>
                            <c:otherwise>
                                <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true"/> ₫
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <span class="out-of-stock">HẾT VÉ</span>
                            </c:when>
                            <c:when test="${event.remainingTickets < 10}">
                                <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                            </c:when>
                            <c:otherwise>
                                <span class="normal-stock">${event.remainingTickets}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <button disabled>Đặt vé</button>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/events/${event.id}/book'/>">Đặt vé</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <!-- Phần footer -->
    <c:if test="${not empty events}">
        <p><strong>Tên sự kiện đầu tiên (viết hoa):</strong> 
            ${fn:toUpperCase(events[0].name)}
        </p>
    </c:if>

    <p><strong>Số ký tự của từ khóa tìm kiếm:</strong> ${fn:length(keyword)} ký tự.</p>

</body>
</html>
