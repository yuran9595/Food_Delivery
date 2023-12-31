create table orders (id bigint generated by default as identity, order_amount double precision, day_of_payment TIMESTAMP WITHOUT TIME ZONE,
  date_of_delivery TIMESTAMP WITHOUT TIME ZONE, forms_of_payments varchar(255),primary key (id));
alter table if exists baskets add constraint FK_order_basket foreign key (order_id) references orders;