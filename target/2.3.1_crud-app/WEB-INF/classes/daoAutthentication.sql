create table users (
    id bigint auto_increment primary key,
    username varchar(30) not null,
    password varchar(80) not null,
    email varchar(50) unique
);

create table roles (
    id bigint auto_increment primary key,
    name varchar(50) not null
);

create table users_roles (
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

insert into users(username, password, email) values ('user', '$2a$12$NSN/1Q.i/b7LDf0rcv2ssekXUUXYHDb/9docYLzEp6niPCXYxGr7.', 'user@mail.ru');
insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');
insert into users_roles(user_id, role_id) values (1,2);

insert into users(username, password, department, salary) values ('admin', '$2a$12$0KIiB1cQ1A/IDbM6HObMPeUEMUCgWIoYqBYGvqjnVJ9Ed1Kydn1om', 'IT', 500);
insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');
insert into users_roles(user_id, role_id) values (1,2);

update users set password='{bcrypt}$2a$12$pDOfl1ZyiF6q4CVkhlxZluuIcn/MVcEUI90y9AMDB2.uMgbRSK8Fe' where id=1;
# update users set password='100' where id=1;
