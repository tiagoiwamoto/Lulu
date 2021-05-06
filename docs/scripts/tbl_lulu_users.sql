create table tbl_lulu_users(
	id bigserial not null
		constraint tbl_lulu_users_pkey
			primary key,
	created_at timestamp,
	email varchar(255),
	name varchar(255),
	password varchar(255),
	status integer
);

alter table tbl_lulu_users owner to postgres;

