package Demo1_timer;
import dyeHardProceduralAPI.DHProceduralAPI;

/**
 * 
 * @author vuochnin
 *
 *
 *	Demonstrates timer functions, spawning single object using timer
 */
public class Demo1 extends DHProceduralAPI
{
	int heroID;
	
	public void buildGame(){
		heroID = apiStartHero();
	 
		// Start an object spawner with the default setting
		apiStartDebrisSpawner(0.5f);
	
		apiSetSingleTimer("test", 2);
		apiSetSingleTimer("dyepack", 5);
	
	}
	
	public void updateGame()
	{
		if(apiIsTimerFinished("test")){
			apiSpawnSinglePowerUp("Ghost", 70, 20);
		}
	
		if(apiIsTimerFinished("dyepack"))
		{
			apiStartDyePackSpawner();
			apiSetSingleTimer("dyepack_stop", 5);
		}
	 
		if(apiIsTimerFinished("dyepack_stop"))
		{
			apiStopDyePackSpawner();
			apiSetSingleTimer("dyepack", 5);
		}
	 
		apiObjectFollowTheMouse(heroID);
	 
		if(apiIsMouseLeftClicked())
			apiHerofirePaint();
	
	}
}