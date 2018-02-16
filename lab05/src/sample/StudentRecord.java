package sample;

public class StudentRecord {
    private int sid;
    private String fname;
    private String lname;

    public StudentRecord() {}

    public StudentRecord (int sid, String fname, String lname) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
    }


    public int getSid() {
        return this.sid;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }
}
