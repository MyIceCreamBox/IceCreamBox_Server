FROM amazoncorretto:17
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
RUN chmod +x ./gradlew
# JAR_FILE 변수에 값을 저장
COPY JAR_FILE=./build/libs/MyIceCreamBox-0.0.1-SNAPSHOT.jar icecreambox.jar
ENTRYPOINT ["java", "-jar", "icecreambox.jar"]
