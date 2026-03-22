    1. Chuỗi SQL sau khi bị nối
Input hacker nhập:
' OR '1'='1
Câu SQL ban đầu:
String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
Sau khi nối chuỗi sẽ thành:
SELECT * FROM Patients WHERE full_name = '' OR '1'='1'

    2. Phân tích mệnh đề WHERE
Mệnh đề WHERE lúc này là:
full_name = '' OR '1'='1'
Tách logic ra:
Phần	Ý nghĩa
full_name = ''	So sánh tên rỗng (thường là FALSE)
'1'='1'	Luôn TRUE (vì 1 = 1)
 3. Vì sao luôn TRUE?
Trong SQL:
A OR B
Nếu B = TRUE → toàn bộ biểu thức = TRUE
Áp dụng:
FALSE OR TRUE → TRUE
Vì '1'='1' luôn đúng → cả WHERE luôn đúng

    4. Hậu quả
Câu lệnh trở thành:
SELECT * FROM Patients
KHÔNG còn filter theo tên nữa
Trả về TOÀN BỘ dữ liệu bệnh nhân
Kết luận
Hacker chèn: ' OR '1'='1
Biến WHERE thành:
... OR TRUE
SQL hiểu là: lọc gì cũng đúng
 Dẫn đến SQL Injection