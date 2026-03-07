FROM amazoncorretto:17

# Add metadata label
LABEL version="0.0.2"
LABEL description="server port changed to 90xx and profile to local"

WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar