# JavaWeb_20220815
桃認 JavaWeb_20220815

# JSTL 標籤設定
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><br />
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><br />
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><br />
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %><br />
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %><br />

# 建立資料表
<pre>
-- user 資料表
create table if not exists user(
	id int not null auto_increment,
	username varchar(50) not null unique,
	password varchar(255) not null,
	salary varbinary(255) not null,
	createtime timestamp default current_timestamp,
	primary key (id)
);

-- book 資料表
create table if not exists book (
	id int not null auto_increment,
	name varchar(50) not null unique,
	amount int not null,
	price int not null,
	user_id int,
	primary key(id),
	foreign key(user_id) references user(id)
);
</pre>

