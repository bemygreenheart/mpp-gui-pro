-- Inserting address
insert into address(id, street, city, state, zip) values(1001, '1000 N', 'Fairfield', 'Iowa', '52557');
insert into address(id, street, city, state, zip) values(1002, 'Ocean Blvd', 'Hampton', 'New Hampshire', '15223');
insert into address(id, street, city, state, zip) values(1003, 'Bolton', 'New Mexico', 'Orlanda', '10010');

-- Insert into person
insert into person(id, first_name, last_name, phone, address_id) values(2001, 'John', 'Doe', '1234567', 1001);
insert into person(id, first_name, last_name, phone, address_id) values(2002, 'Ashly', 'Young', '2345678', 1001);
insert into person(id, first_name, last_name, phone, address_id) values(2003, 'Kim', 'Newman', '3456789', 1002);
insert into person(id, first_name, last_name, phone, address_id) values(2004, 'George', 'Bush', '4567890', 1002);
insert into person(id, first_name, last_name, phone, address_id) values(2005, 'Donald', 'Trump', '5678901', 1002);
insert into person(id, first_name, last_name, phone, address_id) values(2006, 'Escobar', 'Pablo', '6789012', 1003);

-- Insert into book
insert into book(id, isbn, title, max_checkout_length) values(3001, 'AB121', 'Dark Moon', 21);
insert into book(id, isbn, title, max_checkout_length) values(3002, 'AB122', 'Dark Moon', 21);
insert into book(id, isbn, title, max_checkout_length) values(3003, 'AB123', 'Dark Moon', 21);
insert into book(id, isbn, title, max_checkout_length) values(3004, 'AB124', 'Dark Moon', 7);

-- Insert into authors
insert into author(id, bio, book_id, person_id) values(4001, 'Nothing special', 3001, 2001);
insert into author(id, bio, book_id, person_id) values(4002, 'Very talented but arrogant', 3002, 2002);
insert into author(id, bio, book_id, person_id) values(4003, 'Nothing special', 3003, 2003);

-- Inserting into book_copy
insert into book_copy(copy_num, book_id, is_available) values(5001, 3001,true);
insert into book_copy(copy_num, book_id, is_available) values(5002, 3001,true);
insert into book_copy(copy_num, book_id, is_available) values(5003, 3001,true);
insert into book_copy(copy_num, book_id, is_available) values(5004, 3002,true);
insert into book_copy(copy_num, book_id, is_available) values(5005, 3002,true);
insert into book_copy(copy_num, book_id, is_available) values(5006, 3003,true);
insert into book_copy(copy_num, book_id, is_available) values(5007, 3004,true);
insert into book_copy(copy_num, book_id, is_available) values(5008, 3004,true);

-- Insert into user
insert into users(member_id, password, role, person_id) values(1111, 'admin', 'ADMIN', 2004);
insert into users(member_id, password, role, person_id) values(2222, 'lib', 'LIBRARIAN', 2005);
insert into users(member_id, password, role, person_id) values(3333, 'nothing', null, 2006);

-- Insert insert checkout_entry
insert into checkout_entry(id, checkout_date, due_date, return_date, user_id, copy_id) values(7001, '2020-07-10', '2020-07-31', '2020-07-28', 3333, 5001);
insert into checkout_entry(id, checkout_date, due_date, return_date, user_id, copy_id) values(7002, '2021-07-10', '2021-07-31', '2021-07-28', 3333, 5004);
insert into checkout_entry(id, checkout_date, due_date, return_date, user_id, copy_id) values(7003, '2022-07-10', '2022-07-31', '2022-07-28', 3333, 5007);

