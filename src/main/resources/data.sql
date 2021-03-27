DROP TABLE IF EXISTS library.ledger;
DROP TABLE IF EXISTS library.book;
DROP TABLE IF EXISTS library.borrower;

CREATE TABLE library.book
(
    isbn     varchar(20) PRIMARY KEY,
    title    varchar(255) NOT NULL,
    category varchar(255) NOT NULL
);

-- Fiction
INSERT INTO library.book(isbn, title, category)
VALUES ('0345538986', 'jurassic park', 'fiction');
INSERT INTO library.book(isbn, title, category)
VALUES ('9780679419464', 'The Lost World', 'fiction');
INSERT INTO library.book(isbn, title, category)
VALUES ('0061990558', 'Sphere', 'fiction');

-- Computers
INSERT INTO library.book(isbn, title, category)
VALUES ('1449393195', 'CSS: The Definitive Guide', 'computers');
INSERT INTO library.book(isbn, title, category)
VALUES ('9780262033848', 'Introduction to Algorithms, 3rd Edition (The MIT Press)', 'computers');
INSERT INTO library.book(isbn, title, category)
VALUES ('0201633612', 'Design Patterns: Elements of Reusable Object-Oriented Software', 'computers');

-- Science
INSERT INTO library.book(isbn, title, category)
VALUES ('1419718401', 'Lewin''s GENES XII', 'science');
INSERT INTO library.book(isbn, title, category)
VALUES ('1319114679', 'Biochemistry', 'science');
INSERT INTO library.book(isbn, title, category)
VALUES ('111949348X', 'Organic Chemistry as a Second Language', 'science');

CREATE TABLE library.borrower
(
    id   UUID PRIMARY KEY,
    name varchar(255) NOT NULL
);

INSERT INTO library.borrower(id, name)
values ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', 'Benadryl Cabbagepatch');

-- Did not add UNIQUE constraint on purpose.
CREATE TABLE library.ledger
(
    borrower_id UUID        NOT NULL,
    book_isbn   varchar(20) NOT NULL,
    CONSTRAINT FK_legder_borrower FOREIGN KEY (borrower_id) REFERENCES library.borrower (id),
    CONSTRAINT FK_legder_book FOREIGN KEY (book_isbn) REFERENCES library.book (isbn)
);

INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '111949348X');
INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '1319114679');
INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '1419718401');
INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '1419718401');


INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '9780262033848');
INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '0201633612');
INSERT INTO library.ledger(borrower_id, book_isbn)
VALUES ('3b8e929e-ad56-431f-9d3f-1ea6252cd5fc', '1449393195');


