package study.codereview.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.book.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Optional<Book> findById(Long id);
}
