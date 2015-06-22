create table user_favorite_feed (
    id int not null auto_increment,
    user_id int,
    feed_id int,
    primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;