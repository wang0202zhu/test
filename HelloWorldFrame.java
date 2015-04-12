package Sunshine;

    import java.awt.Label;

    import java.awt.event.MouseMotionAdapter;

    import javax.swing.JFrame;

public class HelloWorldFrame extends JFrame{

	public HelloWorldFrame() {
		
		
		final Label label=new Label("Hello World");

		label.addMouseMotionListener(new MouseMotionAdapter() {

public void mouseDragged(java.awt.event.MouseEvent e) { 

		label.setLocation(e.getX() , e.getY()); 

			} 

		}

                   ); 
		this.setLayout(null);

		this.add(label);

		label.setBounds(100, 100, 100, 100);

		label.setVisible(true);

		this.setBounds(40, 100, 400, 300);

		this.setVisible(true); 

	}
	
public static void main(String[] args) {

			new HelloWorldFrame();
		}

	}
