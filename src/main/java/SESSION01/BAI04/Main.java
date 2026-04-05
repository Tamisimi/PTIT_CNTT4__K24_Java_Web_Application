package SESSION01.BAI04;

// ===== Interface =====
interface EmailSender {
    void send(String message);
}

interface SmsSender {
    void send(String message);
}

// ===== GIẢI PHÁP 1: Constructor Injection =====
class NotificationService_Constructor {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public NotificationService_Constructor(EmailSender emailSender, SmsSender smsSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public void notifyUser(String message) {
        try {
            smsSender.send(message);
        } catch (Exception e) {
            emailSender.send(message); // fallback khi SMS lỗi
        }
    }
}

/*
Ưu điểm:
- Rõ dependency, dễ test, có thể dùng final (immutability)
- Xử lý tốt lỗi (SMS lỗi → Email)

Nhược điểm:
- Constructor dài nếu nhiều dependency
*/


// ===== GIẢI PHÁP 2: Field Injection =====
class NotificationService_Field {

    EmailSender emailSender;
    SmsSender smsSender;

    public void notifyUser(String message) {
        try {
            smsSender.send(message);
        } catch (Exception e) {
            emailSender.send(message);
        }
    }
}

/*
Ưu điểm:
- Ngắn gọn

Nhược điểm:
- Dependency ẩn, khó test, không đảm bảo bất biến
*/


// ===== KẾT LUẬN =====
/*
→ Chọn Constructor Injection vì rõ ràng, an toàn, dễ test 
và xử lý tốt tình huống SMS bị lỗi
*/
