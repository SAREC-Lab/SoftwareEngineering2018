package edu.nd.se2018.homework.ChipsChallenge;

public class MonsterLeft implements IMonsterState{
	
	private Monster monster;
	
	protected MonsterLeft(Monster monster){
		this.monster = monster;
	}
	@Override
	public void approachRange() {
		// N/A
		
	}

	@Override
	public void leaveRange() {
		monster.setMonsterState(monster.getMonsterSleepingState());
	}

	@Override
	public void hitBarrier() {
		monster.setMonsterState(monster.getMonsterRightState());
	}

}
