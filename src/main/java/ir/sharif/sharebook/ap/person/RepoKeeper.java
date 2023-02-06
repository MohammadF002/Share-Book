package ir.sharif.sharebook.ap.person;

import jakarta.persistence.*;


@Entity
public class RepoKeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
