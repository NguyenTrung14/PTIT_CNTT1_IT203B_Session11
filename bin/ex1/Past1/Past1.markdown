Phân tích ngắn gọn
Vấn đề

Mỗi lần gọi:

DriverManager.getConnection(...)

Tạo một connection mới
Nhưng không close()

Vì sao nguy hiểm (hệ thống 24/7)?
1. Rò rỉ tài nguyên (Connection Leak)
Connection không đóng → bị giữ trong RAM + DB
Tích lũy theo thời gian → cạn tài nguyên
2. Hết connection (Connection Pool Exhausted)
DB chỉ cho phép số connection giới hạn (ví dụ: 100)
Mở liên tục → full
Request mới không kết nối được → hệ thống treo
3. Giảm hiệu năng nghiêm trọng
Tạo connection rất tốn chi phí (network + auth)
Làm liên tục → chậm toàn hệ thống
4. Lỗi “Communications link failure”
Connection cũ bị timeout nhưng vẫn giữ
Dùng lại → lỗi kết nối
5. Nguy hiểm trong hệ thống y tế
Hệ thống cần chạy 24/7
Nếu treo:
Không đặt lịch khám được
Không truy cập bệnh án
Ảnh hưởng trực tiếp đến bệnh nhân