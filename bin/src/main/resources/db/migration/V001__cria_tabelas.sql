create table state (
    id bigint(20) primary key auto_increment,
    name varchar(30) not null
) engine=InnoDB default charset=utf8;

create table city (
    id bigint(20) primary key auto_increment,
    name varchar(30) not null,
    state_id bigint(20) not null
) engine=InnoDB default charset=utf8;

create table people (
    id bigint(20) primary key auto_increment,
    first_name varchar(30) not null,
    last_name varchar(70) not null,
    cpf varchar(11) unique not null,
    birth_date Date not null,
    address_address1 varchar(150),
    address_address2 varchar(100),
    address_number varchar(5),
    address_district varchar(60),
    address_zip_code varchar(10),
    address_city_id bigint(20) not null
) engine=InnoDB default charset=utf8;

create table phone (
    id bigint(20) primary key auto_increment,
    type varchar(20) not null,
    number varchar(13) not null,
    people_id bigint(20) not null
) engine=InnoDB default charset=utf8;

alter table phone add constraint fk_phone_id
foreign key (people_id) references people (id);

alter table people add constraint fk_address_city
foreign key (address_city_id) references city (id);