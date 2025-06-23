
package in.juvanta.review_ingestion_service.model;

import java.io.Serializable;

public class Reviewer implements Serializable {
    private String id;
    private String name;
    private String photoUrl;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
