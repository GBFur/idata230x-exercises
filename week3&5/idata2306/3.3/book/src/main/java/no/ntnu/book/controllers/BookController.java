package no.ntnu.book.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.naming.NameNotFoundException;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import no.ntnu.book.Model.Book;

/**
 * REST API Controller
 */
@RestController
@RequestMapping("books")
public class BookController {

  private List<Book> books;

  public BookController() {
    initializeData();
  }

  public void initializeData() {
    this.books = new ArrayList<>();
    this.books.add(new Book(1, "Harry Potter and the Philosopher’s Stone", 1948, 223));
    this.books.add(new Book(2, "Harry Potter and the Chamber of Secrets", 1974, 251));
    this.books.add(new Book(3, "Harry Potter and the Prisoner of Azkaban", 1958, 317));
    this.books.add(new Book(4, "Harry Potter and the Goblet of Fire", 1988, 663));
    this.books.add(new Book(5, "Harry Potter and the Half-Blood Prince", 1998, 607));
  }

  /**
   * Gets all books
   * Send HTTP GET to /books
   * 
   * @return all books stored in the list
   */
  @GetMapping
  @Operation(summary = "Get all books", description = "Gets all books, send HTTP GET to /books")
  public ResponseEntity<List<Book>> listAllBooks() {
    return ResponseEntity.ok(this.books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> findBook(@PathVariable int id) {

    if (id < 0 || id >= books.size() + 1) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    var book = this.books.get(id - 1);
    System.out.println(book);

    return ResponseEntity.ok(book);
  }

  @PostMapping
  public ResponseEntity<Book> createBook(@RequestBody Book book) {

    // How do I return a String message "ii. Error message in the body. For example,
    // 'Title can't be null'" ?
    if (book.title() == null) {
      return ResponseEntity.badRequest().body(null);
    }

    int newBookId = this.books.size() + 1;
    Book newBook = new Book(newBookId, book.title(), book.year(), book.numberOfPages());

    this.books.add(newBook);

    return ResponseEntity.created(URI.create("/books/" + newBook.id())).body(newBook);
  }

  
  @Operation(summary = "Delete a book by id", description = "Delets a book by id", hidden = true)
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    ResponseEntity<String> response;
    if (removeBookFromCollection(id)) {
      response = new ResponseEntity<>(HttpStatus.OK);
    } else {
      response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return response;
  }

  private boolean removeBookFromCollection(int id) {
    Book removedBook = books.remove(id);
    return removedBook != null;
  }

}
