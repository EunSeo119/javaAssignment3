package quiz_9;
import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel{
	public NorthPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER,7,7));
		setBackground(Color.LIGHT_GRAY);
		JButton jb = new JButton("Open");
		add(jb);
		jb=new JButton("Read");
		add(jb);
		jb=new JButton("Close");
		add(jb);
	}
}

class CenterPanel extends JPanel{
	public CenterPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		JLabel jl = new JLabel("Hello");
		jl.setLocation(90,15);
		jl.setSize(30,10);
		add(jl);
		jl = new JLabel("Java");
		jl.setLocation(20,160);
		jl.setSize(30,10);
		add(jl);
		jl = new JLabel("Love");
		jl.setLocation(180,130);
		jl.setSize(30,10);
		add(jl);
	}
}
public class GUI extends JFrame{
	public GUI() {
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		NorthPanel np= new NorthPanel();
		c.add(np, BorderLayout.NORTH);
		CenterPanel cp = new CenterPanel();
		c.add(cp,BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

}
