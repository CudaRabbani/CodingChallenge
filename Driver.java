import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Driver {
	
	
	public static int splitter(String s)
	{
		String temp= new String();
		temp = s;
		int low = 0, high = 0;
		
		int n = s.indexOf(" t");
		String lower = "";
		for(int i=0; i<n; i++)
		{
			lower+=temp.charAt(i);
		}
		low = Integer.parseInt(lower);
		lower = "";
		n = temp.indexOf("o ");
		for(int i=n+2; i<=temp.length()-1; i++)
		{
			lower += temp.charAt(i);
		}
		high = Integer.parseInt(lower);
		
		n = (int) (Math.random() * (high - low + 1) + low);
	
		return n;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner input = new Scanner(System.in);
		AlternativeList al = new AlternativeList();
		BufferedReader br = null;
		List<Data> primaryList = new ArrayList<Data>();

		System.out.println("---------Input----------");
		System.out.print("Category: ");
		String gender = input.nextLine();
		System.out.print("Ages: ");
		String age = input.nextLine();
		System.out.println();
		
		String file = "Data/servings_per_day-en_ONPP.csv";
		FileReader fr = new FileReader(file);
		String line = "";
		String splitBy = ",";
	
		try
		{
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				String[] data = line.split(splitBy);
				if((data[1].equalsIgnoreCase(gender)) && (data[2].equalsIgnoreCase(age))){
					Data temp = new Data();
					int size;
					if(data[3].contains("to"))
					{
						size = splitter(data[3]);
					}
					else
					{
						size = Integer.parseInt(data[3]);
					}
					temp.setData(data[0], data[1], data[2], size);
					primaryList.add(temp);
				} 
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		al.createDatabase();
		
		for(Data d: primaryList)
		{
			d.setFood(al.allocateFood(d.getFGID(), d.getServingSize()));
		}
		
		System.out.println();
		System.out.println("------Output-----");
		System.out.println();
		
		for(Data d : primaryList)
		{
			System.out.println(d);
			d.display();
			System.out.println();
		}
	
	}

}
