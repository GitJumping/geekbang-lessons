# 引入基础镜像
From ghcr.io/graalvm/graalvm-ce:latest

# ${cur_dir}/projects/stage-0/spring-boot-starter-parent/target
# 添加 spring-native 已经编译好的执行文件
ADD ./spring-graalvm-native-build-linux target/web-mvc-linux 

# 修改执行文件的执行权限
RUN chmod a+x target/web-mvc-linux

# 暴露端口
EXPOSE 8080

CMD target/web-mvc-linux