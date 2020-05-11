package entity.cs.hhtc.edu.cn;

public class TestForCalc {
    public int qcalculateid;
    public int paperid;
    public double value;

    public TestForCalc() {
    }

    public TestForCalc(int qjudgeid, int paperid, double value) {
        this.qcalculateid = qjudgeid;
        this.paperid = paperid;
        this.value = value;
    }
    public int hashCode()
    {
        return qcalculateid;
    }
    public boolean equals(Object o)
    {
        if(this==(TestForCalc)o)
            return true;
        TestForCalc s=(TestForCalc)o;
        return this.qcalculateid ==s.qcalculateid;
    }
}
