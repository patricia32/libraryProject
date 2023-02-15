package libraryproject.springframework.libraryproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private Integer booksNumber = 0;

    public Author() {
    }

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public String name() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getBooksNumber() {
        return booksNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {this.name = name;}
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setBooksNumber(Integer booksNumber) {
        this.booksNumber = booksNumber;
    }

    public void increaseBooksNumber(){
        this.setBooksNumber(this.getBooksNumber() + 1);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
