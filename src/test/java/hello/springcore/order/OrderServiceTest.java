package hello.springcore.order;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iteamA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
