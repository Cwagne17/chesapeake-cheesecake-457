CREATE TABLE `chesapeake457`.`Client` (
    `email_addr` VARCHAR(45) NOT NULL,
    `phys_addr` VARCHAR(45) NOT NULL,
    `phone_num` VARCHAR(45) NOT NULL,
    `pref_contact` ENUM("phone", "email") NOT NULL,
    `is_individual` BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (`email_addr`),
    UNIQUE INDEX `email_addr_UNIQUE` (`email_addr` ASC) VISIBLE);

CREATE TABLE `chesapeake457`.`WeddingClient` (
     `wedding_email` VARCHAR(45) NOT NULL,
     `spouse1_name` VARCHAR(45) NOT NULL,
     `spouse2_name` VARCHAR(45) NOT NULL,
     PRIMARY KEY (`wedding_email`),
     UNIQUE INDEX `wedding_email_UNIQUE` (`wedding_email` ASC) VISIBLE,
     CONSTRAINT `wedding_email`
         FOREIGN KEY (`wedding_email`)
             REFERENCES `chesapeake457`.`Client` (`email_addr`)
             ON DELETE CASCADE
             ON UPDATE CASCADE);

CREATE TABLE `chesapeake457`.`IndividualClient` (
    `individual_email` VARCHAR(45) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`individual_email`),
    UNIQUE INDEX `individual_email_UNIQUE` (`individual_email` ASC) VISIBLE,
    CONSTRAINT `individual_email`
        FOREIGN KEY (`individual_email`)
            REFERENCES `chesapeake457`.`Client` (`email_addr`)
            ON DELETE CASCADE
            ON UPDATE CASCADE);
