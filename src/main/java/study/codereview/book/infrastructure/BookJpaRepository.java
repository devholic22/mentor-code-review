package study.codereview.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.book.domain.Book;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    boolean existsById(Long id);
}
