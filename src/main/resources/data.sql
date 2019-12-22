
create table if not exists userTable (
    id bigint not null,
    createdAt varchar(25) not null,
    naam varchar(25) not null,
    gebruikersnaam varchar(25) not null,
    gewicht varchar(25),
    lengte varchar(25),
    geboortedatum varchar(25) not null,
    email varchar(25) not null,
    telefoon varchar(25) not null
);

create table if not exists groupTable (
    id bigint not null,
    createdAt varchar(25) not null,
    dag varchar(25) not null,
    tijd varchar(25) not null
);

create table if not exists group_user (
    group1 bigint not null,
    user1 bigint not null
);

alter table group_user
    add foreign key (group1) references groupTable(id);
alter table group_user
    add foreign key (user1) references userTable(id);