import java.awt.*;
import javax.swing.*;
public class HelloGui extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 65377960345612064L;
	public HelloGui()
	{
		super("GUI Demo");
		Container c = getContentPane();
		c.setBackground(Color.CYAN);
		c.setLayout(new FlowLayout());
		c.add(new JTextField(" Hello, GUI!", 10));
	}
	public static void main(String[] args)
	{
		HelloGui window = new HelloGui();
		window.setBounds(300, 300, 200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}