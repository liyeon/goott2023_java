package com.tech.w01;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NotePad extends JFrame implements ItemListener, ActionListener {
	public static byte[] bytecounter;
	private boolean isButton = false;
	private String name = "굴림";
	private int style = 0;
	private int fontsize = 12;

	JPanel fontPanel1, fontPanel2;
	Choice fontCombo1, fontCombo2, fontCombo3;// Choice준비
	JButton fontConfirm, fontCancel;
	String[] fontList = { "굴림", "굴림체", "궁서", "궁서체", "견고딕", "고딕체", "verdana" };// 폰트 콤보 리스트
	String[] fontStyleList = { "보통", "기울임", "굵게" };
	String[] fontSizeList = { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "30", "40",
			"60" };
	JTextField txtFont, txtFontStyle, txtFontSize;// JTextField준비
	JFrame fontFrame;
	JMenuBar menuBar = new JMenuBar();// 메뉴바 생성
	JMenu mnFile = new JMenu("파일(F)");// 파일메뉴
	JMenu mnEdit = new JMenu("편집(E)");// 편집메뉴
	JMenu mnForm = new JMenu("서식(O)");// 서식메뉴
	JMenu mnHelp = new JMenu("도움말(H)");// 도움말메뉴

	JMenuItem new_m = new JMenuItem("새로만들기(N)");// 새로만들기 항목
	JMenuItem open_m = new JMenuItem("열기(O)");// 열기
	JMenuItem save_m = new JMenuItem("저장(S)");//
	JMenuItem exit_m = new JMenuItem("종료(X)");//
	JMenuItem cut_m = new JMenuItem("잘라내기(T)");//
	JMenuItem copy_m = new JMenuItem("복사하기(C)");//
	JMenuItem paste_m = new JMenuItem("붙여넣기(P)");//
	JMenuItem allsel_m = new JMenuItem("모두선택(A)");//
	JMenuItem del_m = new JMenuItem("삭제(L)");//
	JMenuItem font_m = new JMenuItem("글꼴(F)...");//

	JMenuItem info_m = new JMenuItem("메모장 정보(A)");// 메모장 정보확인
	JMenuItem time_m = new JMenuItem("시간보기");//
	JFileChooser jfc = new JFileChooser();// 다이얼 로그 창 띄우기 클래스
	JScrollPane scrollPane = null;
	JTextArea txtArea = null;
	JTextField txtField = new JTextField();

	public NotePad() {
		setTitle("메모장 - 제목없음 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);

		// 노트패드 컴포넌트 구성
		add(menuBar, "North");
		menuBar.add(mnFile);
		menuBar.add(mnEdit);
		menuBar.add(mnForm);
		menuBar.add(mnHelp);

		// 파일메뉴에 메뉴추가
		mnFile.add(new_m);
		mnFile.add(open_m);
		mnFile.add(save_m);
		mnFile.addSeparator();// 경계선 추가
		mnFile.add(exit_m);

		mnEdit.add(cut_m);
		mnEdit.add(copy_m);
		mnEdit.add(paste_m);
		mnEdit.add(del_m);
		mnEdit.addSeparator();// 경계선 추가
		mnEdit.add(allsel_m);
		mnEdit.add(time_m);

		mnForm.add(font_m);

		mnHelp.add(info_m);
		// 스크롤 나타나게
		scrollPane = new JScrollPane(txtArea = new JTextArea());
		add(scrollPane, "Center");
		add(txtField, "South");
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());// 스크롤바 최하단으로
		validate();

		// font 컴포넌트 추가
		fontFrame = new JFrame("글꼴");
		fontPanel1 = new JPanel();
		fontPanel2 = new JPanel();

		txtFont = new JTextField(10);// 글꼴
		txtFontStyle = new JTextField(8);
		txtFontSize = new JTextField(5);

		fontConfirm = new JButton("확인");
		fontCancel = new JButton("취소");

		// Choice 객체 생성
		fontCombo1 = new Choice();
		fontCombo2 = new Choice();
		fontCombo3 = new Choice();

		// 콤보 상자 리스트 계산
		for (int i = 0; i < fontList.length; i++) {
			fontCombo1.add(fontList[i]);
		}
		for (int i = 0; i < fontStyleList.length; i++) {
			fontCombo2.add(fontStyleList[i]);
		}
		for (int i = 0; i < fontSizeList.length; i++) {
			fontCombo3.add(fontSizeList[i]);
		}

		// choice 초기값 세팅
		fontCombo1.select(0);
		fontCombo2.select(0);
		fontCombo3.select(4);

		// fontPanel에 label jtextField choice 추가
		fontPanel1.setLayout(new GridLayout(3, 3));
		fontPanel1.add(new JLabel("글꼴"));
		fontPanel1.add(new JLabel("글꼴스타일"));
		fontPanel1.add(new JLabel("크기"));
		fontPanel1.add(txtFont);
		fontPanel1.add(txtFontStyle);
		fontPanel1.add(txtFontSize);
		fontPanel1.add(fontCombo1);
		fontPanel1.add(fontCombo2);
		fontPanel1.add(fontCombo3);

		// 확인 취소 버튼 추가
		fontPanel2.setLayout(new GridLayout(3, 1));
		fontPanel2.add(fontConfirm);
		fontPanel2.add(fontCancel);

		// fontFrame에 Fontpanel1,2 추가
		fontFrame.add(fontPanel1, BorderLayout.CENTER);
		fontFrame.add(fontPanel2, BorderLayout.EAST);

		// fontFrame에 닫기 핸들러 부착
		fontFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				fontFrame.setVisible(false);
			}
		});

		// 리스너 부착
		fontConfirm.addActionListener(this);
		fontCancel.addActionListener(this);
		fontCombo1.addItemListener(this);
		fontCombo2.addItemListener(this);
		fontCombo3.addItemListener(this);

		fontFrame.setBounds(300, 300, 300, 100);

		// 이벤트에 리스너 부착
		new_m.addActionListener(this);
		open_m.addActionListener(this);
		save_m.addActionListener(this);
		exit_m.addActionListener(this);
		cut_m.addActionListener(this);
		copy_m.addActionListener(this);
		paste_m.addActionListener(this);
		allsel_m.addActionListener(this);
		del_m.addActionListener(this);
		font_m.addActionListener(this);
		time_m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("시간 정보");
				// textarea에 시간 출력하기
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int hour = cal.get(Calendar.HOUR);
				int minute = cal.get(Calendar.MINUTE);
				int second = cal.get(Calendar.SECOND);
				txtArea.setText(txtArea.getText() + System.lineSeparator() + year + "년" + month + "월" + day + "일" + hour
						+ "시" + minute + "분" + second + "초");
			}// override
		});// time_m
		info_m.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그 띄우기
				JOptionPane.showMessageDialog(null, "만든이 : 김리연 \n company : goott");
			}
		});// info_m
		txtArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {// 키보드를 떼었을 때 이벤트
				String text;
				int length;
				text = txtArea.getText();
				bytecounter = text.getBytes();// 바이트로 변환
				length = bytecounter.length;
				txtField.setText(length + "byte(s)");
				txtField.setHorizontalAlignment(JTextField.RIGHT);// 오른쪽으로 배치
			}// override
		});// txtarea keylistener
		setVisible(true);
	}// Constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String itemPressed = e.getActionCommand();
		if (itemPressed.equals("저장(S)")) {
			if (jfc.showSaveDialog(this) == JFileChooser.CANCEL_OPTION)
				return;
			// 저장 구현
			File f = jfc.getSelectedFile();
			System.out.println("파일저장 : " + f);

			PrintStream ps;
			try {
				ps = new PrintStream(f);
				ps.println(txtArea.getText());// 출력객체를 통해(ps) txtArea내용을 출력(저장)
				ps.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} // try~catch
		} // if
		if (itemPressed.equals("열기(O)")) {// 열기
			if (jfc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION)
				return;
			// 내용 오픈
			File f = jfc.getSelectedFile();
			setTitle(f.getName());
			try {
				FileReader fr = new FileReader(f);
				StringWriter sw = new StringWriter();
				while (true) {
					int ch = fr.read();
					if (ch == -1)
						break;// 파일의 끝
					sw.write(ch);
				} // while
				txtArea.setText(sw.toString());
				sw.close();
				fr.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			} // try~catch
		} // if

		if (itemPressed.equals("새로만들기(N)")) {// 새로만들기
			int r = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);// 확인
			txtArea.setText("");
			if (r == 0) {
				jfc.showSaveDialog(this);
			} // if
		} // if
		if (itemPressed.equals("종료(X)")) {// 종료
			int r = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);// 확인
			txtArea.setText("");
			if (r == 0) {
				jfc.showSaveDialog(this);
			} // if
			System.exit(0);
		} // if
		if (itemPressed.equals("복사하기(C)")) {// 복사하기
			txtArea.copy();
		} // if

		if (itemPressed.equals("붙여넣기(P)")) {// 붙여넣기
			txtArea.paste();
		} // if

		if (e.getSource().equals(font_m)) {// 글꼴
			fontFrame.setVisible(true);
		} // if
		if (e.getSource().equals(fontConfirm)) {// 글꼴 활성화 
			fontFrame.setVisible(true);
			isButton=true;
			fontFrame.setVisible(false);
			txtArea.setFont(new Font(name,style,fontsize));
		}else if(e.getSource().equals(fontCancel)){
			isButton=false;
			fontFrame.setVisible(false);
		}//else if
		System.out.println("신호 : " + itemPressed);

	}// action override method

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(fontCombo1)) {
			name = fontCombo1.getSelectedItem();// 글꼴선택
			txtFont.setText(name);
		}
		if (e.getSource().equals(fontCombo2)) {
			String style1 = fontCombo2.getSelectedItem();
			if (style1 == "보통") {
				style = 0;
			} else if (style1 == "기울임") {
				style = Font.ITALIC;
			} else if (style1 == "굵게") {
				style = Font.BOLD;
			}
			txtFontStyle.setText(style1);
		}
		if (!fontCombo3.getSelectedItem().equals("사용자정의")) {
			fontsize = Integer.parseInt(fontCombo3.getSelectedItem());// 글꼴 사이즈
			txtFontSize.setText(fontCombo3.getSelectedItem());
		}
		if (isButton) {
			txtArea.setFont(new Font(name, style, fontsize));
		}
	}// item override method

	public static void main(String[] args) {
		new NotePad();
	}// main
}// class