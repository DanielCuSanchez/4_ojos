package Game.RiotMaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Game.Game;

public class Enemigo {
	private int x, y;
	int vidas = 0;
	Random rand = new Random();
	boolean side;//Derecha-true Izquierda-false
	
	private Rectangle box;
	
	ArrayList<Enemigo> enemigo = new ArrayList<Enemigo>();
	
	
	public Enemigo() {
		x = Game.WIDTH / 2;
		y = 2 * (Game.HEIGHT / 3);
		vidas = 3;
		
		if (rand.nextInt() >= 0) {
			x += Game.WIDTH / 4;
			side = true;
		} else {
			x -= Game.WIDTH / 4;
			side = false;
		}
		
		box = new Rectangle(x, y, 32,64);
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public void tick() {
		
		if (side) {
			x -= 1;
		} else {
			x += 1;
		}
		
		box.x = x;				
	}
	
	public void render(Graphics2D g) {
		g.setColor(new Color(255,0,0,255));
		g.fillRect(x, y, 32, 64);
	}
	
}
