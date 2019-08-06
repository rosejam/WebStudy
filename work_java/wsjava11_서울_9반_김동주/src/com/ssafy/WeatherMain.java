package com.ssafy;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class WeatherMain {
	JFrame f;
	JButton b;
	JList li;
	String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168065000"; //역삼2동
	WeatherDAO dao;
	
	public WeatherMain() {
		createGUI();
		addEvent();
		dao = WeatherDAO.getInstance();
	}
	
	public void createGUI() {
		f = new JFrame("Weather Info");
		b = new JButton("call Weather");
		
		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();
		
		c.add(b, "North");
		c.add(pane, "Center");
		
		f.setSize(1200, 1200);
		f.setVisible(true);
	}
	public void addEvent() { //버튼 누르는 것이 이벤트(사건)
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
	}
	public void showList(String url) {
		List<Weather> list = dao.getWeatherList(url);
		li.removeAll();
		li.setListData(list.toArray()); //화면에 데이터 뿌려주기
	}
	public static void main(String[] args) {
		new WeatherMain();
	}
}
