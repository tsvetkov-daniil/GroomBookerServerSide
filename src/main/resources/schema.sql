create table if not exists tokens (
token text primary key,
is_active boolean not null,

constraint CH_token CHECK (token ~ '^[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+\.[A-Za-z0-9_-]+$')
);

create table if not exists user_info (
user_info_id serial primary key,
first_name varchar(15) not null,
middle_name varchar(15) not null,
phone_number varchar(12) not null unique,
email varchar(20) not null unique,

constraint CK_phone_number check (phone_number ~ '^\+[0-9]{11}'),
constraint CK_email check(email ~ '^(?!.*\.\.)^(?!.*\_\_)(?!^[._])(?!.*[._]$)[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
);

create table if not exists roles (
role_id serial primary key,
role_name varchar(20) not null unique
);

create table if not exists guests (
guest_id serial primary key,
user_info_id integer not null,
foreign key (user_info_id)  references user_info(user_info_id)
);

create table if not exists users (
user_id serial primary key,
user_info_id integer not null unique,
password varchar(15) not null,
role_id integer not null,
foreign key (user_info_id) references user_info(user_info_id),
foreign key (role_id) references roles(role_id)
);

create table if not exists barber_grades (
barber_grade_id serial primary key,
grade_name varchar(20) not null unique
);

create table if not exists barbers (
barber_id integer primary key,
barber_info varchar(1000),
barber_grade_id integer not null,

foreign key (barber_grade_id) references barber_grades(barber_grade_id),
foreign key (barber_id) references users(user_id)
);

create table if not exists moderator (
moderator_id integer primary key,
foreign key(moderator_id) references users(user_id)
);

create table if not exists branches (
branch_id serial primary key,
abress varchar(40) not null unique,
work_start_time time not null,
work_end_time time not null,
latitude decimal(9,6) not null,
longitude decimal(9,6) not null
);


create table if not exists shifts (
shift_id serial primary key,
shift_date date not null,
barber_id integer not null,
work_start_time time not null,
work_end_time time not null,
branch_id integer not null,

foreign key (barber_id) references barbers(barber_id),
foreign key (branch_id) references branches(branch_id)
);

create table if not exists appointment_statuses (
appointment_status_id serial primary key,
appointment_status varchar(15) not null unique
);


create table if not exists appointments (
appointment_id serial primary key,
guest_id integer,
user_id integer,
shift_id integer not null,
appointment_status_id integer not null,
appointment_time time not null,

foreign key (guest_id) references guests(guest_id),
foreign key (user_id) references users(user_id),
foreign key (shift_id) references shifts(shift_id),

constraint  CH_user_guest check (
(guest_id is null and user_id is not null )  or
(user_id is null and guest_id is not null))
);

create table if not exists services (
service_id serial primary key,
service_name varchar(25) not null unique,
duration smallint not null
);

create table if not exists appointment_service (
service_id integer not null,
appointment_id integer not null,

foreign key (service_id) references services(service_id),
foreign key (appointment_id) references appointments(appointment_id),

primary  key(service_id,appointment_id)
);

create table if not exists service_cost (
service_id integer,
barber_grade_id integer,
cost money not null,

primary key(service_id, barber_grade_id)
)

