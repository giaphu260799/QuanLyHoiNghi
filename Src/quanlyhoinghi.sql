CREATE DATABASE QLHOINGHI;
USE QLHOINGHI;
CREATE TABLE HOI_NGHI
(
	id int NOT NULL AUTO_INCREMENT,
	ten varchar(45) NOT NULL,
	mo_ta_ngan varchar(255) NOT NULL,
	mo_ta_dai varchar(1000) NOT NULL,
	hinh_anh text NOT NULL,
	thoi_gian_bat_dau datetime NOT NULL,
    thoi_gian_ket_thuc datetime NOT NULL,
    dia_diem int NOT NULL,
    so_nguoi_tham_du int NOT NULL,
	primary key(id)
);
CREATE TABLE DIA_DIEM
(
	id int NOT NULL AUTO_INCREMENT,
	ten varchar(45) NOT NULL,
	dia_chi varchar(255) NOT NULL,
    suc_chua int NOT NULL,
	primary key(id)
);
CREATE TABLE TAI_KHOAN
(
	id int NOT NULL AUTO_INCREMENT,
    ten varchar(45) NOT NULL,
	username varchar(45) NOT NULL UNIQUE,
    pass varchar(45) NOT NULL,
    email varchar(45) NOT NULL,
    truy_cap boolean NOT NULL DEFAULT true,
	primary key(id)
);
CREATE TABLE YEU_CAU
(
	id int NOT NULL AUTO_INCREMENT,
	id_tk int NOT NULL,
    id_hn int NOT NULL,
    xac_nhan enum('Đồng ý','Không đồng ý','Đang chờ'),
	primary key(id)
);

ALTER TABLE HOI_NGHI ADD CONSTRAINT FK_HN_DD FOREIGN KEY (dia_diem) REFERENCES DIA_DIEM(id);

ALTER TABLE YEU_CAU ADD CONSTRAINT FK_YC_HN FOREIGN KEY (id_hn) REFERENCES HOI_NGHI(id);
ALTER TABLE YEU_CAU ADD CONSTRAINT FK_YC_TK FOREIGN KEY (id_tk) REFERENCES TAI_KHOAN(id);

INSERT INTO TAI_KHOAN VALUES(null,'Lai Gia Phú','tk1','c4ca4238a0b923820dcc509a6f75849b','tk1@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Đoàn Tấn Phúc','tk2','c81e728d9d4c2f636f067f89cc14862c','tk2@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Lưu Đặng Kỳ Quân','tk3','eccbc87e4b5ce2fe28308fd9f2a7baf3','tk3@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Vũ Quốc Khôi','tk4','a87ff679a2f3e71d9181a67b7542122c','tk4@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Phạm Linh Chi','tk5','e4da3b7fbbce2345d7772b0674a318d5','tk5@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Thị Minh Anh','tk6','1679091c5a880faf6fb5e6087eb1b2dc','tk6@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Việt Dũng','tk7','8f14e45fceea167a5a36dedd4bea2543','tk7@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Quốc Cường','tk8','c9f0f895fb98ab9159f51fd0297e236d','tk8@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Bùi Khổng Thiên','tk9','45c48cce2e2d7fbdea1afc51c7c6ad26','tk9@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Ngô Ngọc Thiên Ngân','tk10','d3d9446802a44259755d38e6d163e820','tk10@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Trần Thảo Quỳnh','tk11','6512bd43d9caa6e02c990b0a82652dca','tk11@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Vương Hà My','tk12','c20ad4d76fe97759aa27a0c99bff6710','tk12@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Hà Vy Xuân','tk13','c51ce410c124a10e0db5e4b97fc2af39','tk13@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Đinh Quý Trí Thông','tk14','aab3238922bcc25a6f606eb525ffdc56','tk14@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Ngô Hồng Văn','tk15','9bf31c7ff062936a96d3c8bd1f8f2ff3','tk15@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Hồng Đức','tk16','c74d97b01eae257e44aa9d5bade97baf','tk16@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Lê Ngọc Khiêm','tk17','70efdf2ec9b086079795c442636b55fb','tk17@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Chu Lê','tk18','6f4922f45568161a8cdf4ad2299f6d23','tk18@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Nguyễn Quang Thái Dương','tk19','1f0e3dad99908345f7439f8ffabdffc4','tk19@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Lê Huỳnh Long','tk20','98f13708210194c475687be6106a3b84','tk20@gmail.com',true);
INSERT INTO TAI_KHOAN VALUES(null,'Lê Văn Boss','admin','c4ca4238a0b923820dcc509a6f75849b','admindeptrai@gmail.com',true);

INSERT INTO DIA_DIEM VALUES(null,'ĐH KHTN CS2','227 Nguyễn Văn Cừ',10);
INSERT INTO DIA_DIEM VALUES(null,'ĐH KHTN CS1','Làng Đại Học',10);
INSERT INTO DIA_DIEM VALUES(null,'Nhà Văn Hóa Sinh Viên','Làng Đại Học',20);

INSERT INTO HOI_NGHI VALUES(null,'Khoa học về Công nghệ thông tin','Dành cho người thích công nghệ','Dành cho người thích công nghệ, hội nghị là nơi giao lưu ...','src/qlhoinghi/image/it.jpg','2020-08-20 09:00:00','2020-08-20 12:00:00',1,10);
INSERT INTO HOI_NGHI VALUES(null,'Robot','Hội nghị giao lưu sản phẩm robot','Hội nghị giao lưu sản phẩm robot là nơi ...','src/qlhoinghi/image/robot.jpg','2020-08-20 09:00:00','2020-08-20 12:00:00',2,10);
INSERT INTO HOI_NGHI VALUES(null,'Công nghệ sinh học','Dành cho người thích sinh học','Dành cho người thích sinh học giao lưu ...','src/qlhoinghi/image/biotechnology.jpg','2020-08-26 13:00:00','2020-08-26 17:00:00',3,2);

INSERT INTO YEU_CAU VALUES(null,1,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,3,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,5,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,7,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,9,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,12,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,14,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,16,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,18,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,20,1,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,2,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,4,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,6,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,8,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,10,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,11,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,13,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,15,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,17,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,19,2,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,2,3,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,4,3,'Đồng ý');
INSERT INTO YEU_CAU VALUES(null,6,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,8,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,10,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,11,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,13,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,15,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,17,3,'Đang chờ');
INSERT INTO YEU_CAU VALUES(null,19,3,'Đang chờ');