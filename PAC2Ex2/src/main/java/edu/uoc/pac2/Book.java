package edu.uoc.pac2;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private LocalDate releaseDate;
    private String language;
    private String isbn;
    private double price;
    private final String[] validLanguages = new String[]{"English", "Spanish", "French", "German", "Chinese", "Japanese",
            "Russian", "Arabic", "Portuguese", "Italian"};

    //constructors
    public Book(String title, String author, String genre, String publisher, LocalDate releaseDate,
                String language, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.language = language;
        this.isbn = isbn;
        this.price = price;
    }

    //getters & setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        //regular expression
        if (title != null && title.matches("^[a-zA-Z\\s-]+$")) {
            this.title = title;
        } else {
            throw new Exception("[ERROR] Invalid title format.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws Exception {
        if (!isEmpty(author)) {
            this.author = author;
        } else {
            throw new Exception("[ERROR] Author cannot be empty.");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) throws Exception {
        if (!isEmpty(genre)) {
            this.genre = genre;
        } else {
            throw new Exception("[ERROR] Genre cannot be empty.");
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws Exception {
        // check if publisher is null
        if (publisher == null) {
            throw new Exception("[ERROR] Invalid publisher format.");
        }
        // Create a regex pattern to check if the publisher contains only allowed characters
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ,.()]+$");

        // Check if the publisher matches the regex pattern
        if (pattern.matcher(publisher).matches()) {
            // If the format is correct, assign the value to the publisher property
            this.publisher = publisher;
        } else {
            // If the format is not correct, throw error
            throw new Exception("[ERROR] Invalid publisher format.");
        }
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate twoHundredYearsAgo = now.minusYears(200);

        if (releaseDate != null && !releaseDate.isAfter(now) && !releaseDate.isBefore(twoHundredYearsAgo)) {
            this.releaseDate = releaseDate;
        } else {
            throw new Exception("[ERROR] Invalid release date. It should be within the last 200 years and not in the future.");
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) throws Exception {
        if (isValidLanguage(language)) {
            this.language = language;
        } else {
            throw new Exception("[ERROR] Invalid language.");
        }
    }

    private boolean isValidLanguage(String language) {
        for (String validLang : validLanguages) {
            if (validLang.equals(language)) {
                return true;
            }
        }
        return false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws Exception {
        if (isbn != null) {
            // delete all characters except numbers
            String buffer = isbn.replaceAll("[^0-9]", "");
            if (buffer.length() == 10 || buffer.length() == 13) {
                this.isbn = buffer;
            } else {
                throw new Exception("[ERROR] Invalid ISBN format.");
            }
        } else {
            throw new Exception("[ERROR] Invalid ISBN format.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception("[ERROR] Price cannot be neither negative nor zero.");
        }
    }

    public String[] getValidLanguages() {
        return validLanguages;
    }

    public boolean isCheaperThan(Book otherBook) {
        if (otherBook != null) {
            return this.price < otherBook.price;
        } else {
            return false;
        }
    }

    public boolean isWrittenBy(String authorName) {
        return author.equalsIgnoreCase(authorName);
    }

    public boolean isClassic() {
        LocalDate fiftyYearsAgo = LocalDate.now().minusYears(50);
        return releaseDate.isBefore(fiftyYearsAgo);
    }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            double discountAmount = (discountPercentage / 100) * price;
            return price - discountAmount;
        } else {
            System.out.println("[ERROR] Invalid discount percentage.");
            return -1;
        }
    }
}