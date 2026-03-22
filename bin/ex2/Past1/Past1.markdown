Vì sao if không đủ để “in danh sách”?
if (rs.next()) {
    System.out.println("Thuốc: " + rs.getString("medicine_name"));
}

if chỉ kiểm tra 1 lần duy nhất

rs.next() → di chuyển đến dòng đầu tiên
Nếu có dữ liệu → in 1 dòng duy nhất
Sau đó kết thúc luôn

Không lặp → không thể in hết danh sách

Cách hoạt động của con trỏ ResultSet

Ban đầu:

[ BEFORE FIRST ]
Mỗi lần gọi rs.next():
Lần gọi	Vị trí con trỏ
Lần 1	Dòng 1
Lần 2	Dòng 2
Lần 3	Dòng 3
...	...
Hết dữ liệu	Trả về false
next():

Di chuyển con trỏ xuống 1 dòng
Trả về:
true → còn dữ liệu
false → hết dữ liệu