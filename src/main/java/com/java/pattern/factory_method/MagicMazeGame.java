package com.java.pattern.factory_method;

public class MagicMazeGame extends MazeGame {

	@Override
	protected Room makeRoom() {
		// TODO Auto-generated method stub
		return new MagicRoom();
	}

	

}
