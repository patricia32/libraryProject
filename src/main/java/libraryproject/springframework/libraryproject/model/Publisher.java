package libraryproject.springframework.libraryproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Publisher() {
    }
    public Publisher(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    @Override
    public String toString() {
        return "publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
