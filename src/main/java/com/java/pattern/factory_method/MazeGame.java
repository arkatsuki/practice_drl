package com.java.pattern.factory_method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<>();

    public MazeGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        rooms.add(room1);
        rooms.add(room2);
    }
    
    public void build(){
    	Iterator<Room> it = rooms.iterator();
    	Room previousRoom = it.next();
    	while(it.hasNext()){
    		Room r = it.next();
    		previousRoom.connect(r);
    		previousRoom = r;
    		
    	}
    }

    abstract protected Room makeRoom();
}
