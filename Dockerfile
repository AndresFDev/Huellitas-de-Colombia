FROM openjdk:11-jre-slim
RUN useradd -ms /bin/bash uspring
USER uspring
WORKDIR /home/uspring
ADD ./target/app.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
