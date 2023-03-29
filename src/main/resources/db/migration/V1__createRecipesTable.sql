USE veganizer;
CREATE TABLE recipes
(
    id bigint(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    veganized BLOB(50000),
    ingredients BLOB(50000),
    steps BLOB(50000),
    count int
);