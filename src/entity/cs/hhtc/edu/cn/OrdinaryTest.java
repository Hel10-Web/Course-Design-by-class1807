package entity.cs.hhtc.edu.cn;

public class OrdinaryTest {
	public int tsttid;
	public int termid;
	public String desc;
	public String begin_time;
	public String end_time;
	public int static_;
	
	public OrdinaryTest(){
		tsttid=0;
		termid=0;
		desc="";
		begin_time="";
		end_time="";
		static_=0;
	}
	public OrdinaryTest(int tsttid,int termid,String desc,String begin_time,String end_time,int static_){
		this.tsttid=tsttid;
		this.termid=termid;
		this.desc=desc;
		this.begin_time=begin_time;
		this.end_time=end_time;
		this.static_=static_;
	}
	public int hashCode(){
		return tsttid;
	}
	public boolean equals(Object o)
	{
		if(this==(OrdinaryTest)o)
			return true;
		OrdinaryTest s=(OrdinaryTest)o;
		return this.tsttid==s.tsttid;
	}
}
