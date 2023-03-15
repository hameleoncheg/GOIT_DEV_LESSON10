INSERT INTO client (name) VALUES
('Max'),
('Ivan'),
('Markus'),
('Oleh'),
('Mark'),
('Vanya'),
('Olexander'),
('Bogdancheg'),
('Nadya'),
('Borislav');

INSERT INTO planet (id, name) VALUES
('MERC', 'Mercury'),
('VEN', 'Venus'),
('ER', 'Eris'),
('MARS', 'Mars'),
('JUP', 'Jupiter'),
('CER', 'Ceres');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MERC', 'VEN'),
(2, 'ER', 'MARS'),
(3, 'JUP', 'CER'),
(4, 'MERC', 'CER'),
(5, 'VEN', 'JUP'),
(6, 'ER', 'MARS'),
(7, 'MERC', 'JUP'),
(8, 'CER', 'ER'),
(9, 'ER', 'VEN'),
(10, 'VEN', 'JUP');

