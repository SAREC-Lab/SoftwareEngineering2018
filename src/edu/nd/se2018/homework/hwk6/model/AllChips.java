package edu.nd.se2018.homework.hwk6.model;

public class AllChips implements GameState {
	
	private ChipModel chip;
	
	protected AllChips(ChipModel chip) {
		this.chip = chip;
	}

	@Override
	public void allChipsCollected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelWon() {
		chip.setGameState(chip.getGameWonState());
		
	}

	@Override
	public void running() {
		// TODO Auto-generated method stub
		
	}

}
