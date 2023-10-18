CREATE TABLE manufacturers ();
ALTER TABLE manufacturers ADD id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY;
ALTER TABLE manufacturers ADD name VARCHAR(255) NOT NULL;
ALTER TABLE manufacturers ADD country_origin VARCHAR(255);
ALTER TABLE manufacturers ADD description VARCHAR(255);
alter table if exists products add column manufacturer_id int8;
alter table if exists products add constraint FKljnead8q1652k9q5p0fe0o1g2 foreign key (manufacturer_id) references manufacturers;