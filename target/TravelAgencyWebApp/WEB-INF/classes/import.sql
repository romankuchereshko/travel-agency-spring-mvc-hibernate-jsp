INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');

INSERT INTO hotels (id, hotel_name, country) VALUES (1, 'Grand Hotel Tremezzo', 'GERMANY');
INSERT INTO hotels (id, hotel_name, country) VALUES (2, 'Mandarin Oriental', 'POLAND');
INSERT INTO hotels (id, hotel_name, country) VALUES (3, 'InterContinental', 'UKRAINE');

INSERT INTO users (id, name, email, password, role_id) VALUES (5, 'Nick', 'nick@mail.com', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC', 1);
INSERT INTO users (id, name, email, password, role_id) VALUES (6, 'Nora', 'nora@mail.com', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy', 2);
INSERT INTO users (id, name, email, password, role_id) VALUES (4, 'Mike', 'mike@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);

INSERT INTO rooms (id, is_available, guest_id) VALUES (1, false, 4);
INSERT INTO rooms (id, is_available, guest_id) VALUES (2, false, 5);
INSERT INTO rooms (id, is_available, guest_id) VALUES (3, false, 6);
INSERT INTO rooms (id, is_available, guest_id) VALUES (4, true, null);
INSERT INTO rooms (id, is_available, guest_id) VALUES (5, true, null);
INSERT INTO rooms (id, is_available, guest_id) VALUES (6, true, null);

INSERT INTO bookings (id, arrival, checkout, room_id, user_id, hotel_id) VALUES (123, '2021-05-11', '2021-05-13', 1, 4, 1);
INSERT INTO bookings (id, arrival, checkout, room_id, user_id, hotel_id) VALUES (456, '2021-05-07', '2021-05-08', 2, 5, 3);
INSERT INTO bookings (id, arrival, checkout, room_id, user_id, hotel_id) VALUES (789, '2021-05-13', '2021-05-17', 3, 6, 1);