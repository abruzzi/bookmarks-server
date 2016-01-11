# How to run

## Preparation

```sh
$ brew install docker-machine
$ brew install docker-compose
```

## Setup environment

Firstly, make sure the server is up and running:

```sh
$ docker-machine start dev
```

and you can get the enviornment like this:

```sh
$ docker-machine env dev
```

Before you build the `docker-compose`, you may need to run this:

```sh
$ eval "$(docker-machine env dev)"
```

## Build the image and run

```sh
$ docker-compose build
$ docker-compose up
```

To post some feeds to server:

```sh
$ curl -X POST -d@feed.json -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8000/api/feeds
```

And get it back to see if it works:

```sh
$ curl http://localhost:8000/api/feeds
```

```json
[{"id":1,"url":"http://icodeit.org/2015/11/what-you-have-learnt-those-years/","title":"看看这些年你都学了什么？","author":"icodit.org","summary":"多年下来，我的Google Bookmarks里已经有近万条的书签。大部分内容是我在读过一遍之后就收藏起来的，也有很多看了一眼之后，觉得不错，然后收藏起来准备以后读的（当然，你也知道，再也没有打开过）。","publishDate":"2016-01-11"}]
```