package study.codereview.book.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.book.domain.Book;
import study.codereview.book.domain.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
