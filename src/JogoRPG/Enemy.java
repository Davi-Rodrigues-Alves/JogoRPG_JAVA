package JogoRPG;

public class Enemy extends Character{

	
	
	//variável para armazenar o xp atual dos jogadores
	int playerXp;
	
	public Enemy(String name, int playerXp) {
		super(name,(int)(Math.random()*playerXp + playerXp/3 + 5),(int) (Math.random()*(playerXp/4 +2)+ 1));
		//Atribuindo variaveis
		this.playerXp = playerXp;
	}

	
	
	// Cálculos de ataque e defesa específicos do inimigo
	@Override
	public int attack() {
		return  (int) (Math.random()* (playerXp/3 + 2) + xp/3 + 2);
	}

	@Override
	public int defend() {	
		return (int) (Math.random()* (playerXp/3 + 2) + xp/3 + 2);
	}

}
