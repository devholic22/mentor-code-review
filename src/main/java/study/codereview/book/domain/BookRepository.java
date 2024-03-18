package study.codereview.book.domain;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
}
