package study.codereview.book.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.codereview.book.domain.Book;
import study.codereview.book.domain.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {

    public final BookJpaRepository bookJpaRepository;

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

    @Override
    public boolean existsById(final Long id) {
        return bookJpaRepository.existsById(id);
    }
}
