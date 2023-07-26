## 퀴즈 게임 풀기

> 개발 동기: 우리FISA 클라우드 서비스 개발은 매일 오전 9시 이후에 교육에 들어오면, 벌칙으로 노래를 부르게 됩니다.
> 이러한 벌칙을 방어하기 위해서 **퀴즈 게임**을 통해 `지각 면제권`을 얻는 취지로 개발하게 되었습니다.

* `지각 면제권`을 얻기 위해 퀴즈 게임을 푸는 프로그램을 개발했습니다.

  (팀 문화에 대한 자세한 내용이 궁금하시다면, [Wiki](https://github.com/woorifisa-service-dev/backend-2nd-LatePass/wiki)를 봐주세요!)

## 기술 스택

![Html5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white)
![Css3](https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white)
![Vue.js](https://img.shields.io/badge/Vue.js-4FC08D?style=flat&logo=vuedotjs&logoColor=white)
![Vuetify3](https://img.shields.io/badge/vuetify-1867C0?style=flat&logo=vuetify&logoColor=white)<br>
![Java](https://img.shields.io/badge/-Java-19bad6?logo=Java&logoColor=white&style=flat)
![Spring](https://img.shields.io/badge/-Spring-green?logo=Spring&logoColor=white&style=flat)
![Gradle](https://img.shields.io/badge/-Gradle-black?logo=Gradle&logoColor=white&style=flat)
![MySQL](https://img.shields.io/badge/-MySQL-blue?logo=MySQL&logoColor=white&style=flat)<br>
![Swagger](https://img.shields.io/badge/-Swagger-a4ff82?logo=Swagger&logoColor=black&style=flat)<br>

## 시연

![](/docs/latepass.gif)

## 설치

* 본인이 로컬에서 저장하고 싶은 위치에서 터미널 창을 열고 아래의 명령어를 입력합니다.

```
git clone https://github.com/woorifisa-service-dev/backend-2nd-LatePass.git
```

* 해당 프로그램의 시연을 확인하려면 아래와 같이 몇 가지 설치 과정을 진행해야 합니다.

* frontend, backend 각각의 설치 과정을 진행하면 됩니다.

### frontend

* frontend 폴더로 이동하여 npm 설치합니다.

> Version - npm: 8.19.4, node - v16.20.0

```
npm i // npm install
➜  frontend git:(main)  npm -v // 8.19.4
➜  frontend git:(main)  node -v // v16.20.0
```

### backend

* backend - src - main - resources 폴더 안에 `application.properties` 생성하여 아래와 같이 입력해줍니다.

  (참고: 데이터베이스는 `MySQL`로 하였고, API 문서는 `Swagger`를 사용했습니다)

  (여기서 root, password은 본인이 MySQL에 설정한 값으로 해줘야 합니다)

```
## MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/latepass?serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=1121

## JPA
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create

spring.sql.init.encoding=UTF-8
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

## Swagger
spring.mvc.pathmatch.matching-strategy=ant_path_matcher
```

* 처음 DB를 실행할 경우에는 `spring.jpa.hibernate.ddl-auto` 를 `create`로 입력하고, DB안에 있는 값을 업데이트를 할 경우에는 `update`로 입력하면 됩니다.

## 실행

> 백엔드 실행

* backend - src - main - java - `ChronoChallengeApplication` 클래스에서 main 실행(Run)합니다.

> 프론트엔드 실행

* `main` 브랜치에서 frontend repository를 실행합니다.

```
cd frontend   // 프론트엔드 폴더로 이동
npm run dev   // 프론트엔드 레포에서 로컬 실행
```

```
> chrono-challenge@0.0.0 dev
> vite


  VITE v4.4.2  ready in 252 ms

  ➜  Local:   http://127.0.0.1:3000/
  ➜  Network: use --host to expose
  ➜  press h to show help
```

* 크롬창에서 `http://localhost:3000/` 입력하면 해당 local 창이 뜨게 됩니다.


## 시나리오

[사용자, 관리자 시나리오](https://github.com/woorifisa-service-dev/backend-2nd-LatePass/tree/main/docs/senario.md)