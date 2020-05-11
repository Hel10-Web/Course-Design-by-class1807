package entity.cs.hhtc.edu.cn;

public class TestForAnswer {
    public int qanswerid;
    public int paperid;
    public double value;

    public TestForAnswer() {
    }

    public TestForAnswer(int qjudgeid, int paperid, double value) {
        this.qanswerid = qjudgeid;
        this.paperid = paperid;
        this.value = value;
    }
    public int hashCode()
    {
        return qanswerid;
    }
    public boolean equals(Object o)
    {
        if(this==(TestForAnswer)o)
            return true;
        TestForAnswer s=(TestForAnswer)o;
        return this.qanswerid ==s.qanswerid;
    }
}
