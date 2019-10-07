package Game.RiotMaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Game.Game;
import Game.Input;

public class Player {
	
	private int x, y;
	int vidas = 0;
	
	
	private Rectangle box;
	
	
	public Player() {
		x = Game.WIDTH / 2;
		y = 2 * (Game.HEIGHT / 3);
		vidas = 3;
		
		box = new Rectangle(x, y, 32,64);
	}
	
	public void tick() {
		
		Input input = Input.get();
		if (input.isKeyPressed(KeyEvent.VK_A))
			x -= 5;
		if (input.isKeyPressed(KeyEvent.VK_D))
			x += 5;
		if (input.isKeyPressed(KeyEvent.VK_F))
			
		
		box.x = x;				
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(255,255,255,255));
		g.fillRect(x, y, 32, 64);
	}
}
