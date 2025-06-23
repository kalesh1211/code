
package in.juvanta.review_ingestion_service.dto.googleplaces.apify;

import lombok.Data;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Data
public class GooglePlacesReviewResponse {
    private String searchString;
    private String reviewerId;
    private String reviewerUrl;
    private String name;
    private int reviewerNumberOfReviews;
    private boolean isLocalGuide;
    private String reviewerPhotoUrl;
    private String text;
    private String textTranslated;
    private String publishAt;
    private ZonedDateTime publishedAtDate;
    private int likesCount;
    private String reviewId;
    private String reviewUrl;
    private String reviewOrigin;
    private int stars;
    private Double rating;
    private ZonedDateTime responseFromOwnerDate;
    private String responseFromOwnerText;
    private List<String> reviewImageUrls;
    private Map<String, Object> reviewContext;
    private Map<String, Object> reviewDetailedRating;
    private String visitedIn;
    private String originalLanguage;
    private String translatedLanguage;
    private boolean isAdvertisement;
    private String placeId;

    private Location location;
    private String address;
    private String neighborhood;
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String countryCode;

    private String categoryName;
    private List<String> categories;
    private String title;
    private double totalScore;
    private boolean permanentlyClosed;
    private boolean temporarilyClosed;
    private int reviewsCount;
    private String url;
    private String price;
    private String cid;
    private String fid;
    private String imageUrl;
    private ZonedDateTime scrapedAt;
    private String language;

    @Data
    public static class Location {
        private double lat;
        private double lng;
    }
}
