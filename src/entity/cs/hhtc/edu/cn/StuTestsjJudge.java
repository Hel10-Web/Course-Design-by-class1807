package entity.cs.hhtc.edu.cn;

public class StuTestsjJudge {
    public  int id;
    public  int objectid;
    public  int qjudgeid;
    public  double score;

    public StuTestsjJudge() {
    }

    public StuTestsjJudge(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qjudgeid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjJudge)o)
            return true;
        StuTestsjJudge s=(StuTestsjJudge) o;
        return this.id==s.id;
    }
}
