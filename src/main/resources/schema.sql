create table comment
(
	id int auto_increment
		primary key,
	post_id int not null,
	user_id int not null,
	text varchar(500) null,
	constraint comment_post_id_fk
		foreign key (post_id) references post (id),
	constraint comment_user_id_fk
		foreign key (user_id) references user (id)
);

create table tag
(
	id int auto_increment
		primary key,
	name varchar(20) not null
);

create table user
(
	id int auto_increment
		primary key,
	name varchar(30) not null
);

create table post
(
	id int auto_increment
		primary key,
	title varchar(200) not null,
	text text not null,
	user_id int not null,
	constraint USER_ID_FOREIGN_KEY
		foreign key (user_id) references user (id)
);

create table post_tag
(
	id int auto_increment
		primary key,
	post_id int null,
	tag_id int null,
	constraint post_tag_post_id_fk
		foreign key (post_id) references post (id),
	constraint post_tag_tag_id_fk
		foreign key (tag_id) references tag (id)
);

