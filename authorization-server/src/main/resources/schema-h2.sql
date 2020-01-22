DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id bigint not null,
    version int,
    username varchar(255) unique not null,
    password varchar(60),
    account_non_expired boolean default false,
    account_non_locked boolean default false,
    credentials_non_expired boolean default false,
    enabled boolean default false,
    primary key (id)
);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    id bigint not null,
    version int,
    user_id bigint not null,
    authority varchar(25) not null,
    primary key (id),
    constraint fk_user_id foreign key (user_id) references user(id)
);

