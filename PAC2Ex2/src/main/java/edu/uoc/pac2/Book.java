package edu.uoc.pac2;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Represents a book with attributes like title, author, genre, etc.
 *
 * @author Arnau López Pagès
 * @version 1.0
 */
public class Book {

    /**
     * Title of the book.
     */
    private String title;

    /**
     * Author of the book.
     */
    private String author;

    /**
     * Genre of the book.
     */
    private String genre;

    /**
     * Publisher of the book.
     */
    private String publisher;

    /**
     * Release date of the book.
     */
    private LocalDate releaseDate;

    /**
     * Language in which the book is written.
     */
    private String language;

    /**
     * ISBN identifier of the book.
     */
    private String isbn;

    /**
     * Price of the book.
     */
    private double price;

    /**
     * Array containing the valid languages for books.
     */
    private final String[] validLanguages = new String[]{"English", "Spanish", "French", "German", "Chinese", "Japanese",
            "Russian", "Arabic", "Portuguese", "Italian"};

    //constructors

    /**
     * @param title       book title
     * @param author      Autor del llibre
     * @param genre       Gènere del llibre
     * @param publisher   Editorial que ha publicat el llibre
     * @param releaseDate Data de publicació del llibre
     * @param language    Idioma del llibre
     * @param isbn        Identificador del llibre
     * @param price       Preu del llibre
     */
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

    /**
     * Rreturns book title.
     *
     * @return book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets book title and throws an exception if its format is incorrect.
     * .
     *
     * @param title book title.
     * @throws Exception [ERROR] Invalid title format.
     */
    public void setTitle(String title) throws Exception {
        //regular expression
        if (title != null && title.matches("^[a-zA-Z\\s-]+$")) {
            this.title = title;
        } else {
            throw new Exception("[ERROR] Invalid title format.");
        }
    }

    /**
     * Returns book author.
     *
     * @return book author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book. Throws an exception if the author is empty.
     *
     * @param author Author of the book
     * @throws Exception If author is empty
     */
    public void setAuthor(String author) throws Exception {
        if (!isEmpty(author)) {
            this.author = author;
        } else {
            throw new Exception("[ERROR] Author cannot be empty.");
        }
    }

    /**
     * Returns the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book. Throws an exception if the genre is empty.
     *
     * @param genre Genre of the book.
     * @throws Exception If genre is empty.
     */
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

    /**
     * Returns the publisher of the book.
     *
     * @return The publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book. Validates the format of the publisher.
     *
     * @param publisher Publisher of the book.
     * @throws Exception If publisher format is invalid.
     */
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

    /**
     * Returns the release date of the book.
     *
     * @return The release date of the book.
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the book. Ensures the release date is valid.
     *
     * @param releaseDate Release date of the book.
     * @throws Exception If release date is not within the last 200 years and not in the future.
     */
    public void setReleaseDate(LocalDate releaseDate) throws Exception {
        LocalDate now = LocalDate.now();
        LocalDate twoHundredYearsAgo = now.minusYears(200);

        if (releaseDate != null && !releaseDate.isAfter(now) && !releaseDate.isBefore(twoHundredYearsAgo)) {
            this.releaseDate = releaseDate;
        } else {
            throw new Exception("[ERROR] Invalid release date. It should be within the last 200 years and not in the future.");
        }
    }

    /**
     * Returns the language of the book.
     *
     * @return The language of the book.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language of the book. Validates if the language is among the accepted languages.
     *
     * @param language Language of the book.
     * @throws Exception If language is invalid.
     */
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

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book. Validates the ISBN format.
     *
     * @param isbn ISBN of the book.
     * @throws Exception If ISBN format is invalid.
     */
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

    /**
     * Returns the price of the book.
     *
     * @return The price of the book.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book. Ensures the price is valid.
     *
     * @param price Price of the book.
     * @throws Exception If price is negative or zero.
     */
    public void setPrice(double price) throws Exception {
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception("[ERROR] Price cannot be neither negative nor zero.");
        }
    }

    /**
     * Returns the valid languages for the books.
     *
     * @return Array of valid languages.
     */
    public String[] getValidLanguages() {
        return validLanguages;
    }

    /**
     * Checks if this book is cheaper than another book.
     *
     * @param otherBook The other book to compare with
     * @return true if this book is cheaper than otherBook, false otherwise
     */
    public boolean isCheaperThan(Book otherBook) {
        if (otherBook != null) {
            return this.price < otherBook.price;
        } else {
            return false;
        }
    }

    /**
     * Checks if this book was written by a specific author.
     *
     * @param authorName The name of the author to check against
     * @return true if the book was written by the given author, false otherwise
     */
    public boolean isWrittenBy(String authorName) {
        return author.equalsIgnoreCase(authorName);
    }

    /**
     * Checks if the book is considered a classic.
     * A classic is defined as a book released more than 50 years ago.
     *
     * @return true if the book is a classic, false otherwise
     */
    public boolean isClassic() {
        LocalDate fiftyYearsAgo = LocalDate.now().minusYears(50);
        return releaseDate.isBefore(fiftyYearsAgo);
    }

    /**
     * Applies a discount to the price of the book and returns the discounted price.
     *
     * @param discountPercentage The percentage of discount to apply
     * @return The discounted price
     */
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