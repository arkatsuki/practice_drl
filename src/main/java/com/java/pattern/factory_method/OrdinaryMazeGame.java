package com.java.pattern.factory_method;

public class OrdinaryMazeGame extends MazeGame {

	@Override
	protected Room makeRoom() {
		// TODO Auto-generated method stub
		return new OrdinaryRoom();
	}

}
