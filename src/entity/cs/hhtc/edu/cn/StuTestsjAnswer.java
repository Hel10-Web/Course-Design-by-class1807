package entity.cs.hhtc.edu.cn;

public class StuTestsjAnswer {
    public  int id;
    public  int objectid;
    public  int qanswerid;
    public  double score;

    public StuTestsjAnswer() {
    }

    public StuTestsjAnswer(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qanswerid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjAnswer)o)
            return true;
        StuTestsjAnswer s=(StuTestsjAnswer) o;
        return this.id==s.id;
    }
}
