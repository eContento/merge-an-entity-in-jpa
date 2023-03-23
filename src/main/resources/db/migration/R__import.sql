-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into store (store_code, creation_date) values (55555, '2023-03-02T01:02:03.987654');

insert into services_by_store (store_code, service_code, creation_date) values (55555, 1, '2023-03-02T01:02:03.987654');
insert into services_by_store (store_code, service_code, creation_date) values (55555, 2, '2023-03-02T01:02:03.987654');
insert into services_by_store (store_code, service_code, creation_date) values (55555, 3, '2023-03-02T01:02:03.987654');