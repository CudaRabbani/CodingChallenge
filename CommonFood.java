
public class CommonFood{
	
	private int ID;
	String fgcat_id;
	String servingSize;
	String food;
	
	CommonFood(int id, String fgcat, String size, String f)
	{
		this.ID = id;
		this.fgcat_id = fgcat;
		this.servingSize = size.replace("\"", "");
		this.food = f.replace("\"", "");
	}
	
	public CommonFood getFood()
	{
		return this;
	}
	
	public String toString()
	{
		String s = "";
		s = s + "-"+this.food+" "+this.servingSize;
		return s;
	}

}
