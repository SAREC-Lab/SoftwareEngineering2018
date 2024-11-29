package edu.nd.se2018.homework.ChipsChallenge;

public class MonsterRight implements IMonsterState{
	
	private Monster monster;
	
	protected MonsterRight(Monster monster){
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
		monster.setMonsterState(monster.getMonsterLeftState());
	}

}
