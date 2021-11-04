# 사용법



```shell
> git clone https://github.com/ujunhwan/springboot-docker
```



### Github Action

`github settings` -> `secrets` 에 가서 secret들을 추가합니다.

3가지 secret들을 추가할 것이다.

* HOST

  `ec2 퍼블릭 IP v4 DNS`를 넣어준다.

* KEY

  터미널에서 아래 명령어를 입력한다.

  ```shell
  cat {*.pem}
  ```

  다음과 같은 텍스트들이 나온다.

  ```
  -----BEGIN RSA PRIVATE KEY-----
  				비 밀 적 인 부 분
  -----END RSA PRIVATE KEY-----%
  ```

  % 빼고 전부 넣으면 된다.

  

* ENV_VARS

  ```
  DATABASE_HOST={rds주소}
  DATABASE_DB={사용 할 database 이름}
  DATABASE_NAME={rds 만들 때 사용한 이름}
  DATABASE_USER={rds 만들 때 사용한 이름}
  DATABASE_PASSWORD={rds 비밀번호}
  DATABASE_PORT={rds 포트}
  ```

### application.yml

```yaml
datasource:
  driver-class-name: com.mysql.cj.jdbc.Driver
  url: jdbc:mysql://${DATABASE_HOST}:${DATABASE_PORT}/${DATABASE_DB}?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
  username: ${DATABASE_USER}
  password: ${DATABASE_PASSWORD}
```

만약 `mysql` 이 아닌 다른 데이터베이스를 사용한다면, `driver-class-name` 과 `url` 설정을 변경해주어야 한다.

### build.gradle

```groovy
dependencies {
   ...

   // mysql
   implementation 'mysql:mysql-connector-java'
```

`mysql` 을 사용하지 않는다면, 의존성 부분도 바꾸어주어야 한다.



설정이 다 끝났다면, push를 해보자. 

ec2 인스턴스의 도커를 빌드하고 실행하여 서버를 띄워줄 것이다.
