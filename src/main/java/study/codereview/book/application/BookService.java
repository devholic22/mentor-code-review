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

    // TODO: 3layer 아키텍처가 왜나왔는지, 헥사고날은 무엇이 다른지?
    // TODO: service는 service를 호출하면 안되는가?
    // discount service
    private final BookRepository bookRepository;

    public List<Book> findAllBooksWithDiscount() {
        // discount service
        return bookRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
