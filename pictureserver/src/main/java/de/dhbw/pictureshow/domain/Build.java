package de.dhbw.pictureshow.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by poetterm on 23.09.2014.
 */
@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class Build extends PersistentObject {
    @Column (length=200)
    private String titel;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public byte[] getDaten() {
        return daten;
    }

    public void setDaten(byte[] daten) {
        this.daten = daten;
    }
    @Lob
    private byte[] daten;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     @ManyToOne
     @JoinColumn(name="user_id")
    private User user;


}
