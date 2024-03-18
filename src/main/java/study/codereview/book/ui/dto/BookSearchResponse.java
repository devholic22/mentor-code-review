package study.codereview.book.ui.dto;

import study.codereview.book.domain.Book;

public record BookSearchResponse(
        Long id,
        String name,
        String category,
        int originPrice,
        int discountPrice
) {

    public static BookSearchResponse from(final Book book) {
        return new BookSearchResponse(
                book.getId(),
                book.getName(),
                book.getCategoryTitle(),
                book.getCostValue(),
                book.getCostAfterDiscount()
        );
    }
}
