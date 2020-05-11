package entity.cs.hhtc.edu.cn;

public class Student {

	public int stuid;
	public String name;
	public char sex;
	public String grade;
	
	public Student(){
		stuid=0;
		name="";
		sex='\0';
		grade="";
	}
	public Student(int stuid,String name,char sex,String grade)
	{
		this.stuid=stuid;
		this.name=name;
		this.sex=sex;
		this.grade=grade;
	}
	
	public int hashCode()
	{
		return stuid;
	}
	
	public boolean equals(Object o)
	{
		if(this==(Student)o)
			return true;
		Student s=(Student)o;
		return this.stuid==s.stuid;
	}
}