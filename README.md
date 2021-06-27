# geekbang-lessons
my class


# Week 12 Homework
org.geektimes.projects.user.mybatis.annotation.*

org.geektimes.projects.user.mybatis.configauto.*


# Week 13 Homework
org.geektimes.projects.spring.cloud.config.client.locator.*

config/default.properties

META-INF/spring.factories


# Week 14 Homework
## 主要实现：发布，订阅，配置
org.geektimes.projects.spring.cloud.bus.bridge.*
## 其他配置
org.geektimes.projects.spring.cloud.bus.bridge.config.server.BusRemoteClientRefresher
projects/stage-0/user-platform/spring-cloud-projects/spring-cloud-config-server/src/main/resources/application.yaml
projects/stage-0/user-platform/spring-cloud-projects/spring-cloud-config-client/src/main/resources/application.yaml



# Week 15 Homework

## 安装GraalVM

- 下载安装包 https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.1.0

选择jdk11的版本

- 安装 参考 https://www.graalvm.org/docs/getting-started/

- 在GraalVM虚拟机目录/bin目录下，调用命令 ./gu install native-image安装 native-image

- 使用https://start.springboot.io/ 生成spring-native源代码

- 在源代码工程下调用，mvn -Pnative -DskipTests package

- 编译后提示成功

  ```
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  02:50 min
  [INFO] Finished at: 2021-06-15T01:47:00+08:00
  [INFO] ------------------------------------------------------------------------
  ```

- 在maven编译输入目录target下，找到编译好的二进制文件
- 执行 ./spring-graalvm-native-build ，启动成功
- 在浏览器访问http://127.0.0.1:8080/，  看到访问提示



# Week16 Homework

- 命令需要在下述目录执行

  ```shell
  # ${cur_dir}/projects/stage-0/spring-boot-starter-parent/target
  ```

- 安装Docker环境

- 编译native的可执行文件

- Dockerfile

  见 Dockerfile-3 文件

- 构建docker image && 启动镜像

  见 sh3 脚本

- 最后无法启动，需要在linux下编译的二进制文件才行

  ```shell
  /bin/sh: target/web-mvc: cannot execute binary file: Exec format error
  ```

