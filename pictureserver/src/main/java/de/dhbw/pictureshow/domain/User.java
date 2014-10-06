package de.dhbw.pictureshow.domain;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class User extends PersistentObject {
  private String name;
    private String email;
    private String vorname;
    private String nachname;
    private String password;

  public String getName() {
    return name;
  }
  public String getEmail(){return email;}
    public String getVorname(){return vorname;}
    public String getNachname(){return nachname;}
    public String getPassword(){return password;}


  public void setName(String name) {
    this.name = name;
  }
    public void setEmail (String email) {this.email=email;}
    public void setVorname (String vorname) {this.vorname=vorname;}
    public void setNachname (String nachname) {this.nachname=nachname;}
    public void setPassword (String password) {this.password=password;}

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name+ '\'' +
        ", email='" + email + '\'' +
        ", vorname='" + vorname + '\'' +
        ", nachname='" + nachname + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
