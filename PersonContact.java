package sub;

import java.time.LocalDateTime;

public class PersonContact implements Contact{
    private String fName;
    private String lName;
    private String gender;
    private String dob;
    private String telephone;

    LocalDateTime created;
    LocalDateTime edit;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getEdit() {
        return edit;
    }

    public void setEdit(LocalDateTime edit) {
        this.edit = edit;
    }



    PersonContact(String n, String s, String t, String gen, String dob, LocalDateTime created, LocalDateTime now){
        this.telephone = t;
        this.fName = n;
        this.lName = s;
        this.gender = gen;
        this.dob = dob;
        this.created = created;
        this.edit = now;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setFname(String n){
        this.fName = n;
    }
    public void setLname(String l){
        this.lName = l;
    }
    public void setTelephone(String n){
        this.telephone = n;
    }

    public String getFname(){
        return this.fName;
    }
    public String getLname(){
        return this.lName;
    }
    public String getTelephone(){
        return this.telephone;
    }

    @Override
    public String toString() {
        return
                fName +" "+
                        lName;

    }

    @Override
    public void createContact() {

    }

    @Override
    public void updateContact() {

    }

    @Override
    public void countContacts() {

    }

    @Override
    public void removeContacts() {

    }

    @Override
    public void info() {

    }

    @Override
    public void listContacts() {

    }
}
