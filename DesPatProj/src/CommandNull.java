
public class CommandNull extends Command 
{

	
	public CommandNull(GameControllerInterface gci){
		this.controller = (GameController)gci;
		commandString = "no command";
		
	}
	
	@Override
	public void execute() {
		controller.postWindowText("What was that?");
		
	}

}
