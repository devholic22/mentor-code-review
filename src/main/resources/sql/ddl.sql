drop table if exists book cascade;
drop table if exists orders cascade;
create table book (
    cost integer,
    id bigint generated by default as identity,
    category varchar(255) not null check (category in ('DEVELOP','CULTURE','MONEY')),
    name varchar(255) not null unique,
    primary key (id)
);
create table orders (
    money integer,
    book_id bigint not null,
    created_at timestamp(6),
    id bigint generated by default as identity,
    updated_at timestamp(6),
    primary key (id)
);
create table payment (
    id bigint generated by default as identity,
    order_id bigint not null,
    payment_type varchar(255) check (payment_type in ('CARD','CASH')),
    primary key (id)
)

