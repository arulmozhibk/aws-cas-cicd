FROM java:8
VOLUME /tmp
ADD casapi/target/casapi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8060
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]