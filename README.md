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

## 第一种方式-failed

- 命令需要在下述目录执行

  ```shell
  # ${cur_dir}/projects/stage-0/spring-boot-starter-parent
  ```

- 安装Docker环境

- 编译native的可执行文件

  使用上次课程编译的文件

- Dockerfile

  见 Dockerfile-3 文件

- 构建docker image && 启动镜像

  见 sh3 脚本

- 最后无法启动，需要在linux下编译的二进制文件才行

  ```shell
  /bin/sh: target/web-mvc: cannot execute binary file: Exec format error
  ```

  

  ## 第二种方式-failed

  失败

  见 Dockerfile-4 文件，sh4 脚本

  ## 第三种方式-success

  执行 sh5 脚本即可

```
# 加内存
Error: Image build request failed with exit status 137
```

```
# https://www.graalvm.org/reference-manual/ruby/Installingzlib/
# sudo apt-get install libz-dev
# 但是运行后，提示已经安装
# zlib1g-dev is already the newest version.
# 0 upgraded, 0 newly installed, 0 to remove and 6 not upgraded.
# 再编译就莫名其妙好了


Fatal error:java.lang.RuntimeException: java.lang.RuntimeException: There was an error linking the native image: Linker command exited with 1

Based on the linker command output, possible reasons for this include:
1. It appears as though libz.a is missing. Please install it.

...

collect2: error: ld returned 1 exit status
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at java.base/java.util.concurrent.ForkJoinTask.getThrowableException(ForkJoinTask.java:600)
	at java.base/java.util.concurrent.ForkJoinTask.get(ForkJoinTask.java:1006)
	at com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:499)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:370)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:531)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:119)
	at com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus.main(NativeImageGeneratorRunner.java:568)
Caused by: java.lang.RuntimeException: There was an error linking the native image: Linker command exited with 1

Based on the linker command output, possible reasons for this include:
1. It appears as though libz.a is missing. Please install it.

...

collect2: error: ld returned 1 exit status
	at com.oracle.svm.hosted.image.NativeImageViaCC.handleLinkerFailure(NativeImageViaCC.java:513)
	at com.oracle.svm.hosted.image.NativeImageViaCC.write(NativeImageViaCC.java:460)
	at com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:710)
	at com.oracle.svm.hosted.NativeImageGenerator.lambda$run$2(NativeImageGenerator.java:495)
	at java.base/java.util.concurrent.ForkJoinTask$AdaptedRunnableAction.exec(ForkJoinTask.java:1407)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:183)
Error: Image build request failed with exit status 1
```







## 有用的东西

```shell
docker images
docker ps -a
setopt +o nomatch
setopt -o nomatch
docker run -it --privileged --pid=host debian nsenter -t 1 -m -u -n -i sh
ls /var/lib/docker/volumes/
docker inspect spring-boot-starter-parent:latest
```

