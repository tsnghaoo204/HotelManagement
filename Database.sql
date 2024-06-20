create database QLKhachSan
go

use QLKhachSan
go

create table NhanVien(
	MaNV varchar(100) primary key,
	TenNV nvarchar(100),
	GioiTinh nvarchar(10),
	DiaChi nvarchar(100),
	SDT varchar(100),
	CaLam nvarchar(50),
	Luong money,
	SoNgayNghi int,
	TinhTrang nvarchar(50),
)

create table TaiKhoan(
	TenTK varchar(100) primary key,
	MatKhau varchar(100),
	VaiTro varchar(20)
)

create table KhachHang(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(100),
	GioiTinh nvarchar(10),
	NgaySinh date,
	CCCD varchar(100),
	DiaChi nvarchar(100),
	SDT varchar(100)
)

create table Phong(
	SoPhong varchar(100) primary key,
	GiaPhong money,
	TinhTrang nvarchar(100),
	MaKH int,
	NgayDat dateTime,
	constraint FK_Phong_KhachHang foreign key(MaKH) references KhachHang(MaKH)
)

go
create table HoaDon(
	MaHD int identity(1,1) primary key,
	SoPhong varchar(100),
	MaKH int,
	NgayDat dateTime,
	NgayTra dateTime,
	ThanhTien money,
	GhiChu nvarchar(100),
	constraint FK_HoaDon_Phong foreign key(SoPhong) references Phong(SoPhong)
)

create table DanhGiaNV(
	MaDG int identity(1,1) primary key,
	DanhGia nvarchar(100),
	GhiChu nvarchar(100),
	MaNV varchar(100),
	foreign key (MaNV) references NhanVien(MaNV)
);

use QLKhachSan
go

insert into TaiKhoan values('admin', '12345', 'manager')

insert into NhanVien values('NV01', N'Trần Song Hào', N'Nam', N'Thanh Hóa', '0123456789', N'Sáng', 10000000, 3, N'Có mặt'),
							('NV02', N'Hà Quang Huy', N'Nam', N'Cần Thơ', '099999999', N'Tối', 900000000, 29, N'Vắng'),
							('NV03', N'Nguyễn Bá Khương', N'Nam', N'Nghệ An', '0888888888', N'Sáng', 15000000, 5, N'Có mặt'),
							('NV04', N'Nguyễn Trọng Nghĩa', N'Nam', N'Hà Nội', '0777777777', N'Tối', 17000000, 6, N'Vắng')

insert into KhachHang values(N'Nguyễn Văn A', N'Nam', '2023-01-27', '11111111', N'Thanh Hóa', '0123456789'),
							(N'Hoàng B', N'Nữ', '2023-01-27', '22222222', N'Thái Bình', '0123456788'),
							(N'Nguyễn C', N'Nữ', '2023-01-26', '33333333', N'Hưng Yên', '0123456787'),
							(N'Nguyễn D', N'Nam', '2023-01-26', '444444444', N'Hải Dương', '0123456786'),
							(N'Trịnh E', N'Nam', '2023-01-26', '555555555', N'Phú Thọ', '0123456785')

insert into Phong values('101', 100000, N'Trống', null, null),
						('102', 200000, N'Đã đặt', 1, '2023-02-25 20:30'),
						('201', 300000, N'Đã đặt', 2, '2023-02-26 21:30'),
						('202', 400000, N'Trống', null, null),
						('303', 500000, N'Đã đặt', 1, '2023-02-22 20:30')

insert into HoaDon values('101', 1, '2023-02-27 20:30', '2023-02-28 16:00', 1000000, null)