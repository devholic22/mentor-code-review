package study.codereview.discount;

public class DiscountService {
    public int discount(int price) {

        List<DiscountPolicy> discountPolicies = new ArrayList<>();

        int money = 0;
        for (DiscountPolicy discountPolicy : discountPolicies) {
            if(discountPolicy.isDiscountable(book)) {
                    money = discountPolicy.discount(price);
            }
        }
        return 0;
    }
}
