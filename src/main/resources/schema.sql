-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-08-07 17:16:34.668

-- tables
-- Table: category
CREATE TABLE category (
    id int GENERATED ALWAYS AS IDENTITY NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: ingredient
CREATE TABLE ingredient (
    id int GENERATED ALWAYS AS IDENTITY NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT ingredient_pk PRIMARY KEY (id)
);

-- Table: recipe
CREATE TABLE recipe (
    id int GENERATED ALWAYS AS IDENTITY NOT NULL,
    title varchar(50)  NOT NULL,
    description varchar(350)  NOT NULL,
    instructions varchar(350)  NOT NULL,
    cuisine varchar(50)  NOT NULL,
    category_id int  NOT NULL,
    created_at timestamp  NOT NULL,
    updated_at timestamp  NOT NULL,
    CONSTRAINT recipe_pk PRIMARY KEY (id)
);

-- Table: recipe_ingredient
CREATE TABLE recipe_ingredient (
    id int GENERATED ALWAYS AS IDENTITY NOT NULL,
    ingredient_id int  NOT NULL,
    quantity varchar(50)  NOT NULL,
    recipe_id int  NOT NULL,
    CONSTRAINT recipe_ingredient_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: recipe_category (table: recipe)
ALTER TABLE recipe ADD CONSTRAINT recipe_category
    FOREIGN KEY (category_id)
    REFERENCES category (id);

-- Reference: recipe_ingredient_recipe (table: recipe_ingredient)
ALTER TABLE recipe_ingredient ADD CONSTRAINT recipe_ingredient_recipe
    FOREIGN KEY (recipe_id)
    REFERENCES recipe (id);

-- Reference: recipe_ingredients_ingredients (table: recipe_ingredient)
ALTER TABLE recipe_ingredient ADD CONSTRAINT recipe_ingredients_ingredients
    FOREIGN KEY (ingredient_id)
    REFERENCES ingredient (id);

-- End of file.

