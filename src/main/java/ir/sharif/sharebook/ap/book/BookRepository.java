package ir.sharif.sharebook.ap.book;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Optional<Book> findBookById(Integer id);
    public Iterable<Book> findBookByNameContaining(String name);

    public Iterable<Book> findBookByAuthorContaining(String name);
}
