Ý nghĩa của executeUpdate()
int result = stmt.executeUpdate(sql);

Giá trị trả về:

> 0 → số dòng bị ảnh hưởng (update thành công)
= 0 → không có dòng nào bị update (thường là không tìm thấy dữ liệu)
Áp dụng vào bài này
UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = inputId

Nếu bed_id không tồn tại
→ Không có dòng nào khớp
→ executeUpdate() trả về 0