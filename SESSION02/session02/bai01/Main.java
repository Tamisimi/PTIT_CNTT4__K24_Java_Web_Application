package session02.

  public class Main {

/*
 * PHẦN 1 — PHÂN TÍCH LOGIC (Trả lời 3 câu hỏi của bài tập)

1. Lỗi trong MyWebAppInitializer.java:
   - Servlet mapping được cấu hình là "/api/*".
   - DispatcherServlet chỉ nhận và xử lý các request có URL bắt đầu bằng /api/.
   - Khi truy cập http://localhost:8080/demo/welcome → URL này KHÔNG khớp với /api/*.
   - Kết quả: Tomcat trả về HTTP 404 ngay từ đầu vì DispatcherServlet không được gọi đến.
   - DispatcherServlet đang nghe những URL nào? → Chỉ nghe các URL dạng /api/...

2. Lỗi trong WebConfig.java:
   - @ComponentScan(basePackages = "com.demo.service")
   - Spring chỉ quét tìm bean (@Controller, @Service, ...) trong package com.demo.service và các package con của nó.
   - Nhưng lớp WelcomeController nằm ở package com.demo.controller → Spring không tìm thấy Controller.
   - Hậu quả: Không có handler nào xử lý được request /welcome → gây ra 404 (hoặc lỗi mapping).

3. Tổng hợp:
   - Nếu chỉ sửa lỗi 1 (đổi servlet mapping thành "/") mà không sửa lỗi 2 (ComponentScan):
     → Ứng dụng VẪN KHÔNG CHẠY ĐƯỢC.
   - Lý do: DispatcherServlet sẽ nhận được request, nhưng vì không tìm thấy @Controller nào (scan sai package), nên không biết ánh xạ /welcome tới method nào → vẫn bị 404.
   - Phải sửa cả 2 lỗi thì luồng mới chạy hết: DispatcherServlet → HandlerMapping → Controller → ViewResolver → JSP.
*/
}
