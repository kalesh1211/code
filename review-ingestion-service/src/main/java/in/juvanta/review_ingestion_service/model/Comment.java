
package in.juvanta.review_ingestion_service.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private String externalId;
    private String text;
    private Reviewer reviewer;
    private Double rating;
    private String date;
    private String relativeDate;
    private String source;
    private String sourceUrl;

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Reviewer getReviewer() { return reviewer; }
    public void setReviewer(Reviewer reviewer) { this.reviewer = reviewer; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getRelativeDate() { return relativeDate; }
    public void setRelativeDate(String relativeDate) { this.relativeDate = relativeDate; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
}
