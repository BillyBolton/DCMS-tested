ARG TOMCAT_VERSION
ARG ARCHIVE_NAME

FROM tomcat:${TOMCAT_VERSION}
WORKDIR /usr/local/tomcat
COPY ./build/libs/${ARCHIVE_NAME}.war ./webapps/

# required for Oracle DB client
ENV TZ=EST

CMD ["catalina.sh", "run"]