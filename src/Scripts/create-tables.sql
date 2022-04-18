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
