package gui.cs.hhtc.edu.cn;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.table.TableColumn;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;

import service.cs.hhtc.edu.cn.DataBase;
///import service.cs.hhtc.edu.cn.DataService;

import java.text.ParseException;
import java.util.List;

import entity.cs.hhtc.edu.cn.*;

public class CourseDesignGUI {
	
	private DataBase data;
	
	
	///private JTable table;
	private JTextArea ta;
	private JComboBox termBox,testBox;
	private boolean flag;
	
	  JFrame frame;
	
	public CourseDesignGUI(DataBase ds)
	{
		flag=false;
		this.data=ds;
		JPanel panel=new JPanel(new BorderLayout());
		  panel.setPreferredSize (new Dimension (600,400));
		  panel.setBackground (Color.black);
		 
		  
		 
		  JPanel midPanel=new JPanel(new BorderLayout());
		  //panel.add (pane1);
		  //panel.add (pane2);
		  //table=new JTable();
		  ta=new JTextArea();
		  ////setTableProperties();
		  /////table.createDefaultRenderers();
		  JScrollPane pane3 = new JScrollPane (ta);
		///����Ͽ򣬱�ʾ����ACM����
		  JLabel termLabel=new JLabel("请选择学期：");
		  termBox=new JComboBox();
		  termBox.show(true);
		  JLabel testLabel=new JLabel("请选择作业：");
		  testBox=new JComboBox();
		  
		  JLabel lable=new JLabel("作业信息统计",SwingConstants.CENTER);
		  lable.setPreferredSize(new Dimension(600,80));
		  lable.setOpaque(true);
		  lable.setBackground(Color.GRAY);
		  JSeparator sep=new JSeparator();
		  JSeparator sepUp=new JSeparator();
		  JPanel pan1=new JPanel();
		  ///pan1.add(sep,BorderLayout.SOUTH);
		  JPanel boxPanel=new JPanel(new FlowLayout());
		  boxPanel.add(termLabel);
		  boxPanel.add(termBox);
		  boxPanel.add(testLabel);
		  boxPanel.add(testBox);
		  ///pan1.add(termBox,BorderLayout.SOUTH);
		  pan1.add(boxPanel,BorderLayout.SOUTH);
		  pan1.add(lable,BorderLayout.CENTER);
		  pan1.add(sepUp,BorderLayout.NORTH);
		  ///midPanel.add(btnPanel,BorderLayout.NORTH);
		  midPanel.add(pan1,BorderLayout.CENTER);
		  //panel.add(pan1,BorderLayout.NORTH);
		  panel.add(midPanel,BorderLayout.NORTH);
		  //panel.add(lable,BorderLayout.NORTH);
		   //panel.add(lable);
		   //panel.add(sep);
		   //panel.add(pane3);
		  panel.add (pane3,BorderLayout.CENTER);
		  
		  frame = new JFrame ("作业信息统计");
		  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		  
		  frame.setContentPane (panel);
		  List<Integer> termList=data.getTermList();
		  System.out.println("terms:"+termList.size());
		  
		for(Integer i:termList)
			termBox.addItem(i);
			  ///termBox.show(true);
		termBox.setVisible(true);
			 // }catch(ParseException e1)
			 // {
			//	  System.out.println(e1.getMessage());
			 // }
			  termBox.addItemListener(new ItemListener(){
				  public void itemStateChanged(ItemEvent e){
					 List<OrdinaryTest> testList=data.getOrdinaryTestListByTerm((Integer)e.getItem());
					 for(OrdinaryTest o:testList)
						 testBox.addItem(o.tsttid);
				  }
			  });
		  testBox.addItemListener(new ItemListener(){
			  public void itemStateChanged(ItemEvent e){
				//1、取得本次作业的大题信息
				  if(e.getStateChange()== ItemEvent.DESELECTED)
	                    return ;
	                List<PaperStruct>p1=data.getTestPaperListByTestId((Integer)e.getItem());
	                List<String>h1=data.getTestPaperTileListByPaperList(p1);
	                String head="学号i\t姓名\t性别\t";
	                ta.setText("");
	                for(String s:h1)
	                    head=head+s+"\t";
	                    head=head+"总分";
	                    ta.append(head+"\n");
	                   List<String>ds=data.getTestStudentScoreByPaperList((Integer)e.getItem());
	                    for(String s:ds)
	                        ta.append(s+"\n");
				  //2、取得本次作业统计信息
			  }

		  });
		  frame.pack();
		  frame.show();
		  
	}
	
	public static void main(String[] args)
	{
		DataBase db=new DataBase();
		///DataService ds=new DataService(db);
		CourseDesignGUI cd=new CourseDesignGUI(db);
	}
	

}
