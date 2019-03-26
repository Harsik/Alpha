package com.example.Alpha.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

// Spring 보안은 @AuthenticationPrincipal컨트롤러에서 현재 인증 된 사용자에게 액세스하기 위해 호출되는 주석을 제공합니다 .
// 프로젝트에서 스프링 보안과 관련된 주석을 너무 많이 사용하지 않도록 메타 - 어노테이션을 만들었습니다. 
// 이렇게하면 Spring Security에 대한 의존성이 줄어 듭니다. 
// 따라서 우리가 프로젝트에서 Spring Security를 ​​제거하기로 결정했다면, 
// 단순히 CurrentUser주석을 변경함으로써 쉽게 수행 할 수 있습니다.
// 다음 CurrentUser주석은 주석 주변의 래퍼 @AuthenticationPrincipal입니다.
@Target({ ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}