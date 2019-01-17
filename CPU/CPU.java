import java.util.*;
public class CPU{
	public static int[] cpuTurn(List<Integer> spaceFilledX,List<Integer> spaceFilledY){
			Random ran=new Random();
			int x=ran.nextInt(3);
			int y=ran.nextInt(3);
			
			//for(int i=0;i<spaceFilledX.size();i++){
				Iterator spaceFilledXIterator=spaceFilledX.iterator();
				Iterator spaceFilledYIterator=spaceFilledY.iterator();
				while(spaceFilledYIterator.hasNext() && spaceFilledXIterator.hasNext()){
					int x1=(Integer)spaceFilledXIterator.next();
					int y1=(Integer)spaceFilledYIterator.next();
					System.out.println("Data Stored \t X: "+ x1+ " Y:"+ y1);
					if(x1 == x && y1 == y){
						x=ran.nextInt(3);
						y=ran.nextInt(3);
						spaceFilledXIterator=spaceFilledX.iterator();
						spaceFilledYIterator=spaceFilledY.iterator();
					}	
				}
			//}
			/*while(spaceFilledX.get(x) && ){
					x=ran.nextInt(3);
				c++;
			}
			while(spaceFilledY.contains(y)){
					y=ran.nextInt(3);
			}*/
			GUI.buttonArray[x][y].setText("X");
			GUI.buttonArray[x][y].setEnabled(false);
			System.out.println("X : "+ x +" Y: "+y);

			return new int[]{x,y};
	}
}