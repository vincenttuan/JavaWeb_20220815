-- cart 資料表
create table if not exists cart (
	id int not null auto_increment,
	user_id int not null,
	book_id int not null,
	qty int not null,
	subtotal int not null,
	createtime timestamp default current_timestamp,
	primary key(id),
	foreign key(user_id) references user(id),
	foreign key(book_id) references book(id)
);