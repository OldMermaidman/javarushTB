FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=tsest_javar_bot
ENV BOT_TOKEN=1763483537:AAFs9MRjSGEypxtL7bbNlmiss2BFBi5qaSc
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]