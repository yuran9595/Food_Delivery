CREATE TABLE products ();
ALTER TABLE products ADD id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY;
ALTER TABLE products ADD name VARCHAR(255) NOT NULL;
ALTER TABLE products ADD description VARCHAR(255);
ALTER TABLE products ADD created_date TIMESTAMP WITHOUT TIME ZONE;
ALTER TABLE products ADD last_updated_date TIMESTAMP WITHOUT TIME ZONE;
ALTER TABLE products ADD distributor_id BIGINT;
ALTER TABLE products ADD product_sub_category_id BIGINT;
ALTER TABLE products ADD CONSTRAINT FK_products_product_sub_categories FOREIGN KEY (product_sub_category_id) REFERENCES product_sub_categories (id);
ALTER TABLE products ADD CONSTRAINT FK_products_distributor FOREIGN KEY (distributor_id) REFERENCES distributors (id);