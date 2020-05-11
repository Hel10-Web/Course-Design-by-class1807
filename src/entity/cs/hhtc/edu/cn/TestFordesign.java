package entity.cs.hhtc.edu.cn;

public class TestFordesign {
    public int qdesignid;
    public int paperid;
    public double value;

    public TestFordesign() {
    }

    public TestFordesign(int qjudgeid, int paperid, double value) {
        this.qdesignid = qjudgeid;
        this.paperid = paperid;
        this.value = value;
    }
    public int hashCode()
    {
        return qdesignid;
    }
    public boolean equals(Object o)
    {
        if(this==(TestFordesign)o)
            return true;
        TestFordesign s=(TestFordesign)o;
        return this.qdesignid ==s.qdesignid;
    }
}
