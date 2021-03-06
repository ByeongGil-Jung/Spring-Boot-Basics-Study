package com.example.springbootrestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*

[ 1. RestTemplate 과 WebClient ]

 - RestClient 는 Spring 프레임워크에서 제공하는 것이고,
   Spring Boot 는 RestClient 를 쉽게 사용할 수 있도록 bean 을 등록해 준다.
   (여기서 RestTemplate 혹은 WebClient 의 bean 을 등록해 주는 것이 아니라,
    RestTemplateBuilder, WebClient.Builder 를 bean 으로 등록 해준다.)

   -> 즉, Builder 를 주입받아서, 필요할 때마다 build 하여 RestClient 인스턴스를 생성해서 사용해야 한다.

 - RestTemplate 혹은 WebClient 를 둘 다 써도 괜찮고, 둘 중 하나만 써도 괜찮다.


 (1) RestTemplate
  - Blocking I/O 기반의 Synchronous API
  - RestTemplateAutoConfiguration
  - 프로젝트에 spring-web 모듈이 있다면 RestTemplateBuilder 를 bean 으로 등록해 준다.

   >> RestTemplateRunner 클래스 참조


 (2) WebClient (매우 추천 !)
  - Non-Blocking I/O 기반의 Asynchronous API
  - WebClientAutoConfiguration
  - 프로젝트에 spring-webflux 모듈이 있다면 WebClient.Builder 를 bean 으로 등록해 준다.

    (WebFlux 가 dependency 로 필요함)

    >> WebClientRunner 클래스 참조


[ 2. RestClient 커스터마이징 ]

 (1) RestTemplate
  - 기본적으로 java.net.HttpURLConnection 사용
  - 커스터마이징 ?
    - 로컬 커스터마이징
      ( > WebClientRunner 클래스 참조)
    - 글로벌 커스터마이징
      ( > RestClientConfiguration 참조)
      >> RestTemplateCustomizer
      >> 빈 재정의

 (2) WebClient
  - 기본으로 Reactor Netty 의 HTTP Client 사용
  - 커스터마이징 ?
    - 로컬 커스터마이징
      ( > RestTemplateRunner 클래스 참조)
    - 글로벌 커스터마이징
      ( > RestClientConfiguration 참조)
      >> WebClientCustomizer
      >> 빈 재정의

 =======================================================================

 - 사실 customizing 을 하지 않아도 크게 문제는 없다.
 - defaultCookie, defaultHeader 등등 ... 설정 가능

 >> builder ~ .build() 사이에 여러가지 설정을 할 수 있다.
    (이것은 지역적으로 customizing 하는 방법)

 -> 그렇다면 전역적으로 customizing 하는 방법은 ?

 =======================================================================

 < 전역적으로 customizing >

 (RestTemplate)
 1. HttpClient dependency 주입 (이를 통해 Apache 의 HttpClient 를 사용하게 된다.)
  >> compile('org.apache.httpcomponents:httpclient')
 2. RestTemplateCustomizer 를 반환하는 Bean 을 하나 만들어 주입시킨다 !

 (WebClient)
 1. WebClientCustomizer 를 반환하는 Bean 을 하나 만들어 주입시킨다 !


 */

@SpringBootApplication
public class SpringBootRestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestClientApplication.class, args);
    }
}
