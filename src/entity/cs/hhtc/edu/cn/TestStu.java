package entity.cs.hhtc.edu.cn;

public class TestStu {

	public int objectid;
	public int stuid;
	public int testid;
	public String enter_time;
	public String ip;
	
	public TestStu(){
		objectid=0;
		stuid=0;
		testid=0;
		enter_time="";
		ip="";
	}
	public TestStu(int objectid,int stuid,int testid,String enter_time,String ip)
	{
		this.objectid=objectid;
		this.stuid=stuid;
		this.testid=testid;
		this.testid=testid;
		this.ip=ip;
	}
	
	public int hashCode()
	{
		return objectid;
	}
	
	public boolean equals(Object o)
	{
		if(this==(TestStu)o)
			return true;
		TestStu s=(TestStu)o;
		return this.objectid==s.objectid;
	}
}