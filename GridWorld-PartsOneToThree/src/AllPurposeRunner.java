import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.Random;

public class AllPurposeRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		
		//BoxBug andy = new BoxBug(4);
		//CircleBug brian = new CircleBug(3);
		//DancingBug craig = new DancingBug(getRandomArray());
		Jumper dave = new Jumper();
		//SpiralBug evan = new SpiralBug(5);
		//ZBug frank = new ZBug(4);
        
		//world.add(new Location(5, 5), andy);
        //world.add(new Location(5, 5), brian);
        //world.add(new Location(5, 5), craig);
        world.add(new Location(5, 5), dave);
        //world.add(new Location(5, 5), evan);
        //world.add(new Location(5, 5), frank);
        
        world.show();
	}
	public static int[] getRandomArray(){
		int arraySize = 10;
        int[] turnsArray = new int[arraySize];
        Random rand = new Random();
        for(int i = 0; i < arraySize; i++){
        	turnsArray[i] = rand.nextInt(8) + 1;
        }
        return turnsArray;
	}

}