drop table if exists cat cascade;
create table cat (
	id integer primary key auto_increment, 
	evil boolean not null,
	has_whiskers boolean not null,
	length integer, 
	name varchar(255)
);