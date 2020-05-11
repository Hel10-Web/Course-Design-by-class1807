package entity.cs.hhtc.edu.cn;

public class StuTestsjDesgin {
    public  int id;
    public  int objectid;
    public  int qdesignid;
    public  double score;

    public StuTestsjDesgin() {
    }

    public StuTestsjDesgin(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qdesignid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjDesgin)o)
            return true;
        StuTestsjDesgin s=(StuTestsjDesgin) o;
        return this.id==s.id;
    }
}
