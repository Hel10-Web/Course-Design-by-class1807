package entity.cs.hhtc.edu.cn;

public class TestForSelect {
    public int qselectid;
    public int paperid;
    public double value;

    public TestForSelect() {
    }

    public TestForSelect(int qselectid, int paperid, double value) {
        this.qselectid = qselectid;
        this.paperid = paperid;
        this.value = value;
    }

    public int hashCode()
    {
        return qselectid;
    }

    public boolean equals(Object o)
    {
        if(this==(TestForSelect)o)
            return true;
        TestForSelect s=(TestForSelect)o;
        return this.qselectid==s.qselectid;
    }
}
