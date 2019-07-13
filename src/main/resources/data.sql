insert into t_owner(id, first_name, last_name)
values (1, 'Muhammed', 'Demir');
insert into t_owner(id, first_name, last_name)
values (2, 'Yunus', 'Delibaş');
insert into t_owner(id, first_name, last_name)
values (3, 'Ahmet', 'Şeker');

insert into t_pet(id, name, birth_date, owner_id)
values (1, 'dog', '2019-09-07', 1);

insert into users
values ('user1', '{bcrypt}$2a$10$2V1SZ/3Fi7fKfdNNInjRtOe8Wc4t4bJ2FDsxVf7f5keK5VXU7jmLi', true);
insert into users
values ('user2', '{bcrypt}$2a$10$OF..v4cGPljtpkrx22rQCenb964NhunrOhEytZ8D2OPhqX74ySNZm', true);
insert into users
values ('user3', '{bcrypt}$2a$10$slmc4nW.tN3pePOjRwrRz.LpiaRHptRaQ4sWFFpfw8r6BhBKbFSVm', true);

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
