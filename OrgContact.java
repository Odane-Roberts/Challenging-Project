package sub;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrgContact implements Contact{
    private String Name;
    private String number;
    private String address;
    private LocalDateTime created;
    private LocalDateTime edit;
    private OrgContact contact;

    List<Contact> contactList = new ArrayList<>();

    Scanner scn = new Scanner(System.in);
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

    public OrgContact(String name, String address, String number, LocalDateTime created, LocalDateTime now) {
        this.number = number;
        Name = name;
        this.address = address;
        this.created = created;
        this.edit = now;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void createContact() {
        System.out.print("Enter organization name: ");
        String name = scn.nextLine();


        System.out.print("Enter organization address: ");
        String address = scn.nextLine();

        System.out.print("Enter organization number: ");
        String telephone = scn.nextLine();
        if(checkNumber(telephone)){

        } else {
            System.out.println("Wrong number format");
            telephone = "[no number]";
        }
        contact = new OrgContact(name,address,telephone, LocalDateTime.now().withSecond(0).withNano(0),LocalDateTime.now().withSecond(0).withNano(0));
        contactList.add(contact);
        System.out.print("The record added.\n");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void updateContact() {
        System.out.print("What do you want to update: \t-> ADDRESS\t-> NUMBER");
        String action = scn.nextLine().toUpperCase();
        switch (action){
            case "ADDRESS":
                System.out.print("Enter New Address");
                this.setAddress(scn.nextLine());
                System.out.println("The record updated!");
                break;
            case "NUMBER":
                System.out.print("Enter new Number: ");
                String number = scn.nextLine();
                if (checkNumber(number)) {
                    this.setNumber(number);
                } else {
                    this.setNumber("[no number]");
                }
                System.out.println("The record updated!");
                break;
            default:
                throw new IllegalArgumentException("Error wrong response "+action);
        }
    }

    @Override
    public void countContacts() {
        System.out.println("The Phone Book has "+contactList.size() +" records.");
    }

    @Override
    public void removeContacts() {
        if(contactList.size() < 1){
            System.out.println("No records to remove");
        } else {
            listContacts();
            System.out.print("Select A record : ");
            int record = Integer.parseInt(scn.nextLine());
            if (contactList.size() < 1) {
                System.out.println("no records to delete");

            } else {
                try {
                    contactList.remove(--record);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Contact doesn't exist");
                }
            }
        }
    }

    @Override
    public void info() {
        if (contactList.size() < 1) {
            System.out.println("No record available!");
        } else {
            listContacts();
            System.out.print("Select A record : ");
            int record = Integer.parseInt(scn.nextLine());
            if (contactList.size() < 1) {
                System.out.println("no records view");

            } else {
                try {
                    contact = (OrgContact) contactList.get(record);
                    System.out.println("Organization name: " + contact.getName());
                    System.out.println("Address: " + contact.address);
                    System.out.println("Number: " + contact.getNumber());
                    System.out.println("Time created: " + contact.created);
                    System.out.println("Time last edit: " + contact.edit);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Contact doesn't exist");
                }
            }
        }
    }

    @Override
    public void listContacts() {
        if (contactList.size() < 1) {
            System.out.println("No contacts to display");
        } else {
            for (Contact c : contactList) {
                System.out.println(c.toString());
            }
        }
    }
    private Boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ \\-]\\(\\w{2,}\\)|\\w+)([ \\-]\\w{2,})*",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
}
