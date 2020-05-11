package entity.cs.hhtc.edu.cn;

public class StuTestsjProgram {
    public  int id;
    public  int objectid;
    public  int qprogramid;
    public  double score;

    public StuTestsjProgram() {
    }

    public StuTestsjProgram(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qprogramid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjProgram)o)
            return true;
        StuTestsjProgram s=(StuTestsjProgram) o;
        return this.id==s.id;
    }
}
