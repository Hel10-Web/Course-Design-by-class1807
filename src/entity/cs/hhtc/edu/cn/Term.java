package entity.cs.hhtc.edu.cn;

public class Term {
	public int termid;
	public int year;
	public int term;
	public String desc;
	public Term()
	{
		termid=0;
		year=0;
		term=0;
		desc="";
	}
	public Term(int termid,int year,int term,String desc)
	{
		this.termid=termid;
		this.year=year;
		this.term=term;
		this.desc=desc;
	}
	public int hasCode()
	{
		return termid;
	}
	public boolean equals(Object o)
	{
		if(this==(Term)o)
			return true;
		Term t=(Term)o;
		return this.termid==t.termid;
	}
}
