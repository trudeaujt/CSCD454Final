import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


public class PartyMember extends PartyComponent implements Tileable{
	
	Character character;
	boolean alive;
	
	public PartyMember(Character character){
		assert(character != null);
		this.character = character;
		alive = true;
	}
	public Name getName(){
		return character.name;
	}
	public Health getHealth(){
		return character.health;
	}
	public Race getRace(){
		return character.race;
	}
	public Level getLevel(){
		return character.level;
	}
	public ArrayList<Item> getItems(){
		return character.inventory;
	}
	public String print(){
		String ret = "";
		ret += character.toString();
		return ret;
	}
	public String showStats(){
		
		String state = alive? "Alive":"Dead";
	
		String ret = "\n*****************************\n" + 
				"Name:" + character.getName() + 
				"\nRace: " + character.getRace() + 
				"\nHealth: " + character.getHealth() +
				"\nState: " + state +
				"\n*****************************\n";
		
		System.out.print(ret);
		return ret;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator createIterator(){
		return new NullIterator();
	}
	
	public void attack(PartyMember attacker, PartyMember otherCharacter){
		character.attackStyle.attack(attacker, otherCharacter);
	}
	public void defend(){
		character.defendStyle.defend();
	}
	public void flee(){
		character.fleeStyle.flee();
	}
	public boolean checkHealth(){
		alive = character.health.hitPoints > 0;
		return alive;
	}
	public Character getCharacter(){
		return character;
	}
	@Override
	public PartyComponent wrap(String name){
		ArrayList<PartyComponent> list = new ArrayList<PartyComponent>();
		list.add(this);
		return new Party(name, list);
	}

	@Override
	public String toString(){
		
		return character.toString();
	}
	
}
