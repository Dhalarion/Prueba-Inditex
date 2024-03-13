CREATE TABLE prices (
    price_Id integer auto_increment not null,
    brand_Id integer not null,
    start_Date dateTime not null,
    end_Date dateTime not null,
    price_List integer not null,
    product_Id integer not null,
    priority integer not null,
    price decimal not null,
    curr varchar not null
);