package edu.nd.se2018.homework.hwk6.model;

public class GameRunning implements GameState {
	private ChipModel chip;
	
	protected GameRunning(ChipModel chip) {
		this.chip = chip;
	}

	@Override
	public void allChipsCollected() {
		chip.setGameState(chip.getAllChipsState());
	}

	@Override
	public void levelWon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void running() {
		// TODO Auto-generated method stub
		
	}

}
