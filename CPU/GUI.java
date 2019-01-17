import java.awt.*;
import javax.swing.*; 
public class GUI{
	
	public static GUI context;
	public static JButton buttonArray[][]=new JButton[3][3];
	private JFrame mainFrame;
	GUI(){
		mainFrame=new JFrame();
		context=this;
		createGUI();
	}
	private void createGUI(){
		mainFrame.setTitle("The Tic-Tac-Toe");
		//mainFrame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		GridLayout gl=new GridLayout(3,3);
		mainFrame.setLayout(gl);
		addButton(9);
		mainFrame.setSize(500,500);
		mainFrame.setVisible(true);
	}
	private void addButton(int size){
		JButton b;
		/* total button number =9
			a[0][0]=b1
		*/
		for(int i=0,j=0;i<size;i++){
			b = new JButton();
			if(i==3 || i==6){
				j++;
			}
			b.addActionListener(new Logic(b,new int[]{j,i%3}));
			mainFrame.add(b);
			buttonArray[j][i%3]=b;
		}
	}

	public void resetGame(){
		mainFrame.getContentPane().removeAll();
		createGUI();
		mainFrame.repaint();
	}
	public static void main(String args[]){
		new GUI();
	}
}