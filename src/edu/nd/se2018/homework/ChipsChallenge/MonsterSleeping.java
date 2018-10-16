package edu.nd.se2018.homework.ChipsChallenge;

public class MonsterSleeping implements IMonsterState{
	
	private Monster monster;
	
	protected MonsterSleeping(Monster monster){
		this.monster = monster;
	}
	
	@Override
	public void approachRange() {
		monster.setMonsterState(monster.getDirectionState());
	}

	@Override
	public void leaveRange() {
		// N/A
		
	}

	@Override
	public void hitBarrier() {
		// N/A
		
	}

}
