insert into role (id, name) values (10,'USER');
insert into user(user_id,enabled,password,username) values(1001,true,'alok@123','alok');
insert into user_roles (user_user_id, roles_id) values (1001,10);
