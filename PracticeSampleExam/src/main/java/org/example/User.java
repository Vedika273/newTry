package org.example;

public abstract class User {
        private int id;
        private String name;
        private String gender;

        public User(int id, String name, String gender) {
            this.id = id;
            this.name = name;
            this.gender = gender;
        }

        public User() {
            this.id = 0;
            this.name = "";
            this.gender = "";
        }

        public abstract void report(String title, String content);

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


