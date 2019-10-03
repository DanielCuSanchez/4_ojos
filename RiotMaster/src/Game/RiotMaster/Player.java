package Game.RiotMaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Game.Game;
import Game.Input;

public class Player {

	
	private class Vec2 {
		public int x, y;
		public Vec2(int _x, int _y) { x = _x; y = _y; }
	}
	
	private ArrayList<Vec2 >pos;
	private int x, y;
	
	private int size = 1;
	
	private Rectangle box;
	
	
	public Player() {
		pos = new ArrayList<>();
		x = Game.WIDTH / 2;
		y = 2 * (Game.HEIGHT / 3);
		pos.add(new Vec2(x, y));
		
		box = new Rectangle(x, y, 32,64);
	}
	
	public void tick() {
		
		
		
		
		
		Input input = Input.get();
		if (input.isKeyPressed(KeyEvent.VK_A))
			x -= 5;
		if (input.isKeyPressed(KeyEvent.VK_D))
			x += 5;
		
		box.x = x;		
		pos.add(new Vec2(x, y));
		if (pos.size() > size) pos.remove(0);
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(255,255,255,255));
		g.fillRect(x, y, 32, 64);
		
		for (int i=0; i < pos.size(); i += 2) {
			Vec2 v = pos.get(i);
			int alpha = (int)(i*(255.0 / pos.size()));
			g.setColor(new Color(0,255,0, alpha));
			g.fillRect(v.x, v.y, 32, 32);
		}
	}
}
