-- 建立 user 資料表
create table if not exists user(
	id int not null auto_increment,
	username varchar(50) not null unique,
	password varchar(255) not null,
	salary varchar(255) not null,
	createtime timestamp default current_timestamp,
	
);