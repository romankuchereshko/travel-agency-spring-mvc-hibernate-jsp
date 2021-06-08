insert into countries (name) values ('GERMANY');
insert into countries (name) values ('POLAND');
insert into countries (name) values ('UKRAINE');

insert into hotels (hotel_name, type, rate, wifi, pool, pets, smoking, country_id) values ('Grand Hotel Tremezzo', 'HOTEL', 5, true, true, true, false, 1);
insert into hotels (hotel_name, type, rate, wifi, pool, pets, smoking, country_id) values ('Mandarin Oriental', 'HOTEL', 5, true, false, true, false, 2);
insert into hotels (hotel_name, type, rate, wifi, pool, pets, smoking, country_id) values ('InterContinental', 'HOTEL', 4, true, false, true, true, 3);

insert into users (name, email, password, status, role) values ('admin', 'admin@gmail.com', '$2y$12$6wWu.bjCJegev7tg3l0R9.ZUxKbMyIA2HsMkOwmrT4CnQ75ldJhN6', 'ACTIVE', 'ADMIN');
insert into users (name, email, password, status, role) values ('Nora', 'nora@gmail.com', '$2y$12$2bu5olbBfNziKL2DEg6Dj.WvdKD35uUjaD4CmJvplsBT.C3N6VtCy', 'ACTIVE', 'USER');
insert into users (name, email, password, status, role) values ('Mike', 'mike@gmail.com', '$2y$12$2bu5olbBfNziKL2DEg6Dj.WvdKD35uUjaD4CmJvplsBT.C3N6VtCy', 'ACTIVE', 'USER');

insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (100, 3, 'LARGE_DOUBLE', 1);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (80, 2, 'TWIN', 1);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (75, 2, 'DOUBLE', 1);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (70, 1, 'SINGLE', 1);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (90, 3, 'LARGE_DOUBLE', 2);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (80, 2, 'TWIN', 2);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (85, 2, 'DOUBLE', 2);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (70, 1, 'SINGLE', 2);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (75, 2, 'DOUBLE', 3);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (70, 2, 'TWIN', 3);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (60, 1, 'SINGLE', 3);
insert into rooms (room_price, guests_count, bed_preference, hotel_id) values (60, 1, 'SINGLE', 3);

insert into bookings (checkin, checkout, room_id, user_id) values ('2021-06-11', '2021-06-13', 4, 1);
insert into bookings (checkin, checkout, room_id, user_id) values ('2021-06-07', '2021-06-08', 7, 2);
insert into bookings (checkin, checkout, room_id, user_id) values ('2021-06-07', '2021-06-08', 5, 3);
