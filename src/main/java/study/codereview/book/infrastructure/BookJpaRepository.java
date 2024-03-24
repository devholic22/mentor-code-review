package study.codereview.book.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.book.domain.Book;

import java.util.List;
import java.util.Optional;

// TODO: 어떤 DB를 사용할 것인지? 약간 신입분들한테는 무리한 그런걸수 있어요.
// RDB는 언제? NoSQL은 언제? NoSQL 중에서 key-value, document 두 가지정도만
// 어떤 data는 어떤 db에 쓰면 좋을지
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Optional<Book> findById(Long id);
}
