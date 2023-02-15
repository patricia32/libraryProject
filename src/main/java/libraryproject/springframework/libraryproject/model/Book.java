package libraryproject.springframework.libraryproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn="";
    private Integer pagesNumber;
    private String genres;
    private Boolean bestseller = Boolean.FALSE;
    private String imagePath1="";
    private String imagePathth="";
    private String language;
    private String description = " ";
    private Boolean newReleases = Boolean.FALSE;

    private String publisher;
    private Integer price;

    private String authors;

    public Book() {
    }
    public Book(String title, String isbn, Integer pagesNumber, String genres, Integer price, String language) {
        this.title = title;
        this.isbn = isbn;
        this.pagesNumber = pagesNumber;
        this.genres = genres;
        this.price = price;
        this.language = language;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getAuthors() {
        return authors;
    }
    public Integer getPagesNumber() {
        return pagesNumber;
    }
    public String getGenres() {
        return genres;
    }
    public String getPublisher() {
        return publisher;
    }
    public Integer getPrice() {
        return price;
    }
    public Boolean getbestseller(){return bestseller;}
    public Boolean getnewReleases(){return newReleases;}
    public String getImagePath1(){return imagePath1;}
    public String getImagePathth(){return imagePathth;}
    public String getLanguage(){return language;}
    public String getDescription(){return description;}

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setBestseller(Boolean bestseller){this.bestseller = bestseller;}
    public void setnewReleases(Boolean newReleases){this.newReleases = newReleases;}
    public void setLanguage(String language){this.language = language;}
    public void setImagePathth(String imagePathth){this.imagePathth= imagePathth;}
    public void setImagePath1(String imagePath1){this.imagePath1= imagePath1;}
    public void setDescription(String description){this.description= description;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
