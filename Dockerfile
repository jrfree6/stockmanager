FROM lwieske/java-8
ADD target/stock-manager.jar stock-manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "stock-manager.jar"]