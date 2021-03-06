
public class CommandMoveSouth extends Command 
{
	
	public CommandMoveSouth(GameControllerInterface gci)
	{
		commandString = "move south";
		controller = (GameController)gci;
	}
	@Override
	public void execute() 
	{
		controller.setCurrentRoom(controller.getNextRoom(Direction.SOUTH));
		controller.postWindowText("Executed Move South");
	}

}
