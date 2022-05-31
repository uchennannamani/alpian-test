FROM amazoncorretto:11.0.13-alpine3.15

LABEL version=1
LABEL maintainer="uchenna nnamani"
LABEL contact="nnamaniuche@outlook.com"
LABEL "project description"="This is a project for Alpian interview process"

VOLUME /usr/app

COPY target/*.jar /usr/app

EXPOSE 9000
ENTRYPOINT ["java","-jar","*.jar"]