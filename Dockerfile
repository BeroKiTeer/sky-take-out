# 使用OpenJDK官方镜像作为基础镜像
FROM openjdk:17-jdk-alpine

# 作者或维护者信息（可选）
LABEL authors="dell"

# 指定容器内的工作目录
WORKDIR /app

# 将打包的jar文件复制到容器的/app目录下
COPY ./sky-common/target/sky-common-1.0-SNAPSHOT.jar /app

# 容器对外暴露的端口号，需要和你的Spring Boot应用一致
EXPOSE 8080

# 定义容器启动后执行的命令
ENTRYPOINT ["java","-jar","/app/sky-application.jar"]