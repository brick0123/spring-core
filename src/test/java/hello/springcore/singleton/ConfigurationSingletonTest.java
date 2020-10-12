package hello.springcore.singleton;

import hello.springcore.AppConfig;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        MemberRepository memberRepository1 = ((MemberServiceImpl) memberService).getMemberRepository();
        MemberRepository memberRepository2 = ((OrderServiceImpl) orderService).getMemberRepository();
        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository3);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository2).isSameAs(memberRepository3 );
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // class hello.springcore.AppConfig$$EnhancerBySpringCGLIB$$9ac2d718
        // 스프링이 CGLIB라는 바이트코드 조작 라이브러리를   AppConfig 클래스를
        // 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것이다!
    }
}
