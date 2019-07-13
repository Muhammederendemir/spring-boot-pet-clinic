insert into t_owner(id, first_name, last_name)
values (1, 'Muhammed', 'Demir');
insert into t_owner(id, first_name, last_name)
values (2, 'Yunus', 'Delibaş');
insert into t_owner(id, first_name, last_name)
values (3, 'Ahmet', 'Şeker');

insert into t_pet(id, name, birth_date, owner_id)
values (1, 'dog', '2019-09-07', 1);

insert into users
values ('user1', '{noop}secret', true);
insert into users
values ('user2', '{noop}secret', true);
insert into users
values ('user3', '{noop}secret', true);

insert into authorities
values ('user1', 'ROLE_USER');
insert into authorities
values ('user2', 'ROLE_USER');
insert into authorities
values ('user2', 'ROLE_EDITOR');
insert into authorities
values ('user3', 'ROLE_USER');
insert into authorities
values ('user3', 'ROLE_EDITOR');
insert into authorities
values ('user3', 'ROLE_ADMIN');
