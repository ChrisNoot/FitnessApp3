create table if not exists user_table (
        id identity,
        name varchar(50) not null,
        address varchar(50) not null,
        email varchar(50) not null,
        dateOfBirth varchar(50) not null,
        createdAt varchar(50) not null,
        weight varchar(50) not null,
        length varchar(50) not null
);