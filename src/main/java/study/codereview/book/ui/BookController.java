package study.codereview.book.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.codereview.book.application.BookService;
import study.codereview.book.ui.dto.BookSearchResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookSearchResponse>> findAllBooks() {
        List<BookSearchResponse> books = bookService.findAllBooks()
                .stream()
                .map(BookSearchResponse::from)
                .toList();

        return ResponseEntity.ok()
                .body(books);
    }
}
