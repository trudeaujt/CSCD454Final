import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Controller portion of the model-view-controller
 */
public class GameController extends GameControllerInterface {

	private GameModel gameModel;
	private MainWin gameView;
	private CommandCenter controller;
	
	
	public GameController(GameModelInterface model) {
		
		gameModel = (GameModel)model;
		gameView = new MainWin();
		controller = new CommandCenter(this);
		start();
	}
	
	public void start() {
		
		
		gameView.getInputArea().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				controller.executeCommand(gameView.getInputArea().getText());
				update();
			}
		});
		gameView.setVisible(true);
		gameView.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e){
				gameView.getInputArea().requestFocus();
				gameView.getInputArea().selectAll();
			}
		});
		setWindowText(gameModel.getDungeonDescription() + 
				"\n\n" + gameModel.getPlayerList());
		gameView.setVisible(true);
		updateMap(gameModel.getCurrentRoom().toString());
		
	}
	public void update(){
		
		postWindowText(gameModel.getCurrentRoom().getDescription());
		gameView.clearInput();
		updateMap(gameModel.getCurrentRoom().toString());
	}
	
	public void updateMap(String theMap) {
		
		gameView.setMap(theMap);
		
	}
	
	public void addInventory() {
		
		//lots of stubs, each will call appropriate method from gameModel which will handle the heavy lifting
		//feel free to change return types and variables passed in...
		
	}
	
	public void attack() {
		System.out.println("Called attack()");
		if(gameModel.getCurrentRoom().hasEnemy()){
			Battle<Party> battle = 
					new Battle<Party>(gameModel.getCurrentRoom().getParty(), 
							gameModel.getPlayerParty());
			battle.start(this);
			postWindowText("Current Stats Enemy:\n" + gameModel.getCurrentRoom().getParty().showStats()
					+ "\n\nCurrent Stats Player:\n" + gameModel.getPlayerParty().showStats());
			
			
		}
		else
		{
			postWindowText("Nothing to attack");
		}
		
	}
	
	
	
	public void attackBehavior() {
		
		
		
	}
	
	public void changeWeapon() {
		
		
		
	}
	
	public void defenseBehavior() {
		
		
		
	}
	
	public void flee() {
		
		
		
	}
	
	public void fleeBehavior() {
		
		
		
	}
	
	public void giveItem() {
		
		
		
	}
	
	public void join() {
		
		
		
	}
	
	public void moveEast() {
		
		
		
	}
	
	public void moveNorth() {
		
		
		
	}
	
	public void moveSouth() {
		
		
		
	}
	
	public void moveWest() {
		
		
		
	}
	
	public void search() {
		
		
		
	}
	
	public Room getNextRoom(Direction dir){

		return gameModel.getNextRoom(dir);
		
	}
	
	public void setCurrentRoom(Room room){
		
		gameModel.setCurrentRoom(room);
		
	}
	
	public void setWindowText(String string) {
		
		//not sure which method we are using?
		//I want to use post window text so as to be able to see past
		//commands and output, but I can't get it right...I am just doing it like this 
		//for now
		gameView.setOutput(string);
	}
	
	public void postWindowText(String str){
		//can't get this right...diverting for now
		//window.postOutput(str);
		setWindowText(str+"\n");
	}
	public void updateRoomMembers(){
		gameModel.updateRoomMembers();
	}
	/**
	 * For testing purposes only!
	 */
	public static void main(final String[] arguments) {
		
		GameModelInterface newGameModel = new GameModel();
		GameControllerInterface gameController = new GameController(newGameModel);
		
	}

	
}
