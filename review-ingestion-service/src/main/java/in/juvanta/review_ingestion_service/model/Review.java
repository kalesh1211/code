package in.juvanta.review_ingestion_service.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @Embeddable
    public static class Location {
        public double lat;
        public double lng;
    }

    @Column(length = 1000)
    public String searchString;

    public String reviewerId;

    @Column(length = 1000)
    public String reviewerUrl;

    public String name;

    public int reviewerNumberOfReviews;

    public boolean isLocalGuide;

    @Column(length = 1000)
    public String reviewerPhotoUrl;

    @Column(columnDefinition = "TEXT")
    public String text;

    @Column(columnDefinition = "TEXT")
    public String textTranslated;

    public String publishAt;

    public String publishedAtDate;

    public int likesCount;

    public String reviewId;

    @Column(length = 1000)
    public String reviewUrl;

    public String reviewOrigin;

    public int stars;

    public Integer rating;

    public String responseFromOwnerDate;

    @Column(columnDefinition = "TEXT")
    public String responseFromOwnerText;

    @ElementCollection
    public List<String> reviewImageUrls;

    @Transient  // Mark as non-persistent
    public Object reviewContext;

    @Transient  // Mark as non-persistent
    public Object reviewDetailedRating;

    public String visitedIn;

    public String originalLanguage;

    public String translatedLanguage;

    public boolean isAdvertisement;

    public String placeId;

    @Embedded
    public Location location;

    public String address;

    public String neighborhood;

    public String street;

    public String city;

    public String postalCode;

    public String state;

    public String countryCode;

    public String categoryName;

    @ElementCollection
    public List<String> categories;

    public String title;

    public double totalScore;

    public boolean permanentlyClosed;

    public boolean temporarilyClosed;

    public int reviewsCount;

    @Column(length = 1000)
    public String url;

    public String price;

    public String cid;

    public String fid;

    @Column(length = 1000)
    public String imageUrl;

    public String scrapedAt;

    public String language;

    private String authorName;

    private java.time.ZonedDateTime publishedDate;

    // Getters and setters
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public java.time.ZonedDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(java.time.ZonedDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    // Add getter for id
    public Long getId() {
        return id;
    }

    // Add setter for id
    public void setId(Long id) {
        this.id = id;
    }
}
