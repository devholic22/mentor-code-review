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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import study.codereview.book.domain.vo.Category;
import study.codereview.book.domain.vo.Cost;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    // TODO: Integer
    @Column(nullable = false)
    @Embedded
    private Cost cost;
    // TODO: Money 객체로 불변 BigDecimal로 변경

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

    public int getDiscount() {
        return cost.getCost() - category.calculateAfterDiscount(cost.getCost());
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
