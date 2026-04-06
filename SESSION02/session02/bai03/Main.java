package session02.bai03;

/*
 *
 * PHẦN PHÂN TÍCH LOGIC
 *
 * 1. Tại sao thông báo lỗi đăng nhập phải lưu vào Request Scope mà không phải Session Scope?
 *    - Thông báo lỗi chỉ cần hiển thị một lần sau khi đăng nhập sai.
 *    - Request Scope (sử dụng RedirectAttributes.addFlashAttribute) chỉ tồn tại trong một request.
 *    - Nếu lưu vào Session Scope, lỗi sẽ hiển thị mãi mãi cho đến khi session bị xóa hoặc timeout.
 *      Hậu quả: Người dùng thấy lỗi cũ khi refresh trang hoặc đăng nhập lại → rất xấu về UX.
 *
 * 2. Tại sao totalViewCount phải lưu vào Application Scope?
 *    - Application Scope (ServletContext) là dữ liệu chung cho toàn bộ ứng dụng.
 *    - Tất cả nhân viên đều thấy cùng một con số tổng lượt xem đơn hàng.
 *    - Nếu lưu vào Session Scope, mỗi nhân viên sẽ có bộ đếm riêng → kết quả sai yêu cầu (không phải tổng của toàn hệ thống).
 *
 * 3. Race Condition là gì và đoạn code tiềm ẩn nguy cơ:
 *    Đoạn code nguy hiểm:
 *    Integer count = (Integer) application.getAttribute("totalViewCount");
 *    if (count == null) count = 0;
 *    count++;
 *    application.setAttribute("totalViewCount", count);
 *
 *    Race Condition xảy ra khi nhiều thread (nhiều nhân viên) truy cập cùng lúc:
 *    Nhiều thread đọc cùng giá trị cũ, cùng tăng và ghi đè lên nhau → bộ đếm tăng ít hơn thực tế.
 *
 *    Cách khắc phục: Sử dụng AtomicInteger để tăng nguyên tử (atomic increment).
 *    Đây là cách an toàn và hiệu quả nhất trong ứng dụng web đa người dùng.
 */

public class Main {
   
}
