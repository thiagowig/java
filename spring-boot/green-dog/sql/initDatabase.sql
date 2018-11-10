drop table property IF EXISTS;

CREATE TABLE property (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
category VARCHAR(200),
name VARCHAR(200),
value VARCHAR(512) default '',
description VARCHAR(1000),
PRIMARY KEY (id),
UNIQUE INDEX name_unique (name ASC));


-- ----------------------------------------
-- CORE PROPERTIES
-- ----------------------------------------

-- BANNER
insert into property(category,name,value,description) values ('CORE PROPERTIES','banner.charset','UTF-8','Banner file encoding');
insert into property(category,name,value,description) values ('CORE PROPERTIES','banner.location','classpath:banner.txt','Banner file location');