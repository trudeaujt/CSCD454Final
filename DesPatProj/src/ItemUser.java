
public class ItemUser extends Item 
{
	private Name name;
	private String type;
	private int damagePoints;
	int hitPointsMax;

	
	public ItemUser()
	{
		this.name = randomGenerator(titles);
				
		if(name.getClass().isInstance(new NameWeak()))
			this.damagePoints = 1;
		
		if(name.getClass().isInstance(new NameAverage()))
			this.damagePoints = 3;
		
		if(name.getClass().isInstance(new NameTough()))
			this.damagePoints = 5;
	
		this.type = new NameItem().toString();
		
	}

public int getHitPoints() {
	return damagePoints;
}

public Name getName() {
	return name;
}

public String toString() {
	return this.name + " "+this.type+ " "+this.damagePoints;
		
}

@Override
public int getPoints() {
	return this.damagePoints;
}



}
