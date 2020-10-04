package hello.springcore;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.order.Order;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        final MemberService memberService = new MemberServiceImpl();
//        final OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }

}
