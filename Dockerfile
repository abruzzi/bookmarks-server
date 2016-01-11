FROM java:openjdk-8-jdk

RUN apt-get update
RUN apt-get install wget -y
RUN wget http://10.29.2.167:9999/bookmarks-server-0.1.0.jar

RUN mkdir /app
COPY ./start.sh /app/start.sh

ENV PORT 8000

WORKDIR /app
CMD /app/start.sh