-- liquibase formatted sql

-- changeset surokkha:1689277528-1
create
extension if not exists "uuid-ossp";

-- changeset surokkha:1689277528-2
create table public."notification"
(
    id                   varchar(255) not null,
    email                varchar(255) not null,
    message            varchar(255) not null,
    time                      timestamp not null ,
    constraint pk_notification primary key (id)
);