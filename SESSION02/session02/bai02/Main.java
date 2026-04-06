package session02.bai02;

/*
 * 
 * PHẦN 1 — PHÂN TÍCH LOGIC(6 vấn đề chính)
 
 * 1. <%! private int requestCounter = 0; %>
 *    → Loại vấn đề: Declaration + Race Condition
 *    → Hậu quả: Biến này là biến instance, tất cả các request dùng chung một biến → 
 *       Dễ xảy ra Race Condition trong môi trường server đa luồng (Tomcat). 
 *       Vi phạm nghiêm trọng nguyên tắc "Thin View - View ngốc nghếch".
 * 
 * 2.  Tiêu đề trang báo cáo
 *    → Loại vấn đề: HTML Comment thay vì JSP Comment
 *    → Hậu quả: Comment HTML sẽ được gửi về trình duyệt người dùng, không nên dùng cho ghi chú nội bộ.
 * 
 * 3. <%= sv.getScore()%>;</td>
 *    → Loại vấn đề: Expression + Lỗi cú pháp
 *    → Hậu quả: Dư dấu chấm phẩy ";" bên trong <%= %>, gây hiển thị sai (xuất hiện dấu ; trên bảng).
 * 
 * 4. Toàn bộ khối <% for (...) { ... } %> và if-else xếp loại
 *    → Loại vấn đề: Scriptlet + Logic nặng trong View
 *    → Hậu quả: Vi phạm nguyên tắc Thin View. View chứa quá nhiều Java code → khó đọc, khó bảo trì, khó test.
 * 
 * 5. <%= sv.getFullName() %>
 *    → Loại vấn đề: XSS Vulnerability (bảo mật)
 *    → Hậu quả: Không escape dữ liệu → dễ bị tấn công Cross-Site Scripting (XSS) nếu dữ liệu từ người dùng.
 * 
 * 6. Sử dụng Scriptlet (<% %>) và Expression (<%= %>) để xử lý dữ liệu
 *    → Loại vấn đề: Không sử dụng EL + JSTL
 *    → Hậu quả: Code cũ kỹ, lộn xộn, không theo chuẩn hiện đại của JSP.
 * 
 * ===================================================================
 * PHẦN 2 — FILE report.jsp ĐÃ REFACTOR CHUẨN (Thin View)
 * 
 * Yêu cầu đã thực hiện:
 * - Không còn Scriptlet (<% %>)
 * - Không còn Declaration (<%! %>)
 * - Không còn Expression cũ (<%= %>)
 * - Sử dụng JSTL (<c:forEach>, <c:choose>)
 * - Sử dụng EL (${})
 * - Sử dụng <c:out> để chống XSS
 * - Sử dụng JSP Comment (<%-- --%>)
 * - Xóa hoàn toàn biến requestCounter
 * ===================================================================
 */

// Nội dung file report.jsp sau khi refactor (copy phần dưới đây dán vào report.jsp):

/*
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Báo cáo điểm sinh viên</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #999; padding: 10px; text-align: center; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>

    <h1>${reportTitle}</h1>

    <table>
        <tr>
            <th>STT</th>
            <th>Họ tên</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
        </tr>

        <c:forEach var="sv" items="${studentList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${sv.fullName}" /></td>
                <td>${sv.score}</td>
                <td>
                    <c:choose>
                        <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                        <c:when test="${sv.score >= 80}">Giỏi</c:when>
                        <c:when test="${sv.score >= 70}">Khá</c:when>
                        <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                        <c:when test="${sv.score >= 50}">Trung bình</c:when>
                        <c:otherwise>Yếu</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
*/

public class Main {
   
}
