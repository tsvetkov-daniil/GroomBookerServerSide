CREATE TABLE IF NOT EXISTS public.tokens (
    token TEXT PRIMARY KEY,
    is_active BOOLEAN NOT NULL,
    CONSTRAINT ch_token CHECK (token ~ '^[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+$')
);

CREATE TABLE IF NOT EXISTS public.user_info (
    user_info_id SERIAL PRIMARY KEY,
    first_name VARCHAR(15) NOT NULL,
    middle_name VARCHAR(15) NOT NULL,
    phone_number VARCHAR(12) NOT NULL UNIQUE,
    email VARCHAR(20) NOT NULL UNIQUE,
    CONSTRAINT ck_phone_number CHECK (phone_number ~ '^\+[0-9]{11}'),
    CONSTRAINT ck_email CHECK (email ~ '^(?!.*\.\.)(?!.*\_\_)(?!^[._])(?!.*[._]$)[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
);

CREATE TABLE IF NOT EXISTS public.roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.guests (
    guest_id SERIAL PRIMARY KEY,
    user_info_id INTEGER NOT NULL,
    FOREIGN KEY (user_info_id) REFERENCES user_info(user_info_id)
);

CREATE TABLE IF NOT EXISTS public.app_users (
    user_id SERIAL PRIMARY KEY,
    user_info_id INTEGER NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_info_id) REFERENCES user_info(user_info_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE IF NOT EXISTS public.barber_grades (
    barber_grade_id SERIAL PRIMARY KEY,
    grade_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.barbers (
    barber_id INTEGER PRIMARY KEY,
    barber_info VARCHAR(1000),
    barber_grade_id INTEGER NOT NULL,
    FOREIGN KEY (barber_grade_id) REFERENCES barber_grades(barber_grade_id),
    FOREIGN KEY (barber_id) REFERENCES app_users(user_id)
);

CREATE TABLE IF NOT EXISTS public.moderators (
    moderator_id INTEGER PRIMARY KEY,
    FOREIGN KEY (moderator_id) REFERENCES app_users(user_id)
);

CREATE TABLE IF NOT EXISTS public.branches (
    branch_id SERIAL PRIMARY KEY,
    address VARCHAR(40) NOT NULL UNIQUE,
    work_start_time TIME NOT NULL,
    work_end_time TIME NOT NULL,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.shifts (
    shift_id SERIAL PRIMARY KEY,
    shift_date DATE NOT NULL,
    barber_id INTEGER NOT NULL,
    work_start_time TIME NOT NULL,
    work_end_time TIME NOT NULL,
    branch_id INTEGER NOT NULL,
    FOREIGN KEY (barber_id) REFERENCES barbers(barber_id),
    FOREIGN KEY (branch_id) REFERENCES branches(branch_id)
);

CREATE TABLE IF NOT EXISTS public.appointment_statuses (
    appointment_status_id SERIAL PRIMARY KEY,
    appointment_status_name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.appointments (
    appointment_id SERIAL PRIMARY KEY,
    guest_id INTEGER,
    user_id INTEGER,
    shift_id INTEGER NOT NULL,
    appointment_status_id INTEGER NOT NULL,
    appointment_time TIME NOT NULL,
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id),
    FOREIGN KEY (user_id) REFERENCES app_users(user_id),
    FOREIGN KEY (shift_id) REFERENCES shifts(shift_id),
    CONSTRAINT ch_user_guest CHECK (
        (guest_id IS NULL AND user_id IS NOT NULL) OR
        (user_id IS NULL AND guest_id IS NOT NULL)
    )
);

CREATE TABLE IF NOT EXISTS public.services (
    service_id SERIAL PRIMARY KEY,
    service_name VARCHAR(25) NOT NULL UNIQUE,
    duration SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS public.appointment_services (
    service_id INTEGER NOT NULL,
    appointment_id INTEGER NOT NULL,
    FOREIGN KEY (service_id) REFERENCES services(service_id),
    FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id),
    PRIMARY KEY (service_id, appointment_id)
);

CREATE TABLE IF NOT EXISTS public.service_costs (
    service_id INTEGER,
    barber_grade_id INTEGER,
    service_cost MONEY NOT NULL,
    FOREIGN KEY (service_id) REFERENCES services(service_id),
    FOREIGN KEY (barber_grade_id) REFERENCES barber_grades(barber_grade_id),
    PRIMARY KEY (service_id, barber_grade_id)
);
