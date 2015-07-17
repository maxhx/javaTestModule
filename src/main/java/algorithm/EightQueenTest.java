
package algorithm;

public class EightQueenTest {
	
	public int queenList[];//��¼�ʺ�����
	public int count;//ͳ��·����������
	public int n;//�ʺ������ģ
	
	public EightQueenTest(int n){
		super();
		this.queenList = new int[n];
		this.count = 0 ;
		this.n=n;
	}
	
	/*�ж�֮ǰ�еĵ��뵱ǰ�㲻��ͬһ�У�ͬһ��б����*/  
	public boolean check(int col,int row){
		
		for(int i = 0;i<col;i++){
			if(queenList[i]==row||queenList[i]+i==row+col||queenList[i]-i==row-col){
				return false;
			}
		}
		return true;
	}
	/*�жϵ�col���Ƿ��ܹ���ͨ,����ǰcol�е���8������ͨ*/
	public void findCorrectPath(int col){
		
		if(col==this.n){
			count++;
			System.out.println("��"+count+"����:");
			for(int i=0;i<queenList.length;i++){
				System.out.println("��"+i+"��"+"��"+queenList[i]+"�У�"+"��"+(i+1)+"���ʺ�");   
			}
			System.out.println("\n\n");
			return;
		}else{
			int row = 0;
			while(row<this.n){
				if(check(col,row)){
					queenList[col]=row;
					findCorrectPath(col+1);
					queenList[col]=0;
				}
				
				row++;
			}
		}
	}
	
	public static void main(String[] args){
		EightQueenTest gao = new EightQueenTest(8);
		gao.findCorrectPath(0);
	}

}