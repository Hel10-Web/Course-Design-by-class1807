package entity.cs.hhtc.edu.cn;

public class StuTestsjFillbank {
    public  int id;
    public  int objectid;
    public  int qifllid;
    public  double score;

    public StuTestsjFillbank() {
    }

    public StuTestsjFillbank(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qifllid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjFillbank)o)
            return true;
        StuTestsjFillbank s=(StuTestsjFillbank) o;
        return this.id==s.id;
    }
}
