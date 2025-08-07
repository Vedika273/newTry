package org.example;

import java.util.Objects;

public class Author {
    private String name;
    private String nationality;
    private String email;

    public Author() {
    }

    public Author(String name, String nationality, String email) {
        this.name = name;
        this.nationality = nationality;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(nationality, author.nationality) && Objects.equals(email, author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality, email);
    }

    @Override
    public String toString() {
        return "\n" +
       "Name         : " +  name +"\n" +
       "Nationality  : " +  nationality + "\n" +
       "Email        : " +  email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
