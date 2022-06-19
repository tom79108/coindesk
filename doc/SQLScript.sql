-- create table
create table coindeskdata (
	coinname varchar(10) not null,
	coincname varchar(20) not null,
	lastupdatedate TIMESTAMP(0) not null default current_timestamp,
	rate varchar(20) not null, primary key (coinname)
)

