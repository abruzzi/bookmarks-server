create table user_favorite_feed (
    id int not null auto_increment,
    user_id int,
    feed_id int,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (feed_id) REFERENCES feeds(id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;