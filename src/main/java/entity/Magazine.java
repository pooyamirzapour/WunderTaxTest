package entity;

import java.time.LocalDate;

public class Magazine extends AbstractBook {

    private LocalDate publishedAt;

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
}
