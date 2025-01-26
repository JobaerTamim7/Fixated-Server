package org.fixated.models.user;

public abstract class User {

    private Integer id;
    private String mail;
    private String name;
    private String password;
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole();
    public void setRole(){
        this.role = getRole();
    }

    public void setWorkerID(String workerID){}
    public void setPhoneNumber(String phone){}
    public void setBranch(String branchCode){}
    public abstract String getBranch();
    public abstract String getWorkerID();
    public abstract String getPhoneNumber();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
