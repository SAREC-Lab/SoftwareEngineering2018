package edu.nd.se2018.homework.hwk6.controller;

import edu.nd.se2018.homework.hwk6.model.MonsterModel;
import edu.nd.se2018.homework.hwk6.view.MapDisplay;
import edu.nd.se2018.homework.hwk6.view.MonsterView;
import javafx.scene.Node;

public class MonsterController {
	public MonsterModel monster;
	public MonsterView monsterView;
	public MapDisplay gameMap;
	public int[] pos;
	public int [][] map;
	int x;
	int y;
	MoveStrategy strategy;
	
	public MonsterController(MapDisplay gMap, MoveStrategy s, int x, int y) {
		gameMap = gMap;
		map = gameMap.getMap();
		
		monster = new MonsterModel(x, y);
		monsterView = new MonsterView(monster);
		monster.attachView(monsterView);
		pos = monster.getPosition();
		
		strategy = s;
	}
	
	public Node getImageView() {
		return monsterView.view;
	}
	
	public MonsterModel getModel() {
		return monster;
	}
	
	public void runStrategy() {
		pos = monster.getPosition();
		x = pos[0];
		y = pos[1];
		pos = strategy.move(x, y);
		monster.setPosition(pos[0], pos[1]);
	}

}
