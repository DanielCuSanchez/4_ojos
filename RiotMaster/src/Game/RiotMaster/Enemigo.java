package Game.RiotMaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Game.Game;

public class Enemigo {
	private int x, y;
	private int vidas = 0;
	Random rand = new Random();
	private boolean side;//Derecha-true Izquierda-false
	
	private Rectangle box;
	
	private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
	
	
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

	public Rectangle getBox() {
		return box;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Enemigo> enemigos) {
		this.enemigos = enemigos;
	}

	public void add(Enemigo enemigo) {
		enemigos.add(enemigo);
	}
	
	public void delete(Enemigo enemigo) {
		enemigos.remove(enemigo);
	}

	public void tick() {
		for (int i = 0; i < enemigos.size(); i++) {
			if (enemigos.get(i).isSide()) {
				enemigos.get(i).setX(enemigos.get(i).getX() - 1);
			} else {
				enemigos.get(i).setX(enemigos.get(i).getX() + 1);
			}
			
			enemigos.get(i).setBox(new Rectangle(enemigos.get(i).getX(),enemigos.get(i).getY(), 32,64));
		}
						
	}
	
	public void render(Graphics2D g) {
		for (int i = 0; i < enemigos.size(); i++) {
			g.setColor(new Color(255,0,0,255));
			g.fillRect(enemigos.get(i).getX(),enemigos.get(i).getY() , 32, 64);
		}
		
	}
	
}
