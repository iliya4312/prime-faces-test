drop table customer cascade constraints;
create table customer(
  id number,
  name varchar2(1024),
  addr varchar2(1024)
);

drop table product cascade constraints;
create table product (
  serial varchar2(1024),
  name varchar2(1024),
  description clob,
  price number,
  manufactured timestamp(6)
);

drop table buy_order cascade constraints;
create table buy_order (
  id number,
  fk_customer number,
  total_price number,
  created timestamp(6)
);

drop table buy_order_detail cascade constraints;
create table buy_order_detail (
  position number,
  fk_product varchar2(1024),
  quantity number,
  fk_buy_order number
);

drop table app_settings cascade constraints;
create table app_settings (
  name varchar2(1024),
  value varchar2(1024),
  descr varchar2(1024)
);

alter table customer
add constraint customer_pk primary key (id) enable;

alter table product
add constraint product_pk primary key (serial) enable;

alter table buy_order
add constraint buy_order_pk primary key (id) enable;

alter table buy_order
add constraint fk_customer
foreign key (fk_customer)
references customer(id) enable;

alter table buy_order_detail
add constraint buy_order_detail_pk primary key (position, fk_buy_order) enable;

alter table buy_order_detail
add constraint fk_buy_order
foreign key (fk_buy_order)
references buy_order(id) enable;

alter table buy_order_detail
add constraint fk_product
foreign key (fk_product)
references product(serial) enable;

alter table app_settings
add constraint app_settings_pk primary key (name) enable;
