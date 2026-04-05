package SESSION01.BAI01

public class Main {
// Sai ở dòng:
// this.gateway = new InternalPaymentGateway();

// Giải thích:
// - Việc dùng "new InternalPaymentGateway()" là hard-code dependency → RechargeService bị phụ thuộc chặt vào 1 implementation cụ thể
// - Vi phạm nguyên lý IoC vì class tự tạo dependency thay vì để container Spring quản lý và inject vào
// - Làm mất tính linh hoạt: nếu muốn đổi sang MomoPaymentGateway hoặc ZaloPayGateway thì phải sửa code trong RechargeService
// - Khó mở rộng và bảo trì khi hệ thống lớn lên vi phạm nguyên lý Open/Closed
// - Khó test không thể dễ dàng mock PaymentGateway

// Kết luận:
// → Cách viết này tạo tight coupling, không tận dụng được Dependency Injection của Spring nên làm ứng dụng kém linh hoạt
}
