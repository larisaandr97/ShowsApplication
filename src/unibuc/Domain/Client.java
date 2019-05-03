package unibuc.Domain;

import java.util.Date;

public class Client {

    private String username;
    private String name;
    private boolean admin=false;
    protected long telephone;
    protected String mailAddress;
    protected int age;
    boolean student;
    private String status;
    private String password;

    public Client(String username, String name, long telephone, String mailAddress, int age, boolean student, String password) {
        this.username=username;
        this.name = name;
        this.telephone = telephone;
        this.mailAddress = mailAddress;
        this.age=age;
        this.student=student;
        if(age<14)
            this.status="copil";
        else {
            if (this.student)
                this.status = "student";
            else this.status="adult";
        }
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayClientDetails()
    {
        System.out.println("Username: ");
        System.out.print(this.getUsername());
        System.out.println("Name: ");
        System.out.print(this.getName());
        System.out.println("Telephone: ");
        System.out.print(this.getTelephone());
        System.out.println("Mail Address: ");
        System.out.print(this.getMailAddress());
        System.out.println("Student: ");
        if(this.isStudent()==true)
        {
            System.out.print("Yes");
        }
        else System.out.print("No");
    }
}
