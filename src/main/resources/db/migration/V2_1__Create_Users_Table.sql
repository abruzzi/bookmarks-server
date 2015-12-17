create table users
(
   id int not null auto_increment,
   name varchar(64),
   email varchar(128),

   create_time          datetime DEFAULT CURRENT_TIMESTAMP,
   last_modified_time   datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
