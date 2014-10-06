package de.dhbw.pictureshow.domain;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Created by poetterm on 02.10.2014.
 */
public class Picture extends PersistentObject{

    private String title;
    private String username;

    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "uuid")
    private User user;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Picture  " +
                title +" Nutzer: "+ username;
    }
}

