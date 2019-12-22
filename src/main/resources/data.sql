create table if not exists userTable (
    id varchar(25) not null,
    createdAt varchar(25) not null,
    naam varchar(25) not null,
    gebruikersnaam varchar(25) not null,
    gewicht varchar(25),
    lengte varchar(25),
    geboortedatum varchar(25) not null,
    email varchar(25) not null,
    telefoon varchar(25) not null
);

