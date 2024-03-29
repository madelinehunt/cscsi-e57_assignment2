CREATE TABLE CATEGORY (
       ID INT NOT NULL AUTO_INCREMENT
     , NAME VARCHAR(100) NOT NULL
     , PRIMARY KEY (ID)
);

CREATE TABLE BOOK (
       ID INT NOT NULL AUTO_INCREMENT
     , CATEGORY_ID INT NOT NULL
     , ISBN VARCHAR(500) NOT NULL
     , TITLE VARCHAR(500) NOT NULL
     , PRICE DECIMAL(4,2)
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_CATEGORY
        FOREIGN KEY (CATEGORY_ID)
        REFERENCES CATEGORY (ID)
        ON DELETE CASCADE
);
