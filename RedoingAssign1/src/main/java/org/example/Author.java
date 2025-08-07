package org.example;

public class Author {
    String name;
    String nationality;
    String email;

    public Author(String name, String nationality, String email) {
        this.name = name;
        this.nationality = nationality;
        this.email = email;
    }

    public Author() {
        this.name = "Vedika";
        this.nationality = "unknown";
        this.email = "dsajkk@kjfl";
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
