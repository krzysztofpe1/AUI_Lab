FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="AUI_Lab-gateway"
LABEL org.opencontainers.image.authors="Krzysztof Pecyna"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:AUI_Lab-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV AUI_LAB_GATEWAY_HOST=localhost:8080
ENV AUI_LAB_ORDER_URL=http://localhost:8081
ENV AUI_LAB_CLIENT_URL=http://localhost:8082

EXPOSE 8080 

COPY target/*.jar /opt/AUI_Lab-gateway/AUI_Lab-gateway.jar

CMD ["java", "-jar", "/opt/AUI_Lab-gateway/AUI_Lab-gateway.jar"]
