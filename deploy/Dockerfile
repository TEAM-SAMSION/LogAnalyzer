FROM amazoncorretto:17
ARG JAR_FILE=/build/libs/LogAnalyzer-0.0.1.jar
COPY ${JAR_FILE} LogAnalyzer.jar
ENTRYPOINT ["java","-jar","/LogAnalyzer.jar"]