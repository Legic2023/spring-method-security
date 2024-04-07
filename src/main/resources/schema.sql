create schema sql_basic;

create table sql_basic.persons
(
    name           varchar(50),
    surname        varchar(70),
    phone_number   varchar(70),
    city_of_living varchar(20),
    age            int,
    PRIMARY KEY (name, surname, age)
);

insert into sql_basic.persons
values ('Ivan', 'Ivanov', '9105782455', 'Moscow', 30),
       ('alexey', 'Petrov', '9105782525', 'Saratov', 25),
       ('Ivan', 'Smirnov', '9105786725', 'Moscow', 68),
       ('Alexey', 'Ivanov', '9105787525', 'Tula', 41),
       ('Oleg', 'Ivanov', '9105782345', 'Moscow', 19);
