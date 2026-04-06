package session02.bai03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import session02.bai03.model.Order;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model, ServletContext application) {

        // Kiểm tra session - nếu chưa đăng nhập thì redirect về login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // Lấy thông tin từ Session Scope
        model.addAttribute("userName", session.getAttribute("loggedUser"));
        model.addAttribute("role", session.getAttribute("role"));

        // Tạo danh sách đơn hàng giả (Request Scope)
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("DH001", "iPhone 15 Pro", 25990000, new Date()));
        orders.add(new Order("DH002", "Laptop Dell XPS", 18990000, new Date()));
        orders.add(new Order("DH003", "Tai nghe AirPods Max", 1290000, new Date()));
        orders.add(new Order("DH004", "Màn hình LG UltraWide", 4500000, new Date()));

        model.addAttribute("orderList", orders);

        // Tăng totalViewCount an toàn bằng AtomicInteger (Application Scope)
        AtomicInteger counter = (AtomicInteger) application.getAttribute("totalViewCount");
        if (counter == null) {
            counter = new AtomicInteger(0);
            application.setAttribute("totalViewCount", counter);
        }
        int totalViews = counter.incrementAndGet();

        model.addAttribute("totalViewCount", totalViews);

        return "orders";
    }
}
