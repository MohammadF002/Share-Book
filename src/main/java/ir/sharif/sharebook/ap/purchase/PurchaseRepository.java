package ir.sharif.sharebook.ap.purchase;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase,Integer> {
    public Iterable<Purchase> findByDone(Boolean done);
}
