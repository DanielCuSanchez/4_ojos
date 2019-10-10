package Game.RiotMaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Game.Game;
import Game.Input;
import Game.RiotMaster.Player;

public class RiotMaster {
	Level level;
	Player player;
	Arma arma;
	Enemigo enemigo;
	int count;
	boolean gameOver;
	int enemyA = 0;
	
	public RiotMaster() {
		
	}
	
	public void init() {
		// Condiciones de Inicio
		gameOver = false;
		count = 0;
		player= new Player();
		level = new Level();
		arma = new Arma();
		enemigo = new Enemigo();
	}
	
	public void tick() {
		
		// Cuando pierda, puede reinciar dando presionando en space
		if (Input.get().isKeyPressed(KeyEvent.VK_SPACE) && gameOver) {
			init();
		}
		
		if (gameOver) return;
			
		player.tick();
		arma.tick();
		enemigo.tick();
		
		if (enemyA >= 120) {
			enemigo.add(new Enemigo());
			enemyA = 0;
		}
		
		enemyA++;
		
		
	}
	
	public void render(Graphics2D g) {
		player.render(g);
		level.render(g);
		arma.render(g);
		enemigo.render(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Points: " + count, 20, 20);
		
		int xVidas = 20;
		
		for(int i = 0; i < player.vidas; i++) {
			g.setColor(Color.RED);
			g.drawOval(xVidas, 40, 20, 20);
			g.fillOval(xVidas, 40, 20, 20);
			
			xVidas += 25;
		}
		
		if (gameOver) {
			Font font = new Font("Helvetica", Font.BOLD, 48);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", Game.WIDTH/2-128, Game.HEIGHT/2);
		}
	}
}
