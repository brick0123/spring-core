package hello.springcore.discount;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements  DiscountPolicy{

    private final int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // enum type은 == 쓰는게 맞음
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
