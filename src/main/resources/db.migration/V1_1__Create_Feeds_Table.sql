create table feeds
(
   id int not null auto_increment,
   title varchar(64),
   url varchar(128),
   publish_date datetime DEFAULT CURRENT_TIMESTAMP,

   create_time          datetime DEFAULT CURRENT_TIMESTAMP,
   last_modified_time   datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
