use belajar_spring_restfull_api;

create table users
(
    username varchar(100) not null ,
    password varchar(100) not null ,
    name varchar(100) not null ,
    token varchar(100),
    token_expired_at BIGINT,
    primary key (username),
    unique (token)
)engine innoDB;

select * from users;

desc users;

create table contacts(
    id varchar(100) not null ,
    username varchar(100) not null,
    first_name varchar(100) not null,
    last_name varchar(100),
    phone varchar(100),
    email varchar(100),
    primary key (id),
    foreign key fk_users_contacs (username) references users (username)
)Engine InnoDB;

select  * from contacts;

delete from users;

desc contacts;

create table adresses(
    id varchar(100) not null ,
    contact_id varchar(100) not null ,
    street varchar(100),
    city varchar(100),
    province varchar(100),
    country varchar(100) not null ,
    postal_code varchar(20) ,
    primary key (id),
    foreign key fk_contacts_adresses (contact_id) references contacts(id)
)ENGINE InnoDB;

select  * from adresses;

desc adresses;

