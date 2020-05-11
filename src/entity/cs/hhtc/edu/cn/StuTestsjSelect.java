package entity.cs.hhtc.edu.cn;

public class StuTestsjSelect {
    public  int id;
    public  int objectid;
    public  int qselectid;
    public  double score;

    public StuTestsjSelect() {
    }

    public StuTestsjSelect(int id, int objectid, int qselectid, double score) {
        this.id = id;
        this.objectid = objectid;
        this.qselectid = qselectid;
        this.score = score;
    }
    public int hashCode()
    {
        return id;
    }
    public boolean equals(Object o)
    {
        if(this==(StuTestsjSelect)o)
            return true;
        StuTestsjSelect s=(StuTestsjSelect) o;
        return this.id==s.id;
    }
}
