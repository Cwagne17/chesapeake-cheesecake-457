INSERT INTO `chesapeake457`.`Client`
    (`email_addr`, `phys_addr`, `phone_num`, `pref_contact`, `is_individual`)
    VALUES ('test@gmail.com', '1210 place driver', '123-123-1234', 'phone', 'true');

UPDATE `chesapeake457`.`Client` SET `name` = 'Chris' WHERE (`email_addr` = 'test@gmail.com');
