package entity.cs.hhtc.edu.cn;

public class TestForFillbank {
    public int qfillid;
    public int paperid;
    public double value;

    public TestForFillbank() {

    }

    public TestForFillbank(int qfillid, int paperid, double value) {
        this.qfillid = qfillid;
        this.paperid = paperid;
        this.value = value;
    }

    public int hashCode()
    {
        return qfillid;
    }
     public boolean equals(Object o)
     {
         if(this==(TestForFillbank)o)
             return true;
         TestForFillbank s=(TestForFillbank)o;
         return this.qfillid==s.qfillid;
     }
}
