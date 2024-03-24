package study.codereview.book.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.codereview.book.domain.Book;
import study.codereview.book.domain.BookRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {

    public final BookJpaRepository bookJpaRepository;

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

    @Override
    public Optional<Book> findById(final Long id) {
        return bookJpaRepository.findById(id);
    }
}
