CREATE TABLE product
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255)   NOT NULL,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    CONSTRAINT uq_product_name UNIQUE (name)
);

CREATE TABLE raw_material
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255)   NOT NULL,
    stock_quantity DECIMAL(10, 3) NOT NULL DEFAULT 0 CHECK (stock_quantity >= 0),
        CONSTRAINT uq_raw_material_name UNIQUE (name)
);

CREATE TABLE product_composition
(
    id                BIGSERIAL PRIMARY KEY,
    product_id        BIGINT         NOT NULL,
    raw_material_id   BIGINT         NOT NULL,
    required_quantity DECIMAL(10, 3) NOT NULL CHECK (required_quantity > 0),

    CONSTRAINT uq_product_raw_material UNIQUE (product_id, raw_material_id),

    CONSTRAINT fk_product FOREIGN KEY (product_id)
        REFERENCES product (id) ON DELETE CASCADE,
    CONSTRAINT fk_raw_material FOREIGN KEY (raw_material_id)
        REFERENCES raw_material (id) ON DELETE CASCADE
);
