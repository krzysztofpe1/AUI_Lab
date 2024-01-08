FROM nginx:1.23.3

LABEL org.opencontainers.image.title="AUI_Lab-ng"
LABEL org.opencontainers.image.authors="Krzysztof Pecyna"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/AUI_Lab-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
