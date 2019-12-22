
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
    dayOfWeek varchar(25) not null,
    hourTime varchar(25) not null
);

create table if not exists group_user (
    groupId bigint not null,
    userId bigint not null
);

alter table group_user
    add foreign key (groupId) references groupTable(id);
alter table group_user
    add foreign key (userId) references userTable(id);

insert into groupTable (id,createdAt,dayOfweek,hourTime) values (154, CURRENT_DATE,'MONDAY','19:00');
insert into groupTable (id,createdAt,dayOfweek,hourTime) values (155, CURRENT_DATE,'TUESDAY','18:00');
insert into groupTable (id,createdAt,dayOfweek,hourTime) values (156, CURRENT_DATE,'TUESDAY','19:00');
insert into groupTable (id,createdAt,dayOfweek,hourTime) values (157, CURRENT_DATE,'TUESDAY','20:00');
insert into groupTable (id,createdAt,dayOfweek,hourTime) values (158, CURRENT_DATE,'WEDNESDAY','20:00');
