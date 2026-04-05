package SESSION01.BAI02

public class Main {
// Vấn đề nằm ở chỗ: @Component mặc định trong Spring Framework có scope là Singleton

// Giải thích:
// - Singleton nghĩa là chỉ có 1 instance duy nhất của PlaySession trong toàn bộ hệ thống
// - Tất cả các máy (user/session) đều dùng chung 1 object PlaySession này
// - Biến playTime bị chia sẻ → khi máy 01 tăng thời gian thì máy 02 cũng bị ảnh hưởng
// - Dẫn đến hiện tượng nhiều máy bị trừ tiền chung một bộ đếm (sai logic nghiệp vụ)

// Kết luận:
// → Do dùng Singleton cho dữ liệu mang tính "state riêng theo từng user/session"
// → Nên gây ra shared state → dẫn đến tính tiền sai
}
