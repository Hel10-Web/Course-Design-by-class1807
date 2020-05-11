package entity.cs.hhtc.edu.cn;

public class TestForJudge {
    public int qjudgeid;
    public int paperid;
    public double value;

    public TestForJudge() {
    }

    public TestForJudge(int qjudgeid, int paperid, double value) {
        this.qjudgeid = qjudgeid;
        this.paperid = paperid;
        this.value = value;
    }
    public int hashCode()
    {
        return qjudgeid;
    }
    public boolean equals(Object o)
    {
        if(this==(TestForJudge)o)
            return true;
        TestForJudge s=(TestForJudge)o;
        return this.qjudgeid==s.qjudgeid;
    }
}
