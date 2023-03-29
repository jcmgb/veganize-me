USE veganizer;
CREATE TABLE substitutions
(
    id bigint(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ingredient1 VARCHAR(100),
    ingredient2 VARCHAR(100),
    vegansub VARCHAR(200),
    other VARCHAR(500)
);