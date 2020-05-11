package entity.cs.hhtc.edu.cn;

public class PaperStruct {
	public int paperid;
	public int testid;
	public int intqestiontype;
	public String title;
	public double value;
	public int index;
	public int number;
	public static final int CHOICE=1;
	public static final int MULTICHOICE=2;
	public static final int FILL=3;
	public static final int JUDGE=4;
	public static final int ANSWER=5;
	public static final int CALCULATE=6;
	public static final int DESIGN=7;
	public static final int PROGRAM=8;
	public PaperStruct(){
		paperid=0;
		testid=0;
		intqestiontype=0;
		title="";
		index=0;
		number=0;
	}
	public PaperStruct(int paperid,int testid,int intqestiontype,String title,double value,int index,int number){
		this.paperid=paperid;
		this.testid=testid;
		this.intqestiontype=intqestiontype;
		this.title=title;
		this.value=value;
		this.index=index;
		this.number=number;
		
	}
	public int hashCode(){
		return paperid;
	}
	public boolean equals(Object o)
	{
		if(this==(PaperStruct)o)
			return true;
		PaperStruct s=(PaperStruct)o;
		return this.paperid==s.paperid;
	}
}

