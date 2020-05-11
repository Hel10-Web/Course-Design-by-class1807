package service.cs.hhtc.edu.cn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entity.cs.hhtc.edu.cn.*;

public class DataBase {
	public Map<Integer,Student> studentMap;
	public Map<Integer,Term>termMap;
	public Map<Integer,OrdinaryTest>ordinaryTestMap;
	public Map<Integer,PaperStruct>paperStructMap;
	public Map<Integer,TestStu>TestStuMap;
	public Map<Integer,TestForSelect> testForSelectMap;
    public Map<Integer,TestForFillbank> testForFillbankMap;
    public Map<Integer,TestForJudge> testForJudgeMap;
    public Map<Integer,TestForAnswer> testForAnswerMap;
    public Map<Integer,TestForCalc> testForCalcMap;
    public Map<Integer,TestFordesign> testFordesignMap;
    public Map<Integer,TestForProgram> testForProgramMap;
    public Map<Integer,StuTestsjAnswer> stuTestsjAnswerMap;
    public Map<Integer,StuTestsjCalc> stuTestsjCalcMap;
    public Map<Integer,StuTestsjDesgin> stuTestsjDesginMap;
    public Map<Integer,StuTestsjFillbank> stuTestsjFillbankMap;
    public Map<Integer,StuTestsjJudge> stuTestsjJudgeMap;
    public Map<Integer,StuTestsjProgram> stuTestsjProgramMap;
    public Map<Integer,StuTestsjSelect> stuTestsjSelectMap;

	public DataBase(){
		studentMap=new HashMap<Integer,Student>();
		termMap=new HashMap<Integer,Term>();
		ordinaryTestMap=new HashMap<Integer,OrdinaryTest>();
		paperStructMap=new HashMap<Integer,PaperStruct>();
		TestStuMap=new HashMap<Integer,TestStu>();
		testForSelectMap = new HashMap<Integer,TestForSelect>();
        testForFillbankMap = new HashMap<Integer,TestForFillbank>();
        testForJudgeMap = new HashMap<Integer,TestForJudge>();
        testForAnswerMap = new HashMap<Integer,TestForAnswer>();
        testForCalcMap = new HashMap<Integer,TestForCalc>();
        testFordesignMap = new HashMap<Integer,TestFordesign>();
        testForProgramMap = new HashMap<Integer,TestForProgram>();
        stuTestsjAnswerMap = new HashMap<Integer,StuTestsjAnswer>();
        stuTestsjCalcMap = new HashMap<Integer,StuTestsjCalc>();
        stuTestsjDesginMap = new HashMap<Integer,StuTestsjDesgin>();
        stuTestsjFillbankMap = new HashMap<Integer,StuTestsjFillbank>();
        stuTestsjJudgeMap = new HashMap<Integer,StuTestsjJudge>();
        stuTestsjProgramMap = new HashMap<Integer,StuTestsjProgram>();
        stuTestsjSelectMap = new HashMap<Integer,StuTestsjSelect>();
        getAllData();
	}
	
	private BufferedReader getBufferedReader(String fileName) throws IOException
	{
		File f=new File("");
		String path=f.getCanonicalPath()+"/src/";
		try{
		BufferedReader dis=new BufferedReader(new InputStreamReader(
				new FileInputStream(path+fileName)));
		return dis;
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	private Map<Integer,Student> readStudentMap(String studentFileName)
	{
		try {
			BufferedReader dis = getBufferedReader(studentFileName);
			
			int i = 0;
			String line;
			while ((line = dis.readLine()) != null) {
				////System.out.println(line);
				String[] att = line.split("\t");
				if(att.length<4)continue;
				int id = Integer.parseInt(att[0]);
				String name = att[1];
				//char ch[] = att[2].toCharArray();
				String grade = att[3];///Integer.parseInt(att[3]);
				Student u = new Student(id, name, att[2].charAt(0), grade);
				studentMap.put(id, u);
			}
			return studentMap;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	return null;
	}
	private Map<Integer,Term> readtermMap(String termFileName)
	{
		try {
			BufferedReader dis = getBufferedReader(termFileName);
			
			int i = 0;
			String line;
			while ((line = dis.readLine()) != null) {
				////System.out.println(line);
				String[] att = line.split("\t");
				if(att.length<4)continue;
				int termid = Integer.parseInt(att[0]);
				int year = Integer.parseInt(att[1]);
				//char ch[] = att[2].toCharArray();
				int term = Integer.parseInt(att[2]);
				String desc = att[3];///Integer.parseInt(att[3]);
				Term u = new Term(termid,year,term,desc);
				termMap.put(termid, u);
			}
			return termMap;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	return null;
	}
	private Map<Integer,OrdinaryTest> readordinaryTestMap(String ordinaryFileName)
	{
		try {
			BufferedReader dis = getBufferedReader(ordinaryFileName);
			
			int i = 0;
			String line;
			while ((line = dis.readLine()) != null) {
				////System.out.println(line);
				String[] att = line.split("\t");
				if(att.length<6)continue;
				int tsttid = Integer.parseInt(att[0]);
				int termid = Integer.parseInt(att[1]);
				String desc=att[2];
				String begin_time=att[3];
				String end_time=att[4];
				int static_ = Integer.parseInt(att[5]);
				//char ch[] = att[2].toCharArray();
				//String grade = att[3];///Integer.parseInt(att[3]);
				OrdinaryTest u = new OrdinaryTest(tsttid,termid,desc,begin_time,end_time,static_);
				ordinaryTestMap.put(tsttid, u);
			}
			return ordinaryTestMap;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	return null;
	}
	private Map<Integer,PaperStruct> readpaperStructMap(String PaperStructFileName)
	{
		try {
			BufferedReader dis = getBufferedReader(PaperStructFileName);
			
			int i = 0;
			String line;
			while ((line = dis.readLine()) != null) {
				////System.out.println(line);
				String[] att = line.split("\t");
				if(att.length<7)continue;
				int paperid = Integer.parseInt(att[0]);
				int testid = Integer.parseInt(att[1]);
				int intqestiontype = Integer.parseInt(att[2]);
				String title = att[3];
				double value = Double.parseDouble(att[4]);
				int index = Integer.parseInt(att[5]);
				int number = Integer.parseInt(att[6]);
				//char ch[] = att[2].toCharArray();
				///Integer.parseInt(att[3]);
				PaperStruct u = new PaperStruct(paperid,testid,intqestiontype,title,value,index,number);
				paperStructMap.put(paperid, u);
			}
			return paperStructMap;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	return null;
	}
	private Map<Integer, TestForSelect> readtestForSelectMap(String testForSelectFileName) {
        try {
            BufferedReader dis = getBufferedReader(testForSelectFileName);
            int i = 0;
            String line;
            while ((line = dis.readLine()) != null) {
                System.out.println(line);
                String[] att = line.split("\t");
                if (att.length < 3) continue;
                int qselectid = Integer.parseInt(att[0]);
                int paperid = Integer.parseInt(att[1]);
                double  value = Double.parseDouble(att[2]);
                //char ch[] = att[2].toCharArray();
                TestForSelect u = new TestForSelect(qselectid, paperid, value);
                testForSelectMap.put(qselectid, u);
            }
            return testForSelectMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	private Map<Integer,TestStu> readTestStuMap(String TestStuFileName)
	{
		try {
			BufferedReader dis = getBufferedReader(TestStuFileName);
			
			int i = 0;
			String line;
			while ((line = dis.readLine()) != null) {
				////System.out.println(line);
				String[] att = line.split("\t");
				if(att.length<5)continue;
				int objectid = Integer.parseInt(att[0]);
				int stuid = Integer.parseInt(att[1]);
				int testid = Integer.parseInt(att[2]);
				String enter_time = att[3];
				String ip = att[4];
				//char ch[] = att[2].toCharArray();
			   ///Integer.parseInt(att[3]);
				TestStu u = new TestStu(objectid,stuid,testid,enter_time,ip);
				TestStuMap.put(objectid, u);
			}
			return TestStuMap;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	return null;
	}
	private Map<Integer, PaperStruct> readPaperStructMap(String paperStructFileName) {
        try {
            BufferedReader dis = getBufferedReader(paperStructFileName);
            int i = 0;
            String line;
            while ((line = dis.readLine()) != null) {
                ////System.out.println(line);
                String[] att = line.split("\t");
                if (att.length < 7) continue;
                int paperid = Integer.parseInt(att[0]);
                int testid = Integer.parseInt(att[1]);
                //char ch[] = att[2].toCharArray();
                int qestiontype = Integer.parseInt(att[2]);
                String title=att[3];
              double value=Double.parseDouble(att[4]);
                int index=Integer.parseInt(att[5]);
                int number=Integer.parseInt(att[6]);

              PaperStruct u = new PaperStruct(paperid, testid, qestiontype, title,value,index,number);
                paperStructMap.put(paperid, u);
            }
            return paperStructMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	private Map<Integer, TestForFillbank> readtestForFillblankMap(String testForFillblankFileName) {
        try {
            BufferedReader dis = getBufferedReader(testForFillblankFileName);
            int i = 0;
            String line;
            while ((line = dis.readLine()) != null) {
                System.out.println(line);
                String[] att = line.split("\t");
                if (att.length < 3) continue;
                int qfillid = Integer.parseInt(att[0]);
                int paperid = Integer.parseInt(att[1]);
                double  value = Double.parseDouble(att[2]);
                //char ch[] = att[2].toCharArray();
                TestForFillbank u = new TestForFillbank(qfillid, paperid, value);
                testForFillbankMap.put(qfillid, u);
            }
            return testForFillbankMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	private Map<Integer, TestForJudge> readtestForJudgeMap(String testForFillJudgeFileName) {
        try {
            BufferedReader dis = getBufferedReader(testForFillJudgeFileName);
            int i = 0;
            String line;
            while ((line = dis.readLine()) != null) {
                System.out.println(line);
                String[] att = line.split("\t");
                if (att.length < 3) continue;
                int qjudgeid = Integer.parseInt(att[0]);
                int paperid = Integer.parseInt(att[1]);
                double  value = Double.parseDouble(att[2]);
                //char ch[] = att[2].toCharArray();
                TestForJudge u = new TestForJudge(qjudgeid, paperid, value);
                testForJudgeMap.put(qjudgeid, u);
            }
            return testForJudgeMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	private Map<Integer, TestForProgram> readtestForProgramMap(String testForProgramFileName) {
	        try {
	            BufferedReader dis = getBufferedReader(testForProgramFileName);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 3) continue;
	                int qprgramid = Integer.parseInt(att[0]);
	                int paperid = Integer.parseInt(att[1]);
	                double  value = Double.parseDouble(att[2]);
	                //char ch[] = att[2].toCharArray();
	                TestForProgram u = new TestForProgram(qprgramid, paperid, value);
	                testForProgramMap.put(qprgramid, u);
	            }
	            return testForProgramMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, TestForAnswer> readtestForAnswerMap(String testForAnswerFile) {
	        try {
	            BufferedReader dis = getBufferedReader(testForAnswerFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 3) continue;
	                int qanswerid = Integer.parseInt(att[0]);
	                int paperid = Integer.parseInt(att[1]);
	                double  value = Double.parseDouble(att[2]);
	                //char ch[] = att[2].toCharArray();
	                TestForAnswer u = new TestForAnswer(qanswerid, paperid, value);
	                testForAnswerMap.put(qanswerid, u);
	            }
	            return testForAnswerMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, TestForCalc> readtestForCalcMap(String testForCalcFile) {
	        try {
	            BufferedReader dis = getBufferedReader(testForCalcFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 3) continue;
	                int qcalculateid = Integer.parseInt(att[0]);
	                int paperid = Integer.parseInt(att[1]);
	                double  value = Double.parseDouble(att[2]);
	                //char ch[] = att[2].toCharArray();
	             TestForCalc u = new TestForCalc(qcalculateid, paperid, value);
	                testForCalcMap.put(qcalculateid, u);
	            }
	            return testForCalcMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, TestFordesign> readtestForDesignMap(String testForDesignFile) {
	        try {
	            BufferedReader dis = getBufferedReader(testForDesignFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 3) continue;
	                int qdesignid = Integer.parseInt(att[0]);
	                int paperid = Integer.parseInt(att[1]);
	                double  value = Double.parseDouble(att[2]);
	                //char ch[] = att[2].toCharArray();
	               TestFordesign u = new TestFordesign(qdesignid, paperid, value);
	                testFordesignMap.put(qdesignid, u);
	            }
	            return testFordesignMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer,StuTestsjAnswer> readstuTestsjAnswerMap(String stuTestsjAnswerFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjAnswerFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[2]);
	                int qanswerid =Integer.parseInt(att[1]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	             StuTestsjAnswer u = new StuTestsjAnswer(id, objectid, qanswerid,score);
	                stuTestsjAnswerMap.put(id, u);
	            }
	            return stuTestsjAnswerMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, StuTestsjCalc> readstuTestsjCalcMap(String stuTestsjCalcFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjCalcFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[1]);
	                int qselectid =Integer.parseInt(att[2]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	               StuTestsjCalc u = new StuTestsjCalc(id, objectid, qselectid,score);
	                stuTestsjCalcMap.put(id, u);
	            }
	            return stuTestsjCalcMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, StuTestsjDesgin> readstuTestsjDesginMap(String stuTestsjDesginFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjDesginFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[1]);
	                int qdesignid =Integer.parseInt(att[2]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	               StuTestsjDesgin u = new StuTestsjDesgin(id, objectid, qdesignid,score);
	                stuTestsjDesginMap.put(id, u);
	            }
	            return stuTestsjDesginMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, StuTestsjFillbank> readstuTestsjFillblankMap(String stuTestsjFillblankFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjFillblankFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[2]);
	                int qifllid =Integer.parseInt(att[1]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	               StuTestsjFillbank u = new StuTestsjFillbank(id, objectid, qifllid,score);
	                stuTestsjFillbankMap.put(id, u);
	            }
	            return stuTestsjFillbankMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, StuTestsjJudge> readstuTestsjJudgeMap(String stuTestsjJudgeFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjJudgeFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[2]);
	                int qjudgeid =Integer.parseInt(att[1]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	               StuTestsjJudge u = new StuTestsjJudge(id, objectid, qjudgeid,score);
	                stuTestsjJudgeMap.put(id, u);
	            }
	            return stuTestsjJudgeMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer,StuTestsjProgram> readstuTestsjProgrameMap(String stuTestsjProgramFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjProgramFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[2]);
	                int qprogramid =Integer.parseInt(att[1]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	                StuTestsjProgram u = new StuTestsjProgram(id, objectid, qprogramid,score);
	                stuTestsjProgramMap.put(id, u);
	            }
	            return stuTestsjProgramMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 private Map<Integer, StuTestsjSelect> readstuTestsjSelectMap(String stuTestsjSelectFile) {
	        try {
	            BufferedReader dis = getBufferedReader(stuTestsjSelectFile);
	            int i = 0;
	            String line;
	            while ((line = dis.readLine()) != null) {
	                System.out.println(line);
	                String[] att = line.split("\t");
	                if (att.length < 4) continue;
	                int id = Integer.parseInt(att[0]);
	                int objectid = Integer.parseInt(att[2]);
	                int qselectid =Integer.parseInt(att[1]);
	                double score =Double.parseDouble(att[3]);
	                //char ch[] = att[2].toCharArray();
	                StuTestsjSelect u = new StuTestsjSelect(id, objectid, qselectid,score);
	                stuTestsjSelectMap.put(id, u);
	            }
	            return stuTestsjSelectMap;
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	public void getAllData()
	{
		studentMap=readStudentMap("t_student.txt");
		termMap=readtermMap("t_term.txt");
		ordinaryTestMap=readordinaryTestMap("t_ordinary_test.txt");
		paperStructMap=readpaperStructMap("t_paper_struct.txt");
		TestStuMap=readTestStuMap("t_test_stu.txt");
		testForSelectMap=readtestForSelectMap("t_test_q_for_select.txt");
	       testForFillbankMap=readtestForFillblankMap("t_test_q_for_fillblank.txt");
	       testForJudgeMap=readtestForJudgeMap("t_test_q_for_judge.txt");
	       testForProgramMap=readtestForProgramMap("t_test_q_for_program.txt");
	       testFordesignMap=readtestForDesignMap("t_test_q_for_ana_design.txt");
	       testForCalcMap=readtestForCalcMap("t_test_q_for_calculate.txt");
	       testForAnswerMap=readtestForAnswerMap("t_test_q_for_shortanswer.txt");
	       stuTestsjAnswerMap= readstuTestsjAnswerMap("t_stu_test_sj_for_sanswer.txt");
	       stuTestsjCalcMap= readstuTestsjCalcMap("t_stu_testsj_for_calculate.txt");
	       stuTestsjDesginMap= readstuTestsjDesginMap("t_stu_testsj_for_design.txt");
	       stuTestsjFillbankMap= readstuTestsjFillblankMap("t_stu_testsj_for_fillblank.txt");
	       stuTestsjJudgeMap= readstuTestsjJudgeMap("t_stu_testsj_for_judge.txt");
	       stuTestsjProgramMap= readstuTestsjProgrameMap("t_stu_testsj_for_program.txt");
	       stuTestsjSelectMap= readstuTestsjSelectMap("t_stu_testsj_for_select.txt");

	}
	public static void main(String[] args)
	{
		DataBase d=new DataBase();
		d.getAllData();
		for(Map.Entry<Integer, TestStu> m:d.TestStuMap.entrySet())
		{
			System.out.println(m.getValue().objectid);
		}
	}
	 public List<OrdinaryTest> getOrdinaryTestListByTerm(Integer termid) {
	        List<OrdinaryTest> list = new ArrayList<OrdinaryTest>();
	        for (OrdinaryTest o : ordinaryTestMap.values())
	            if (o.termid == termid)
	                list.add(o);
	        return list;


	    }

	    public List<Integer> getTermList() {
	        List<Integer> list = new ArrayList<Integer>();
	        for (Term t : termMap.values()) {
	            list.add(t.termid);
	        }
	        return list;
	    }

	    public  List<PaperStruct>getTestPaperListByTestId(int testid)
	    {
	        List<PaperStruct>list=new ArrayList<PaperStruct>();
	        for(Map.Entry<Integer,PaperStruct>p:paperStructMap.entrySet())
	            if(p.getValue().testid==testid)
	                    list.add(p.getValue());
	        Collections.sort(list, new Comparator<PaperStruct>() {
	            @Override
	            public int compare(PaperStruct p1, PaperStruct p2) {
	                return p1.index-p2.index;
	            }
	        });
	        return list;
	    }
	    public List<String>getTestPaperTileListByPaperList(List<PaperStruct>list)
	    {
	        List<String>p1=new ArrayList<String>();
	        String str="";
	        String[] iterNo={"一","二","三","四","五","六","七","八","九","十"};
	        int i =0;
	        for(PaperStruct p:list )
	        {
	            str=iterNo[p.index-1]+"、"+p.title+"(共"+p.value+"分)";
	            p1.add(str);
	        }
	        String line="";
	        for(String s:p1)
	        line=line+"\t";
	        System.out.println(line);
	        return p1;
	    }
	    private List<TestStu>getTestStudentListByTestId(int testid)
	    {
	        List<TestStu>list =new ArrayList<TestStu>();
	        for(TestStu  ts:TestStuMap.values())
	            if(ts.testid==testid)
	                list.add(ts);
	          return list;
	    }
	    public List<String> getTestStudentScoreByPaperList(int testid)
	    {
	        List<String> datas=new ArrayList<String>();
	        List<PaperStruct> plist=getTestPaperListByTestId(testid);

	        ////找出所有参加本次作业答题的学生答题情况列表，其中key是题型，而List则是该题型中所有学生答题得分记录列表
	        Map<Integer,List<Object>> testPaperResultList=new HashMap<Integer,List<Object>>();
	        ////找出所有参加此次作业答题的学生答题记录列表
	        List<TestStu> tlist=getTestStudentListByTestId(testid);
	        for(PaperStruct p:plist)
	        {
	            Student s=studentMap.get(p.testid);
	            switch(p.intqestiontype)
	            {
	                case PaperStruct.CHOICE:
	                    List<StuTestsjSelect> selectList=new ArrayList<StuTestsjSelect>();
	                    for(StuTestsjSelect st:stuTestsjSelectMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(st.objectid==ts.objectid)
	                            {
	                                selectList.add(st);
	                                break;
	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)selectList);
	                    break;
	                case PaperStruct.FILL:
	                    List<StuTestsjFillbank> fillList=new ArrayList<StuTestsjFillbank>();
	                    for(StuTestsjFillbank sf:stuTestsjFillbankMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sf.objectid==ts.objectid)
	                            {
	                                fillList.add(sf);
	                                break;
	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)fillList);
	                    break;
	                case PaperStruct.ANSWER:
	                    List<StuTestsjAnswer> answerList=new ArrayList<StuTestsjAnswer>();
	                    for(StuTestsjAnswer sa:stuTestsjAnswerMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sa.objectid==ts.objectid)
	                            {
	                                answerList.add(sa);
	                                break;
	                            }

	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)answerList);
	                    break;
	                case PaperStruct.CALCULATE:
	                    List<StuTestsjCalc> calculateList=new ArrayList<StuTestsjCalc>();
	                    for(StuTestsjCalc sc:stuTestsjCalcMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sc.objectid==ts.objectid)
	                            {
	                                calculateList.add(sc);
	                                break;

	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)calculateList);
	                    break;
	                case PaperStruct.DESIGN:
	                    List<StuTestsjDesgin> designList=new ArrayList<StuTestsjDesgin>();
	                    for(StuTestsjDesgin sd:stuTestsjDesginMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sd.objectid==ts.objectid)
	                            {
	                                designList.add(sd);
	                                break;
	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)designList);
	                    break;
	                case PaperStruct.JUDGE:
	                    List<StuTestsjJudge> judgeList=new ArrayList<StuTestsjJudge>();
	                    for(StuTestsjJudge sj:stuTestsjJudgeMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sj.objectid==ts.objectid){
	                                judgeList.add(sj);
	                                break;
	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)judgeList);
	                    break;
	                case PaperStruct.PROGRAM:
	                    List<StuTestsjDesgin> programList=new ArrayList<StuTestsjDesgin>();
	                    for(StuTestsjDesgin sp:stuTestsjDesginMap.values())
	                    {
	                        for(TestStu ts:tlist)
	                            if(sp.objectid==ts.objectid)
	                            {
	                                programList.add(sp);
	                                break;
	                            }
	                    }
	                    testPaperResultList.put(p.intqestiontype, (List)programList);
	                    break;
	            }
	        }
	        DecimalFormat df = new DecimalFormat("0.0");
	        double sum=0.0;
	        for(TestStu ts:tlist)
	        {
	            Student s=studentMap.get(ts.stuid);
	            String oneRecord=""+s.stuid+"\t"+s.name+"\t"+s.sex+"\t";
	            double score=0.0;
	            for(Map.Entry<Integer,List<Object>> rl:testPaperResultList.entrySet())
	            {
	                Integer key=rl.getKey();
	                switch(key)
	                {
	                    case PaperStruct.ANSWER:
	                        List<Object> aList=(List<Object>)rl.getValue();
	                        for(Object o:aList)
	                        {
	                            StuTestsjAnswer sa=(StuTestsjAnswer)o;
	                            if(sa.objectid==ts.objectid)
	                                score=score+sa.score;
	                        }
	                        break;
	                    case PaperStruct.CALCULATE:
	                        List<Object> cList=(List<Object>)rl.getValue();
	                        for(Object o:cList)
	                        {
	                            StuTestsjCalc sc=(StuTestsjCalc)o;
	                            if(sc.objectid==ts.objectid)
	                                score=score+sc.score;
	                        }
	                        break;
	                    case PaperStruct.CHOICE:
	                        List<Object> sList=(List<Object>)rl.getValue();
	                        for(Object o:sList)
	                        {
	                            StuTestsjSelect ss=(StuTestsjSelect)o;
	                            if(ss.objectid==ts.objectid)
	                                score=score+ss.score;
	                        }
	                        break;
	                    case PaperStruct.DESIGN:
	                        List<Object> dList=(List<Object>)rl.getValue();
	                        for(Object o:dList)
	                        {
	                            StuTestsjDesgin sd=(StuTestsjDesgin)o;
	                            if(sd.objectid==ts.objectid)
	                                score=score+sd.score;
	                        }
	                        break;
	                    case PaperStruct.FILL:
	                        List<Object> fList=(List<Object>)rl.getValue();
	                        for(Object o:fList)
	                        {
	                            StuTestsjFillbank sf=(StuTestsjFillbank)o;
	                            if(sf.objectid==ts.objectid)
	                                score=score+sf.score;
	                        }
	                        break;
	                    case PaperStruct.JUDGE:
	                        List<Object> jList=(List<Object>)rl.getValue();
	                        for(Object o:jList)
	                        {
	                            StuTestsjJudge sj=(StuTestsjJudge)o;
	                            if(sj.objectid==ts.objectid)
	                                score=score+sj.score;
	                        }
	                        break;
	                    case PaperStruct.PROGRAM:
	                        List<Object> pList=(List<Object>)rl.getValue();
	                        for(Object o:pList)
	                        {
	                            StuTestsjProgram  sp=(StuTestsjProgram)o;
	                            if(sp.objectid==ts.objectid)
	                                score+=sp.score;
	                        }
	                        break;
	                }
	                oneRecord=oneRecord+df.format(score)+"\t";
	                sum+=score;
	                score=0.0;
	            }
	            oneRecord=oneRecord+df.format(sum);
	            datas.add(oneRecord);
	            oneRecord="";
	            sum=0.0;

	        }
	        return datas;
	    }
}