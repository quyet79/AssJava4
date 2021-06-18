create database assignmentJAVA4
go

use assignmentJAVA4 
go

create table Users(
	Id varchar(20) not null,
	Username varchar(30) null,
	Password varchar(30) null,
	Fullname nvarchar(50) null,  
	Role bit not null,
	constraint PK_Users primary key(Id)
)

create table Sanphams(
	Id varchar(20) not null,
	Tensanpham nvarchar(50) null,
	Giasanpham varchar(30) null,
	Hinhanh nvarchar(30) null,
	Mota nvarchar(max) null,
	constraint PK_Sanphams primary key(Id)
)
	
create table Favorites(
	Id bigint identity(1,1) not null,
	UserId varchar(20) not null,
	SanphamId varchar(20) not null,
	Likedate date,
	constraint PK_Favorites primary key(Id),
	constraint FK_Users_Favorites foreign key(UserId) references Users,
	constraint FK_Sanphams_Favorites foreign key(SanphamId) references Sanphams
)

create table Shares (
	Id bigint identity(1,1) not null,
	UserId varchar(20) not null,
	SanphamId varchar(20) not null,
	Email varchar(50) null,
	Sharedate date,
	constraint PK_Shares primary key(Id),
	constraint FK_Users_Shares foreign key(UserId) references Users,
	constraint FK_Sanphams_Shares foreign key(SanphamId) references Sanphams
)

insert into Users values('user04','admin','1999',N'Đào Đức Long',1)
insert into Users values('user01','ntdcoder','123ad',N'Nguyễn Thanh Đức',1)
insert into Users values('user02','namtcn','anamdt',N'Nguyễn Thành nam',0)
insert into Users values('user03','fcbacninh','99bacninh',N'Nguyễn Công Việt',0)
insert into Users values('user05','abczzz','111',N'Nguyễn Văn An',0 )


insert into Sanphams values('product1',N'Áo sơ mi ngắn tay BBR -DSQ','370,000 VND',N'anh1.jpg',N'Sơ mi ngắn tay màu trắng - sự lựa chọn hoàn hảo')
insert into Sanphams values('product2',N'Quần bò đen DSQUARED 2','580,000 VND',N'anh2.jpg',N'Quần bò đen ICON dễ mặc, dễ kết hợp với các loại áo')
insert into Sanphams values('product3',N'Áo phông tia chớp 2021','420,000 VND',N'anh3.jpg',N'')
insert into Sanphams values('product4',N'Áo phông Dior','390,000 VND',N'anh4.jpg','')
insert into Sanphams values('product5',N'Quần bò đen đính đá DSQ','600,000 VND',N'anh5.jpg','')
insert into Sanphams values('product6',N'Áo sơ mi dài tay BBR','510,000 VND',N'anh6.jpg','')
insert into Sanphams values('product7',N'Áo phông Fendi đen','380,000 VND',N'anh7.jpg','')
insert into Sanphams values('product8',N'Áo phông LV xanh họa tiết ','550,000 VND',N'anh8.jpg','')
insert into Sanphams values('product9',N'Áo sơ mi ngắn tay DSQ ','370,000 VND',N'anh9.jpg','')
insert into Sanphams values('product10',N'Áo sơ mi dài tay BBR xanh đen','390,000 VND',N'anh10.jpg','')
insert into Sanphams values('product11',N'Áo phông Emissary','620,000 VND',N'anh11.jpg','')
insert into Sanphams values('product12',N'Áo sơ mi dài tay trắng GUCCI','420,000 VND',N'anh12.jpg','')
insert into Sanphams values('product13',N'Áo phông VALENTINO','560,000 VND',N'anh13.jpg','')
insert into Sanphams values('product14',N'Áo phông đen Chaza họa tiết chìm','380,000 VND',N'anh14.jpg','')
insert into Sanphams values('product15',N'Áo phông đen LV ','350,000 VND',N'anh15.jpg','')
insert into Sanphams values('product16',N'Áo phông LV đen họa tiết chìm','530,000 VND',N'anh16.jpg','')
insert into Sanphams values('product17',N'Quần bò đen DSQ đính đá','600,000 VND',N'anh17.jpg','')
insert into Sanphams values('product18',N'Quần đùi bò vá CK','320,000 VND',N'anh18.jpg','')

insert into Favorites values('user02','product5','02/20/2021')
insert into Favorites values('user02','product11','01/05/2021')
insert into Favorites values('user03','product17','12/18/2020')
insert into Favorites values('user03','product5','03/11/2021')
insert into Favorites values('user03','product2','11/09/2020')

insert into Shares values('user02','product10','ducntph11994@fpt.edu.vn','02/10/2021')
insert into Shares values('user03','product2','ntdcoder@gmail.com','11/09/2020')
insert into Shares values('user03','product8','ntdcoder@gmail.com','1/22/2021')

alter table Users add constraint df_users_dob default 0 for Role

select * from Users 
select * from Sanphams
select * from Favorites 
select * from Shares

alter table Users add Email varchar(50)

update Users set Email = 'quyetnhph12037@fpt.edu.vn' where Id ='user01'
delete from Favorites where SanphamId='product9'

select * from Favorites where UserId='user03'

update Users set Email ='thanhduc29031999@gmail.com' where Id='user06'











