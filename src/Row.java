public class Row {
	int[] rowItems;
	
	Row(int a, int b, int c){
		int[] ri = {a,b,c};
		rowItems = ri;
	}
	
	public int[] getItems(){
		return rowItems;
	}
	
	public static Row emptyRow(){
		return new Row(0,0,0);
	}
}
