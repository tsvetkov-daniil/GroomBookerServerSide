INSERT INTO roles VALUES
(DEFAULT, 'user'),
(DEFAULT, 'barber'),
(DEFAULT, 'moderator'),
(DEFAULT, 'admin');

INSERT INTO appointment_statuses(appointment_status_name) VALUES
('Активна'),
('Отменена клиентом'),
('Отменена салоном'),
('Запись пропущена'),
('Услуга оказана');
