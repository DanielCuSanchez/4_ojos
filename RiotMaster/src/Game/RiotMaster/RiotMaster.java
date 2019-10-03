package Game.RiotMaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Game.Game;
import Game.Input;
import Game.RiotMaster.Player;

public class RiotMaster {
	Player player;
	int count;
	boolean gameOver;
	
	public RiotMaster() {
		
	}
	
	public void init() {
		// Condiciones de Inicio
		gameOver = false;
		count = 0;
		player= new Player();
	}
	
	public void tick() {
		
		// Cuando pierda, puede reinciar dando presionando en space
		if (Input.get().isKeyPressed(KeyEvent.VK_SPACE) && gameOver) {
			init();
		}
		
		if (gameOver) return;
			
		player.tick();
		
		
		
	}
	
	public void render(Graphics2D g) {
		player.render(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Points: " + count, 20, 20);
		
		if (gameOver) {
			Font font = new Font("Helvetica", Font.BOLD, 48);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", Game.WIDTH/2-128, Game.HEIGHT/2);
		}
	}
}
