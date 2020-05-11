package entity.cs.hhtc.edu.cn;

public class TestForProgram {
    public int qprgramid;
    public int paperid;
    public double value;

    public TestForProgram() {
    }

    public TestForProgram(int qjudgeid, int paperid, double value) {
        this.qprgramid = qjudgeid;
        this.paperid = paperid;
        this.value = value;
    }
    public int hashCode()
    {
        return qprgramid;
    }
    public boolean equals(Object o)
    {
        if(this==(TestForProgram)o)
            return true;
        TestForProgram s=(TestForProgram)o;
        return this.qprgramid ==s.qprgramid;
    }
}
