package Game.RiotMaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Game.Game;
import Game.Input;

public class Arma {
	private int x, y;
	boolean side = false; //false-izquierda true-derecha
	private Rectangle box;
	
	public Arma() {
		x = (Game.WIDTH / 2) + 16;
		y = (2 * (Game.HEIGHT / 3)) + 32;
		side = false;
		
		box = new Rectangle(x, y, 32, 16);
	}
	
	public void tick() {
		
		Input input = Input.get();
		if (input.isKeyPressed(KeyEvent.VK_A))
			x -= 5;
			side = false;
		if (input.isKeyPressed(KeyEvent.VK_D))
			x += 5;
			side = true;
		
		
		box.x = x;				
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(255,255,0,255));
		g.fillRect(x, y, 32, 16);
	}
	
	public void disparar() {
		
	}
}
