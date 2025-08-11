-- Insert categories with explicit IDs
INSERT INTO category (id, name) VALUES (1, 'Soup');
INSERT INTO category (id, name) VALUES (2, 'Main Course');
INSERT INTO category (id, name) VALUES (3, 'Dessert');
INSERT INTO category (id, name) VALUES (4, 'Appetizer');
INSERT INTO category (id, name) VALUES (5, 'Smoothie');

-- Insert ingredients with explicit IDs
INSERT INTO ingredient (id, name) VALUES (1, 'Chicken');
INSERT INTO ingredient (id, name) VALUES (2, 'Beef');
INSERT INTO ingredient (id, name) VALUES (3, 'Carrot');
INSERT INTO ingredient (id, name) VALUES (4, 'Potato');
INSERT INTO ingredient (id, name) VALUES (5, 'Onion');
INSERT INTO ingredient (id, name) VALUES (6, 'Tomato');
INSERT INTO ingredient (id, name) VALUES (7, 'Pasta');
INSERT INTO ingredient (id, name) VALUES (8, 'Cheese');
INSERT INTO ingredient (id, name) VALUES (9, 'Chocolate');
INSERT INTO ingredient (id, name) VALUES (10, 'Strawberry');
INSERT INTO ingredient (id, name) VALUES (11, 'Milk');
INSERT INTO ingredient (id, name) VALUES (12, 'Banana');
INSERT INTO ingredient (id, name) VALUES (13, 'Spinach');
INSERT INTO ingredient (id, name) VALUES (14, 'Bread');
INSERT INTO ingredient (id, name) VALUES (15, 'Butter');

-- Insert recipes with explicit IDs
INSERT INTO recipe (id, title, description, instructions, cuisine, category_id, created_at, updated_at) VALUES
                                                                                                        (1, 'Chicken Noodle Soup', 'Warm soup with chicken and noodles.', 'Boil chicken, add noodles and vegetables.', 'American', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (2, 'Tomato Basil Soup', 'Simple tomato soup with basil.', 'Cook tomatoes with basil and blend.', 'Italian', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (3, 'Grilled Beef Steak', 'Juicy grilled beef steak.', 'Season steak, grill to desired doneness.', 'American', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (4, 'Pasta Carbonara', 'Classic pasta with creamy sauce.', 'Cook pasta, mix with eggs, cheese, and bacon.', 'Italian', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (5, 'Chocolate Cake', 'Rich and moist chocolate cake.', 'Mix ingredients, bake at 180°C for 30 min.', 'French', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (6, 'Strawberry Cheesecake', 'Cheesecake topped with fresh strawberries.', 'Prepare crust, fill with cream cheese mix, chill.', 'American', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (7, 'Bruschetta', 'Grilled bread with tomato topping.', 'Toast bread, add tomato, garlic, and olive oil.', 'Italian', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (8, 'Stuffed Mushrooms', 'Mushrooms stuffed with cheese.', 'Fill mushrooms with cheese mixture, bake.', 'French', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (9, 'Banana Smoothie', 'Creamy banana smoothie.', 'Blend banana with milk and ice.', 'American', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                        (10, 'Green Smoothie', 'Healthy spinach and banana smoothie.', 'Blend spinach, banana, and milk.', 'American', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Now insert recipe-ingredient relationships after all recipes exist
-- Link recipes with ingredients in recipe_ingredient
-- Soup category
INSERT INTO recipe_ingredient (ingredient_id, quantity, recipe_id) VALUES
                                                                       (1, '200g', 1), -- Chicken
                                                                       (7, '100g', 1), -- Pasta
                                                                       (3, '1 pc', 1), -- Carrot
                                                                       (6, '200g', 2), -- Tomato
                                                                       (5, '1 pc', 2), -- Onion
                                                                       (14, '2 leaves', 2); -- Bread (simulated as basil for demo)

-- Main Course category
INSERT INTO recipe_ingredient (ingredient_id, quantity, recipe_id) VALUES
                                                                       (2, '300g', 3), -- Beef
                                                                       (5, '1 pc', 3), -- Onion
                                                                       (7, '150g', 4), -- Pasta
                                                                       (8, '50g', 4), -- Cheese
                                                                       (5, '1 pc', 4); -- Onion

-- Dessert category
INSERT INTO recipe_ingredient (ingredient_id, quantity, recipe_id) VALUES
                                                                       (9, '200g', 5), -- Chocolate
                                                                       (11, '200ml', 5), -- Milk
                                                                       (10, '150g', 6), -- Strawberry
                                                                       (8, '50g', 6), -- Cheese
                                                                       (15, '50g', 6); -- Butter

-- Appetizer category
INSERT INTO recipe_ingredient (ingredient_id, quantity, recipe_id) VALUES
                                                                       (14, '2 slices', 7), -- Bread
                                                                       (6, '50g', 7), -- Tomato
                                                                       (8, '50g', 8), -- Cheese
                                                                       (5, '1 pc', 8); -- Onion

-- Smoothie category
INSERT INTO recipe_ingredient (ingredient_id, quantity, recipe_id) VALUES
                                                                       (12, '1 pc', 9), -- Banana
                                                                       (11, '200ml', 9), -- Milk
                                                                       (13, '50g', 10), -- Spinach
                                                                       (12, '1 pc', 10), -- Banana
                                                                       (11, '200ml', 10); -- Milk