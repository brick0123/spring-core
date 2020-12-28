package hello.springcore.scope;

import static org.assertj.core.api.Assertions.*;

import hello.springcore.scope.SingletonTest.SingletonBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PrototypeTest {

  @Test
  void prototypeBeanFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
    PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

    assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

    ac.close();

  }

  @Scope("prototype")
  static class PrototypeBean {

    @PostConstruct
    void init() {
      System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    void destroy() {
      System.out.println("SingletonBean.destroy");
    }

  }

}
