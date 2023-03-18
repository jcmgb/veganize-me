USE veganizer;
CREATE TABLE recipes
(
    id bigint(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    veganized VARCHAR(50000),
    ingredients VARCHAR(50000),
    steps VARCHAR(50000),
    count int
);