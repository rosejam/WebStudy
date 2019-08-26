package com.ssafy.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f;
	JButton b;
	JList li;
	JTextArea ta; //추가되는 부분
	INewsDAO dao;
	String url = "http://rss.etnews.com/Section902.xml"; 
	
	public NewsMain() {
		createGUI();
		addEvent();
		dao = NewsDAODOMImpl.getInstance(); //
		showList(url);
	}

	public void createGUI() {
		f = new JFrame("NewsList");
		JPanel p = new JPanel();
		b = new JButton("News List 호출");
		
		li = new JList();
		ta = new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b, "North");
		p.add(li);
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);
/*		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();
		
		c.add(b, "North");
		c.add(pane, "Center");*/
		
		JScrollPane pane = new JScrollPane(li);//
		p.add(pane, "Center");//스크롤만 추가함
		
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	public void addEvent() { //버튼 ?��르는 것이 ?��벤트(?���?)
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList(url);
			}
		});
		li.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//int index = li.getSelectedIndex();
				//News n = dao.search(index);
				News n = (News)li.getSelectedValue();
				ta.setText(n.getDesc());
			}
		});
	}
	private void showList(String url) {
		List<News> list = dao.getNewsList(url);
		li.removeAll();
		li.setListData(list.toArray()); 
	}
	public static void main(String[] args) {
		new NewsMain();
	}
}
