set foreign_key_checks = 0;

delete from people;
delete from phone;
delete from city;
delete from state;

set foreign_key_checks = 1;

alter table people auto_increment = 1;
alter table phone auto_increment = 1;
alter table city auto_increment = 1;
alter table state auto_increment = 1;

insert into state (name) values ('Acre');
insert into state (name) values ('Alagoas');
insert into state (name) values ('Amazonas');
insert into state (name) values ('Amapá');
insert into state (name) values ('Bahia');
insert into state (name) values ('Ceará');
insert into state (name) values ('Distrito Federal');
insert into state (name) values ('Espírito Santo');
insert into state (name) values ('Goiás');
insert into state (name) values ('Maranhão');
insert into state (name) values ('Minas Gerais');
insert into state (name) values ('Mato Grosso do Sul');
insert into state (name) values ('Mato Grosso');
insert into state (name) values ('Pará');
insert into state (name) values ('Paraíba');
insert into state (name) values ('Pernambuco');
insert into state (name) values ('Piauí');
insert into state (name) values ('Paraná');
insert into state (name) values ('Rio de Janeiro');
insert into state (name) values ('Rio Grande do Norte');
insert into state (name) values ('Rondônia');
insert into state (name) values ('Roraima');
insert into state (name) values ('Rio Grande do Sul');
insert into state (name) values ('Santa Catarina');
insert into state (name) values ('Sergipe');
insert into state (name) values ('São Paulo');
insert into state (name) values ('Tocantins');

insert into city (name, state_id) values ('Belo Horizonte', 11);
insert into city (name, state_id) values ('Uberlândia', 11);
insert into city (name, state_id) values ('Uberaba', 11);
insert into city (name, state_id) values ('Teófilo Otoni', 11);
insert into city (name, state_id) values ('São Paulo', 26);
insert into city (name, state_id) values ('Guarulhos', 26);
insert into city (name, state_id) values ('Campinas', 26);
insert into city (name, state_id) values ('Rio de Janeiro', 19);
insert into city (name, state_id) values ('Angra dos Reis', 19);
insert into city (name, state_id) values ('Goiânia', 9);
insert into city (name, state_id) values ('Caldas Novas', 9);
insert into city (name, state_id) values ('Rio Branco', 1);
insert into city (name, state_id) values ('Maceió', 2);
insert into city (name, state_id) values ('Manaus', 3);
insert into city (name, state_id) values ('Macapá', 4);
insert into city (name, state_id) values ('Salvador', 5);
insert into city (name, state_id) values ('Fortaleza', 6);
insert into city (name, state_id) values ('Brasilia', 7);
insert into city (name, state_id) values ('Vitória', 8);
insert into city (name, state_id) values ('São Luiz', 10);
insert into city (name, state_id) values ('Campo Grande', 12);
insert into city (name, state_id) values ('Belém', 13);
insert into city (name, state_id) values ('João Pessoa', 14);
insert into city (name, state_id) values ('Recife', 15);
insert into city (name, state_id) values ('Teresina', 16);
insert into city (name, state_id) values ('Curitiba', 17);
insert into city (name, state_id) values ('Natal', 20);
insert into city (name, state_id) values ('Porto Velho', 21);
insert into city (name, state_id) values ('Boa Vista', 22);
insert into city (name, state_id) values ('Porto Alegre', 23);
insert into city (name, state_id) values ('Florianópolis', 24);
insert into city (name, state_id) values ('Aracajú', 25);
insert into city (name, state_id) values ('Palmas', 27);

insert into people (first_name, last_name, cpf, birth_date, address_address1, address_number, address_district, address_zip_code, address_city_id) values ('Ricardo', 'Dias', '22222222222', '1992-05-12', 'Rua das Flores', '25', 'Jardim Camargos', '07142-223', 5);

insert into phone (type, number, people_id) values ('MOBILE', '11 99999-9999', 1);


