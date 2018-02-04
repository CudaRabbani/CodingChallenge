import java.util.ArrayList;
import java.util.List;

public class Data {
	String foodCategory;
	String fgid;
	String gender;
	String ages;
	int servings;
	List<CommonFood> food;
	
	Data()
	{
		foodCategory = new String();
		fgid = new String();
		gender = new String();
		ages = new String();
		servings = 0;
		food = new ArrayList<CommonFood>();
	}
	
	public void setData(String id, String g, String age, int s)
	{
		this.foodCategory = this.setCategory(id);
		this.fgid = id;
		this.gender = g;
		this.ages = age;
		this.servings = s;
	}
	
	public String getFGID()
	{
		return this.fgid;
	}
	
	public int getServingSize()
	{
		return this.servings;
	}
	
	private String setCategory(String fgid)
	{
		String s = fgid;
		String type = new String();
		switch(s)
		{
		case "vf":
			type = "Vegetables and Fruit";
			break;
		case "gr":
			type = "Grains";
			break;
		case "mi":
			type = "Milk and Alternatives";
			break;
		case "me":
			type = "Meat and Alternatives";
			break;
		}
		
		return type;
	}
	
	public void setFood(List<CommonFood> l)
	{
		this.food = l;
	}

	public String toString()
	{
		String s= new String();
		s = ""+this.foodCategory+"-"+this.servings+" servings";
		return s;
	}
	
	public void display()
	{
		for(CommonFood f: this.food)
		{
			System.out.println(f);
		}
	}
}
