## 퀴즈 게임 풀기

> 개발 동기: 우리FISA 클라우드 서비스 개발은 매일 오전 9시 이후에 교육에 들어오면, 벌칙으로 노래를 부르게 됩니다.
> 이러한 벌칙을 방어하기 위해서 **퀴즈 게임**을 통해 `지각 면제권`을 얻는 취지로 개발하게 되었습니다.

* `지각 면제권`을 얻기 위해 퀴즈 게임을 푸는 프로그램을 개발했습니다.

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

* 사용자/관리자 차이점은 `마이페이지`입니다. 사용자는 본인이 푼 퀴즈에 대한 포인트 점수와 `지각 면제권`을 확인할 수 있고, 관리자는 퀴즈를 만드는 페이지를 확인할 수 있습니다.

> 시연 과정 - 관리자

* [1] 로그인 페이지로 Name, Password를 입력합니다. // 클라우드 서비스 개발자 교육생 이름(홍길동), 비밀번호(1234)
* [2] 퀴즈 풀기
  * [2-1] 관리자는 해당 문제를 풀 수 없도록 `정답제출` 버튼을 클릭하면, `문제를 풀 수 없습니다` 문구가 뜨게 됩니다.
* [3] 지난 퀴즈 보러가기
  * [3-1] 지난 퀴즈 보러가기 페이지를 가게 되면, 본인이 푼 퀴즈 목록이 보이게 됩니다.
  * [3-2] 만약 본인이 푼 퀴즈가 없다면, 아무런 내용도 보이지 않게 됩니다.
* [4] 마이 페이지(🥷🏻)로 이동하면, 상단에 `퀴즈 만들기` 버튼을 통해 퀴즈를 만드는 페이지로 이동하여 퀴즈를 생성합니다.
  * [4-1] 퀴즈 만드는 페이지에서 원하는 퀴즈 제목, 정답, 포인트 점수, 보기1~4 입력후 `Active`(활성화여부), `Summit` 버튼을 클릭하면 퀴즈가 생성되며 마이페이지로 이동합니다.
  * [4-2] 퀴즈 만드는 페이지에서 `Active`(활성화여부)를 클릭해야만 `퀴즈 풀기` 페이지에 퀴즈가 보이게 됩니다.
  * [4-3] 퀴즈 만드는 페이지에서 `CLEAR` 버튼을 클릭하게 되면, 기존에 작성한 내용이 지워집니다.
* [5] 마이페이지에서 퀴즈에 대해 수정하려면, `EDIT` 버튼을 클릭하면 됩니다.
  * [5-1] 본인이 작성한 퀴즈 내용이 보이게 되고, 수정후에 `SUMIT` 버튼을 클릭하면 수정된 내용으로 저장하게 됩니다.


> 시연 과정 - 사용자

* [1] 로그인 페이지로 Name, Password를 입력합니다. // 클라우드 서비스 개발자 교육생 이름(홍길동), 비밀번호(1234)
* [2] 퀴즈 풀기
  * [2-1] (활성화된 퀴즈가 있다는 가정하에) 퀴즈 풀기 버튼을 클릭하면 퀴즈 풀기 페이지로 이동하고, 관리자가 만든 퀴즈를 풀게 됩니다.
  * [2-2] 해당 문제를 풀고 `정답제출` 버튼을 클릭하면, `정답`이라는 문구가 뜨게 되고, 그게 아니라면, `정답이 아니다`라는 문구가 뜨게 됩니다.
  * [2-3] 퀴즈를 맞추게 되면, 다시 메인 페이지로 이동하게 됩니다.
  * [2-4] (활성화된 퀴즈가 없다면) 퀴즈 풀기 버튼을 클릭하면 퀴즈 풀기 페이지로 이동하는데, `활성화된 문제가 없습니다.` 라는 문구가 뜨고 다시 메인 페이지로 이동합니다.
* [3] 지난 퀴즈 보러가기
  * [3-1] 지난 퀴즈 보러가기 페이지를 가게 되면, 본인이 푼 퀴즈 목록이 보이게 됩니다.
  * [3-2] 만약 본인이 푼 퀴즈가 없다면, 아무런 내용도 보이지 않게 됩니다.
* [4] 마이 페이지(🥷🏻)로 이동하면, 본인이 퀴즈를 푼 것에 대한 총 포인트 값과, 지각 면제권 갯수를 목록으로 확인할 수 있습니다.
  * [4-1] 포인트 점수는 퀴즈마다 다를 수 있습니다.
  * [4-2] 지각 면제권 포인트가 1000점 이상이면 1개로 적립하게 됩니다.


## 개발 환경

- HTML5, CSS3, JavaScript, Vue.js, Vuetify 3
- Java11, SpringBoot(v2.7.13), Spring Data JPA, MySQL
- Git, Swagger(v2.7.13)
