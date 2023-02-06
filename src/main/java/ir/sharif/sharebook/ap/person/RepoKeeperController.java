package ir.sharif.sharebook.ap.person;

import ir.sharif.sharebook.ap.purchase.Purchase;
import ir.sharif.sharebook.ap.purchase.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/repository-keeper")
public class RepoKeeperController {
    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping(value = "/get-orders")
    public Iterable<Purchase> getOrders() {
        return purchaseRepository.findByDone(false);
    }
}