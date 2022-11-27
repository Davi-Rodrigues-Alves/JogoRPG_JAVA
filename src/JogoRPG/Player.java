package JogoRPG;

public class Player extends Character {
	
	//inteiros para armazenar o número de upgrades/skills em cada caminho
	public int numAtkUpgrades, numDefUpgrades;
	
	//estatísticas adicionais do jogador
	int gold , restLeft, pots;
	
	
	// arrays para armazenar nomes de habilidades
	public String[] atkUpgrades = {"Espada de Bronze - [Lvl 1]", "Espada de Ouro - [Lvl 2]", "Espada de Diamante Athos - [Lvl 3]", "Excalibur (espada do rei Arthur) - [Lvl 4]"};
	public String[] defUpgrades = {"Armadura de Ossos  - [Lvl 1]", "Armadura de Ferro - [Lvl 2]", "Armadura de Aço - [Lvl 3]", "Armadura de Ouro do Rei - [Lvl 4]"};
			
	
	// construtor específico do jogador
	public Player(String name) {
		//Chamando construtor da superClasse
		super(name, 100,0); // (nome,hpMaximo, experiencia)
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		
		//set estatisticas
		this.gold = 4;
		this.restLeft = 1;
		this.pots = 0;
		
		//deixa o jogador escolher uma característica ao criar um novo personagem
		chooseTrait();
	}

	// métodos especificos do jogador 
	@Override
	public int attack() {
		return (int)(Math.random()* (xp/4 +numAtkUpgrades*3 + 3) + xp/8 + numAtkUpgrades*2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {
		return (int)(Math.random()* (xp/4 +numDefUpgrades*3 + 3) + xp/8 + numDefUpgrades*2 + numAtkUpgrades + 1);
	}
	
	
	//deixe o jogador escolher uma característica de qualquer caminho de habilidade
	public void chooseTrait() {
		GameLogic.clearConsole();
		GameLogic.printHeading("Escolha uma arma para evoluir/upgrade");
		System.out.println("(1) "+atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) "+defUpgrades[numDefUpgrades]);
		
		//obter os dados escolhidos
		int input = GameLogic.readInt("-> ", 2);
		GameLogic.clearConsole();
		
		// lidar com os dois casos
		if (input == 1) {
			GameLogic.printHeading("Você escolheu "+atkUpgrades[numAtkUpgrades]);
			numAtkUpgrades++;
		} else {
			GameLogic.printHeading("Você escolheu "+defUpgrades[numDefUpgrades]);
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
	}
	
	

}
