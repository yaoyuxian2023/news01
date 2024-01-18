package cn.atnf.entity;

import java.util.Date;

/**
 * @author Augus
 */
public class User {
    private String uid;
    private String uname;
    private String upassword;
    private String usex;
    private String uemail;
    private Date uregdate;

    public User(String uid, String uname, String upassword, String usex, String uemail, Date uregdate) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.usex = usex;
        this.uemail = uemail;
        this.uregdate = uregdate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public Date getUregdate() {
        return uregdate;
    }

    public void setUregdate(Date uregdate) {
        this.uregdate = uregdate;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", usex=" + usex + ", uemail="
                + uemail + ", uregdate=" + uregdate + "]";
    }

}


