import javax.swing.*;
import java.awt.event.*;
public class Logic implements ActionListener{
	static int count=0;
	static char data[][]=new char[3][3];
	JButton b;
	int cordinate[]=new int[2];
	Logic(JButton b,int []cordinate){
		this.b=b;
		this.cordinate=cordinate;
	}
	public void actionPerformed(ActionEvent ae){
			data[cordinate[0]][cordinate[1]]=getMsg();
			if(isGameOver(cordinate[0],cordinate[1],getMsg())){
				System.out.println("Hurrayyy !!!!! u won!!!! :) :) "+getMsg());
				resetGame();
				return;
			}
			setButtonText();
			count++;
	}
	private void resetGame(){
		data=new char[3][3];
		count=0;
		GUI.context.resetGame();
	}
	private boolean isGameOver(int i,int j,char value){
			if(isHorizontal(j,value)){
				return true;
			}
			if(isVertical(i,value)){
				return true;
			}
			if((i+j)%2==0){
				if(isLeftDiagonal(value)){
					return true;
				}
				if(isRightDiagonal(value)){
					return true;
				}
			}
		return false;
	}
	private boolean isHorizontal(int j,char value){
		for(int i=0;i<3;i++){
			if(data[i][j]!=value){
				return false;	
			}
		}
		return true;
	}
	private boolean isVertical(int i,char value){
		for(int j=0;j<3;j++){
			if(data[i][j]!=value){
				return false;
			}
		}
		return true;
	}
	private boolean isRightDiagonal(char value){
		for(int i=0;i<3;i++){
			if(data[i][i]!=value){
				return false;
			}
		}
		return true;
	}
	private boolean isLeftDiagonal(char value){
		for(int i=0,j=2;i<3;i++,j--){
			if(data[i][j]!=value){
				return false;
			}
		}
		return true;
	}

	private void setButtonText(){
		b.setText(getMsg()+"");
		b.setEnabled(false);
	}
	private char getMsg(){
		char msg='X';
		if(count%2==0){
			msg='O';
		}
		return msg;
	}
}