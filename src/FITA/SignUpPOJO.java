package FITA;

public class SignUpPOJO {
    private String name;
    private String password;
    private long phonenum;
    private String email;

    private status stat;
    private int productid;

    public SignUpPOJO(String name, String password, long phonenum, String email, status stat,int productid) {
        this.name = name;
        this.password = password;
        this.phonenum = phonenum;
        this.email = email;
        this.stat = stat;
        this.productid = productid;
    }

    public void setStat(status stat) {
        this.stat = stat;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public status getStat() {
        return stat;
    }

    public void setStatus(status stata) {
        this.stat = stat;
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

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
