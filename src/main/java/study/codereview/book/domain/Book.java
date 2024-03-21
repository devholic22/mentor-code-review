package study.codereview.book.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import study.codereview.book.domain.vo.Category;
import study.codereview.book.domain.vo.Cost;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Embedded
    private Cost cost;

    private Book(final String name, final Category category, final Cost cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public static Book createDefault(final String name, final String categoryTitle, final int costValue) {
        Category category = Category.findByTitle(categoryTitle);
        Cost cost = Cost.from(costValue);

        return new Book(name, category, cost);
    }

    public int getCostAfterDiscount() {
        int afterDiscountValue = category.calculateAfterDiscount(cost.getCost());
        Cost costAfterDiscount = cost.updateCost(afterDiscountValue);
        return costAfterDiscount.getCost();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategoryTitle() {
        return category.getTitle();
    }

    public int getCostValue() {
        return cost.getCost();
    }
}
