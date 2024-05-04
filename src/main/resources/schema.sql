CREATE TABLE IF NOT EXISTS restaurants (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    average_rating NUMERIC(4,2) NOT NULL,
    is_kosher BOOLEAN NOT NULL,
    cuisines VARCHAR(255)[]
);
