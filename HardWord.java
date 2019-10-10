
public class HardWord extends Word
{
	//Creates a second type of word the contains harder words for the second level
	public HardWord() 
	{
		super();
		list.add("rhythm");
		list.add("enzyme");
		list.add("psychology");
		list.add("niece");
		list.add("neighbor");
		list.add("calendar");
		list.add("hyena");
		list.add("balloon");
		list.add("biscuit");
		list.add("protein");
		list.add("spaghetti");
		word = list.get((int) (Math.random()*list.size()));
	}
}
