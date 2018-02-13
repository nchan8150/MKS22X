public class Driver{
    public static void main(String[] args){
	QueenBoard b = new QueenBoard(2);

	//	b.addQueen(2,4);
	//	b.addQueen(1,1);
	//	b.addQueen(3,4);
	//  	b.removeQueen(1,1);
	System.out.println(b.solve());
	System.out.println(b);
	//	System.out.println(b.solve());
    }
}
