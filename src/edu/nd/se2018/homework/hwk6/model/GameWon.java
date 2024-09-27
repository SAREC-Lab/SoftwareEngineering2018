package edu.nd.se2018.homework.hwk6.model;

public class GameWon implements GameState {

	private ChipModel chip;
	
	protected GameWon(ChipModel chip) {
		this.chip = chip;
	}
	
	@Override
	public void allChipsCollected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelWon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void running() {
		chip.setGameState(chip.getRunningState());
		
	}

}
