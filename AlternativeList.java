import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class AlternativeList {
	
	List<CommonFood> vf;
	List<CommonFood> gr;
	List<CommonFood> mi;
	List<CommonFood> me;
	int vfCounter = 0;
	int grCounter = 0;
	int miCounter = 0;
	int meCounter = 0;
	
	AlternativeList()
	{
		vf = new ArrayList<CommonFood>();
		gr= new ArrayList<CommonFood>();
		mi= new ArrayList<CommonFood>();
		me= new ArrayList<CommonFood>();
	}
	

	public List<CommonFood> getList(String fid, int size)
	{
		List<CommonFood> aList = new ArrayList<CommonFood>();
		switch(fid)
		{
			case "vf":
				aList = this.vf;
				break;
			case "gr":
				aList = this.gr;
				break;
			case "mi":
				aList = this.mi;
				break;
			case "me":
				aList = this.me;
				break;
		}
		
		return aList;
	}
	
	public List<CommonFood> allocateFood(String fgid, int size)
	{
		List<CommonFood> aList = new ArrayList<CommonFood>();		
		List<CommonFood> tempList = new ArrayList<CommonFood>();
	
		switch(fgid)
		{
		case "vf":
			tempList = vf;
			break;
		case "gr":
			tempList = gr;
			break;
		case "mi":
			tempList = mi;
			break;
		case "me":
			tempList = me;
			break;		
		}
		Collections.shuffle(tempList);
		int counter = 0;
		while(counter<size)
		{
			aList.add(tempList.get(counter++).getFood());
		}
		
		
		return aList;
	}
	
	
	public void createDatabase()
	{
		try
		{
			String file = "Data/foods-en_ONPP_rev.csv";
			BufferedReader br = null;
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			String splitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
			String foodSize = new String();
			CommonFood temp;
			
			while((line = br.readLine()) != null)
			{
				String[] data = line.split(splitBy);
				int length = data.length;
				if(length >= 4)
				{
					foodSize = "(";
					for(int i=2; i<length-1;i++)
					{
						if(i ==length-2)
						{
							foodSize += data[i];
						}
						else{
							foodSize += data[i]+',';
						}
						
					}
					foodSize +=")";
				}				
				switch (data[0])
				{
					case "vf":
						temp = new CommonFood(vfCounter++, data[1], foodSize, data[data.length-1]);
						vf.add(temp);
						break;
					case "gr":
						temp = new CommonFood(grCounter++, data[1], foodSize, data[data.length-1]);
						gr.add(temp);
						break;
					case "mi":
						temp = new CommonFood(miCounter++, data[1], foodSize, data[data.length-1]);
						mi.add(temp);
						break;
					case "me":
						temp = new CommonFood(meCounter++, data[1], foodSize, data[data.length-1]);
						me.add(temp);
						break;
				}
				
				foodSize = new String();
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Debug purpose only
	public void printList(String foodName)
	{
		switch(foodName)
		{
			case "vf":
				for(CommonFood cf: this.vf)
				{
					System.out.println(cf);
				}
				break;
			case "gr":
				for(CommonFood cf: this.gr)
				{
					System.out.println(cf);
				}
				break;
			case "mi":
				for(CommonFood cf: this.mi)
				{
					System.out.println(cf);
				}
				break;
			case "me":
				for(CommonFood cf: this.me)
				{
					System.out.println(cf);
				}
				break;
		}
	}
	

}
