import java.io.*; 
import java.util.Calendar; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class MyNotepad extends JFrame implements ActionListener,ItemListener,WindowListener,MouseListener
{
Container c = this.getContentPane(); 
JMenuBar jmb = new JMenuBar(); 

JMenu jm1 = new JMenu("�ļ�"); 
JMenu jm2 = new JMenu("�༭"); 
JMenu jm3 = new JMenu("��ʽ"); 
JMenu jm4 = new JMenu("����");

JMenuItem jmi1 = new JMenuItem("�½�"); 
JMenuItem jmi2 = new JMenuItem("��"); 
JMenuItem jmi3 = new JMenuItem("����"); 
JMenuItem jmi4 = new JMenuItem("�˳�");
JMenuItem jmi5 = new JMenuItem("���ں�ʱ��");

JMenuItem jmi6 = new JMenuItem("����");

JCheckBoxMenuItem jcbmi = new JCheckBoxMenuItem("�Զ�����");

JTextArea jta = new JTextArea(15,15);
JScrollPane jsp = new JScrollPane(jta);
MyNotepad()
{ 
this.addWindowListener(this); 
c.setLayout(new BorderLayout()); 
c.add(jmb,BorderLayout.NORTH); 
this.setTitle("MyNotepad");
jmb.add(jm1);
jm1.addActionListener(this);
jmb.add(jm2);
jmb.add(jm3);
jmb.add(jm4);

jm1.add(jmi1); 
jmi1.addActionListener(this);
jm1.addSeparator();
jm1.add(jmi2); 
jmi2.addActionListener(this); 
jm1.addSeparator(); 
jm1.add(jmi3); 
jmi3.addActionListener(this); 
jm1.addSeparator(); 
jm1.add(jmi4); 
jmi4.addActionListener(this);
jm2.add(jmi5); 
jmi5.addActionListener(this);
jm3.add(jcbmi); //����
jcbmi.addItemListener(this);
jm4.add(jmi6); 
jmi6.addActionListener(this);
c.add(jsp);
this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
this.setSize(500,500); 
this.setVisible(true); 
}
public void actionPerformed(ActionEvent e)
{ 
   //�½�
   if(e.getSource()==jmi1)
   { 
   jta.setText(""); 
   this.setTitle("New MyNoetpad"); 
   }
   //��
   if(e.getSource()==jmi2)
   {
   File f1; 
   JFileChooser jfc1 = new JFileChooser(); 
   int num1 = jfc1.showOpenDialog(this); 
    if(num1==JFileChooser.APPROVE_OPTION)
    { 
     try{
     f1 = jfc1.getSelectedFile(); 
     this.setTitle(f1.getName());
     FileReader fr = new FileReader(f1); 
     BufferedReader br = new BufferedReader(fr); 
     String str; 
      while((str = br.readLine())!=null)
      { 
      jta.setText(str); 
      } 
     fr.close(); 
     br.close(); 
     }catch(FileNotFoundException e1){ 
     e1.printStackTrace(); 
     }catch(IOException e2){ e2.printStackTrace();} 
    }
   } 
   //����
   if(e.getSource()==jmi3)
   { 
    File f2 = null;
    JFileChooser jfc2 = new JFileChooser();
    int num2 = jfc2.showSaveDialog(this);
    if(num2==JFileChooser.APPROVE_OPTION)
    { 
     f2=jfc2.getSelectedFile(); 
     this.setTitle(f2.getName()); 
     try{
     FileWriter fw = new FileWriter(f2); 
     BufferedWriter bw = new BufferedWriter(fw); 
     bw.write(jta.getText()); 
     bw.close(); 
     fw.close(); 
     }catch(IOException e2){e2.printStackTrace(); }
    }
   }
   //�˳�
   if(e.getSource()==jmi4)
   { 
    int a = JOptionPane.showConfirmDialog(this,"�ļ��ѱ��ı䣬�Ƿ�Ҫ���棿","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION); 
    if(a==1)
    { 
     this.dispose(); 
    }
    else if(a==0)
    { 
     File f2 = null; 
     JFileChooser jfc2 = new JFileChooser(); 
     int num2 = jfc2.showSaveDialog(this); 
     if(num2==JFileChooser.APPROVE_OPTION)
     { 
      f2=jfc2.getSelectedFile(); 
      this.setTitle(f2.getName()); 
      try{ 
      FileWriter fw = new FileWriter(f2); 
      BufferedWriter bw = new BufferedWriter(fw); 
      bw.write(jta.getText()); 
      bw.close(); 
      fw.close(); 
      }catch(IOException e2){ e2.printStackTrace(); } 
      this.dispose(); 
     } 
    }
   }
   //����
   if(e.getSource()==jmi5)
   { 
    Calendar c1 =Calendar.getInstance(); 
    int y = c1.get(Calendar.YEAR); 
    int m = c1.get(Calendar.MONTH); 
    int d = c1.get(Calendar.DATE); 
    int h = c1.get(Calendar.HOUR); 
    int m1 = c1.get(Calendar.MINUTE); 
    int m2 = m+1; 
    jta.setText(y+"��"+m2+"��"+d+"��"+h+":"+m1); 
   }
   //��������
   if(e.getSource()==jmi6)
   {
    JOptionPane.showConfirmDialog(this,"���ߣ�\n ��³��ҵ��ѧ \n �����⡢�����","��ʾ",JOptionPane.CANCEL_OPTION);
   }
}
//����
public void itemStateChanged(ItemEvent e2)
{
   if(e2.getItemSelectable()==jcbmi){ 
   jta.setLineWrap(true); 
   }else 
   jta.setLineWrap(false); 
}
public static void main(String[] args)
{ 
   new MyNotepad(); 
}
//��Ӽ���
public void windowOpened(WindowEvent arg0) { 
}
//�رմ���ʱ����ʾ����
public void windowClosing(WindowEvent arg0) 
{ 
   int a = JOptionPane.showConfirmDialog(this,"�ļ��ѱ��ı䣬�Ƿ�Ҫ���棿","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION); 
   if(a==1)
   { 
   this.dispose(); 
   }
   else if(a==0){ 
   File f2 = null;
   JFileChooser jfc2 = new JFileChooser(); 
   int num2 = jfc2.showSaveDialog(this); 
   if(num2==JFileChooser.APPROVE_OPTION)
   {
    f2=jfc2.getSelectedFile(); 
    this.setTitle(f2.getName()); 
    try{ 
    FileWriter fw = new FileWriter(f2); 
    BufferedWriter bw = new BufferedWriter(fw); 
    bw.write(jta.getText()); 
    bw.close(); 
    fw.close(); 
    }catch(IOException e2){ e2.printStackTrace(); } 
   } 
   if(a==2){} 
} 
} 
public void windowClosed(WindowEvent arg0) { 
} 
public void windowIconified(WindowEvent arg0) { 
} 
public void windowDeiconified(WindowEvent arg0) { 
} 
public void windowActivated(WindowEvent arg0) { 
} 
public void windowDeactivated(WindowEvent arg0) { 
}
public void mouseClicked(MouseEvent arg0) { 
} 
public void mousePressed(MouseEvent arg0) { 
} 
public void mouseReleased(MouseEvent arg0) { 
} 
public void mouseEntered(MouseEvent arg0) { 
} 
public void mouseExited(MouseEvent arg0) { 
}
}