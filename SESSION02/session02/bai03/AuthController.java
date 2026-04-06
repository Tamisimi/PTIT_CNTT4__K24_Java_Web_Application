package session02.bai03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {

        if (("admin".equals(username) && "admin123".equals(password)) ||
            ("staff".equals(username) && "staff123".equals(password))) {

            String fullName = "admin".equals(username) ? "Quản trị viên" : "Nhân viên thu ngân";
            String role = "admin".equals(username) ? "Quản trị" : "Thu ngân";

            session.setAttribute("loggedUser", fullName);   // Session Scope
            session.setAttribute("role", role);             // Session Scope

            return "redirect:/orders";
        } else {
            redirectAttributes.addFlashAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
