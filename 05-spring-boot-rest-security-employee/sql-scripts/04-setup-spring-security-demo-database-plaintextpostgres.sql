-- Drop tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table `users`
CREATE TABLE users (
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       enabled BOOLEAN NOT NULL,
                       PRIMARY KEY (username)
);

-- Inserting data for table `users`
INSERT INTO users (username, password, enabled)
VALUES
    ('john', '{noop}test123', TRUE),
    ('mary', '{noop}test123', TRUE),
    ('susan', '{noop}test123', TRUE);

-- Table structure for table `authorities`
CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             UNIQUE (username, authority),
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
/* CONSTRAINT dimaksudkan bahwa data dari colom username harus ada di kolom table 'user'
   terus apa perbedaannya dengan foreign key biasa,
   todo contoh, jika data pada 'john' pada table users dihapus, jika kita menggunakan CONSTRAINT, maka data tidak bisa dihapus sebelum data di authorities terhapus
   tetapi jika kita menggunakan foreign key biasa, maka data yang dihapus pada table users tidak akan terhapus di table authorities walaupun pada table authorities merujuk pada table users
   */

INSERT INTO authorities (username, authority)
VALUES
    ('john', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_MANAGER'),
    ('susan', 'ROLE_EMPLOYEE'),
    ('susan', 'ROLE_MANAGER'),
    ('susan', 'ROLE_ADMIN');

insert into users (username, password, enabled)
values  ('john', '{noop}test123', TRUE);

update authorities
set  authority = 'ROLE_EMPLOYEE'
where username = 'john';
--  delete in user, maka otomatis terdelete di authorities
delete from authorities where authorities.username= 'john';
delete from users where users.username = 'john';

