create table tbl_lulu_medications
(
	id bigserial not null
		constraint tbl_lulu_medications_pkey
			primary key,
	action_mechanism varchar(999),
	against_indication varchar(999),
	commercial_name varchar(255),
	function varchar(999),
	recommendation varchar(999),
	reference varchar(999),
	status integer,
	created_at timestamp,
	stock integer
);

alter table tbl_lulu_medications owner to postgres;

