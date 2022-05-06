CREATE TABLE `chesapeake457`.`Client` (
    `email_addr` VARCHAR(45) NOT NULL,
    `phys_addr` VARCHAR(45) NOT NULL,
    `phone_num` VARCHAR(45) NOT NULL,
    `pref_contact` ENUM("phone", "email") NOT NULL,
    `is_individual` TINYINT NOT NULL DEFAULT 0,
    `name` VARCHAR(45) NOT NULL,
    `spouse1_name` VARCHAR(45),
    `spouse2_name` VARCHAR(45),
    PRIMARY KEY (`email_addr`),
    UNIQUE INDEX `email_addr_UNIQUE` (`email_addr` ASC) VISIBLE);

CREATE TABLE `chesapeake457`.`Product` (
   `id` INT NOT NULL,
   `type` VARCHAR(45) NULL,
   `flavor` VARCHAR(45) NULL,
   `size` VARCHAR(45) NULL,
   `stock` INT NULL,
   PRIMARY KEY (`id`));

CREATE TABLE `chesapeake457`.`Ingredient` (
  `name` VARCHAR(45) NOT NULL,
  `stock` INT NULL,
  PRIMARY KEY (`name`));

CREATE TABLE `chesapeake457`.`Package` (
   `name` VARCHAR(45) NOT NULL,
   `cost` DOUBLE NULL,
   PRIMARY KEY (`name`));


CREATE TABLE `chesapeake457`.`Event` (
     `id` INT AUTO_INCREMENT PRIMARY KEY,
     `delivery_time` VARCHAR(45) NULL,
     `num_guests` INT NULL,
     `delivery_address` VARCHAR(45) NULL,
     `isWeddingEvent` TINYINT NULL,
     `venue` VARCHAR(45) NULL,
     `budget` INT NULL,
     `client_email` VARCHAR(45) NOT NULL,
     `package_name` VARCHAR(45) NULL,
     INDEX `client_email_idx` (`client_email` ASC) VISIBLE,
     CONSTRAINT `client_email`
         FOREIGN KEY (`client_email`)
             REFERENCES `chesapeake457`.`Client` (`email_addr`)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION,
         FOREIGN KEY (`package_name`)
             REFERENCES `chesapeake457`.`Package` (`name`)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION);

CREATE TABLE `chesapeake457`.`Order` (
     `order_client_email` VARCHAR(45) NOT NULL,
     `eventId` INT NULL,
     `order_time` VARCHAR(45) NOT NULL,
     `paid_date` VARCHAR(45) NULL,
     `payment_type` VARCHAR(45) NULL,
     PRIMARY KEY (`order_client_email`, `order_time`),
     INDEX `eventId_idx` (`eventId` ASC) VISIBLE,
     INDEX `order_timex` (`order_time` ASC) VISIBLE,
     CONSTRAINT `eventId`
         FOREIGN KEY (`eventId`)
             REFERENCES `chesapeake457`.`Event` (`id`)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION,
     CONSTRAINT `order_client_email`
         FOREIGN KEY (`order_client_email`)
             REFERENCES `chesapeake457`.`Client` (`email_addr`)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION);

CREATE TABLE `chesapeake457`.`Order_has_many_products` (
   `product_id` INT NOT NULL,
   `order_time` VARCHAR(45) NOT NULL,
   `order_product_client_email` VARCHAR(45) NOT NULL,
   `quantity` VARCHAR(45) NULL,
   PRIMARY KEY (`product_id`, `order_product_client_email`, `order_time`),
   INDEX `order_time_idx` (`order_time` ASC) VISIBLE,
   INDEX `order_product_client_email_idx` (`order_product_client_email` ASC) VISIBLE,
   CONSTRAINT `product_id`
       FOREIGN KEY (`product_id`)
           REFERENCES `chesapeake457`.`Product` (`id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION,
   CONSTRAINT `order_time`
       FOREIGN KEY (`order_time`)
           REFERENCES `chesapeake457`.`Order` (`order_time`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION,
   CONSTRAINT `order_product_client_email`
       FOREIGN KEY (`order_product_client_email`)
           REFERENCES `chesapeake457`.`Order` (`order_client_email`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION);