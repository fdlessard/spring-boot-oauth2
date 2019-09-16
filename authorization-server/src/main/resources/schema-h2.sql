DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id bigint not null,
    version bigint,
    username varchar(255) unique not null,
    password varchar(60),
    account_non_expired boolean default false,
    account_non_locked boolean default false,
    credentials_non_expired boolean default false,
    enabled boolean default false,
    primary key (id)
);
