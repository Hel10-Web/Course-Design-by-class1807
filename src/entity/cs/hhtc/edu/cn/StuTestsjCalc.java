package entity.cs.hhtc.edu.cn;

public class StuTestsjCalc {
    public  int id;
    public  int objectid;
    public  int qcalculateid;
    public  double score;

    public StuTestsjCalc() {
    }

    public StuTestsjCalc(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qcalculateid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjCalc)o)
            return true;
        StuTestsjCalc s=(StuTestsjCalc) o;
        return this.id==s.id;
    }
}
