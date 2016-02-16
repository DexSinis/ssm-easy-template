package com.github.ichenkaihua.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_news")
public class TNews {
    @Id
    @Column(name = "newsId")
    private String newsid;

    private String title;

    private String body;

    private String images;

    private String ismultipic;

    private String image;

    private Date date;

    private String istopnews;

    private String categotyid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * @return newsId
     */
    public String getNewsid() {
        return newsid;
    }

    /**
     * @param newsid
     */
    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return images
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * @return ismultipic
     */
    public String getIsmultipic() {
        return ismultipic;
    }

    /**
     * @param ismultipic
     */
    public void setIsmultipic(String ismultipic) {
        this.ismultipic = ismultipic;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return istopnews
     */
    public String getIstopnews() {
        return istopnews;
    }

    /**
     * @param istopnews
     */
    public void setIstopnews(String istopnews) {
        this.istopnews = istopnews;
    }

    /**
     * @return categotyid
     */
    public String getCategotyid() {
        return categotyid;
    }

    /**
     * @param categotyid
     */
    public void setCategotyid(String categotyid) {
        this.categotyid = categotyid;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
}