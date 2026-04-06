package session02.bai04;

/*
 
 * PHẦN PHÂN TÍCH LOGIC
 *
 * 1. XSS là gì? Tại sao <c:out value="${keyword}"/> an toàn hơn ${keyword}?
 *    - XSS (Cross-Site Scripting) là lỗ hổng cho phép kẻ tấn công chèn mã JavaScript độc hại vào trang web.
 *      Khi người dùng nhập <script>alert('Bị hack!')</script> vào ô tìm kiếm, nếu hiển thị trực tiếp bằng ${keyword},
 *      trình duyệt sẽ thực thi mã script → popup alert (rất nguy hiểm).
 *
 *    - <c:out value="${keyword}" escapeXml="true"/> sẽ tự động escape các ký tự đặc biệt (< > & " ') thành thực thể HTML (&lt; &gt; &amp; &quot; &#39;).
 *      Kết quả: Mã <script>alert(1)</script> được hiển thị dưới dạng text thuần, không bị thực thi.
 *
 *    So sánh output:
 *    - ${keyword}               → <script>alert('xss')</script>   (thực thi mã)
 *    - <c:out value="${keyword}"/> → &lt;script&gt;alert('xss')&lt;/script&gt;  (an toàn)
 *
 * 2. Sự khác nhau giữa <c:if> và <c:choose>/<c:when>/<c:otherwise>. Nên dùng loại nào cho "Giá vé" và "Vé còn lại"?
 *    - <c:if> chỉ kiểm tra một điều kiện (true/false). Không có nhánh else.
 *    - <c:choose> cho phép nhiều điều kiện mutually exclusive (như switch-case), có <c:when> và <c:otherwise> (else).
 *
 *    Trong bài này:
 *    - Phần "Giá vé" và "Vé còn lại" có nhiều trường hợp (price == 0, remainingTickets == 0, < 10, bình thường)
 *      → Nên dùng <c:choose> vì rõ ràng, dễ đọc và tránh lồng nhiều <c:if>.
 *
 * 3. <c:url> giải quyết vấn đề gì so với hardcode href="/events/1/book"?
 *    - <c:url> tự động thêm context path của ứng dụng (ví dụ: /ticketing).
 *    - Nếu hardcode href="/events/1/book" và ứng dụng deploy với context path /ticketing,
 *      link sẽ bị sai → 404 Not Found.
 *    - <c:url value="/events/${event.id}/book"/> sẽ sinh ra đúng URL: /ticketing/events/1/book
 */

public class Main {
}
