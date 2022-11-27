package JogoRPG;

import java.util.Scanner;

public class GameLogic {

	static Scanner scanner = new Scanner(System.in);
	static Player player;
	static boolean isRunning;

	// encontros aleatórios
	public static String[] encounters = { "Batalha", "Batalha", "Batalha", "Descanso", "Descanso" };

	// nome dos inimigos
	public static String[] enemies = { "Ogro", "Ogro", "Duende", "Duende", "Esqueleto de Pedra" };

	// elementos da história
	public static int place = 0, act = 1;
	public static String[] places = { "Montanhas Eternas", "Cidade Assombrada", "Castelo do Imperador Maligno",
			"Sala do Trono" };

	// método para obter a entrada do usuário no console
	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			} catch (Exception e) {
				input = -1;
				System.out.println("Insira um número inteiro!");
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	// método para simular a limpeza na saída do console
	public static void clearConsole() {
		for (int i = 0; i < 50; i++)
			System.out.println();

	}

	// método para imprimir um separador com comprimento n
	public static void printSeparator(int n) {
		for (int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();

	}

	// método para imprimir um título
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}

	// método para parar o jogo até que o usuário digite qualquer coisa
	public static void anythingToContinue() {
		System.out.println("\npressione uma tecla para continuar...");
		scanner.next();
	}

	public static void menu() {
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("SEJAM BEM VINDOS AO MUNDO SOMBRIO");
		System.out.println("ERA DO IMPERADOR DO MAL");
		printSeparator(30);
		printSeparator(40);
		System.out.println(" -(1) JOGAR");
		System.out.println(" -(2) INTRUÇÕES");
		System.out.println(" -(3) CRÉDITOS");
		System.out.println(" -(4) SAIR");
	}

	public static void creditos() {
		clearConsole();
		printHeading("CRÉDITOS");
		System.out.println();
		System.out.println("Este jogo foi desenvolvido pelos alunos:\nDavi Rodrigues Alves\n Juan Caleb Pereira\nWagner Alves da Silva\nKawan Nascimentos dos Santos");
		printSeparator(30);
		System.out.println("SENAC - SANTO AMARO\nSão Paulo\n2022\nProjeto Integrador com o Professor Galvez Gonçalves");
		System.out.println("ANÁLISE E DESENVOLVIMENTO DE SISTEMAS - 1° SEMESTRE");
	}

	public static void instruções() {
		clearConsole();
		printHeading("INSTRUÇÕES DO JOGO");
		System.out.println();
		System.out.println(
				"O jogo está acontecendo em um cenário todo aleatório.\nDurante a jornada você irá se deparar com várias criaturas de diferentes habilidades e poder.");
		System.out.println(
				"Essas criaturas estão definidas para aparecer de uma forma aleatória em seu caminho,\nOu seja, existem 5 tipos de monstros até a última fase do jogo, então pode ser que você encontre todos os 5 tipos de monstro logo na primeira fase.");
		System.out.println(
				"Também definimos um encontro aleatório do seu personagem com um viajante misterioso durante a sua jornada. Não tem hora certa para que ele apareça.\n Ele irá te oferecer POÇÃO MÁGICA( restura 100% do seu HP). O valor da poção será um valor gerado aleatórioamente baseando no seu XP.");
		System.out.println(
				"Existem 4 cenários no jogo, sendo o ultimo cenário a fase final, onde você encontrará o IMPERADOR DO MAL (chefão).\nO HP e a FORÇA do chefão está sendo baseado na sua XP que conseguiu até a fase final.");
		System.out.println(
				"Em algumas ocasiões será oferecido um dia de descanso para você.\nPoderá aceitar o descanso e ter a o HP recuperado(HP irá aumentar em um valor aleatório baseado em seu XP).\nSe sua vida estiver cheia, não será aumentado.");
		System.out.println("Esses dias de descanso serão oferecidos aleatóriamente, e poderão ser acumulados.");
		System.out.println();
		printSeparator(40);
		System.out.println("REGRAS DO JOGO");
		printSeparator(40);
		System.out.println();
		System.out.println(
				"Cada inimigo que você derrotar durante o jogo, você irá consumir o XP dele.\nQuanto mais forte seu inimigo mais XP você irá conseguir vencendo a luta.\n Quanto mais XP você tiver, mais forte serão os próximos inimigos.\nVisto que o HP, ATAQUE e DEFESA dos inimigos são baseados na sua XP");
		System.out.println(
				"Alguns inimigos te darão ouro ao serem derrotados(não serão todos).\nOuro que poderá ser usado para comprar a poção mágica quando encontrar o VIAJANTE MISTERIOSO.");
		System.out.println(
				"Durante a batalha você poderá decidir se quer LUTAR, USAR POÇÃO ou TENTAR CORRER.\n(Ao tentar correr, você terá 35% de chance de conseguir escapar do inimigo( exceto o CHEFÃO).\nSe você não conseguir escapar, sofrerá um dano CRITICO que será o dobro de um ATAQUE normal daquele inimigo.");
	}

	// método para iniciar o jogo
	public static void startGame() {
		boolean nameSet = false;
		String name;
		// mostre o titulo na tela
		clearConsole();
		anythingToContinue();

		// recebendo o nome do jogador
		do {
			clearConsole();
			printHeading("Qual é o seu nome?");
			name = scanner.next();
			// perguntar ao jogador se escolheu o nome corretamente
			clearConsole();
			printHeading("Seu nome é " + name + "\n Está correto?");
			System.out.println("(1) Sim!");
			System.out.println("(2) Não, eu quero mudar meu nome! ");
			int input = readInt("-> ", 2);
			if (input == 1) {
				nameSet = true;
			}
		} while (!nameSet); // Enquanto o nome não estiver como true(escolhido)

		// imprima introdução da história
		Story.printIntro();

		// crie um novo objeto de jogador com o nome
		player = new Player(name);

		// imprima o primeiro ato da história na introdução
		Story.printFirstActIntro();

		// Configurando isRunning para true; assim o jogo poderá continuar
		isRunning = true;

		// Começando o loop do jogo
		gameLoop();
	}

	public static void checkAct() {
		// escolha ações baseadas no xp
		if (player.xp >= 10 && act == 1) {
			// incrementa ação e lugar
			act = 2;
			place = 1;
			
			// Level Up
			player.chooseTrait();
			
			// história
			Story.printSecondActIntro();

			// Atribua novos valores aos inimigos
			enemies[0] = "Mercenário Maligno";
			enemies[1] = "Duende";
			enemies[2] = "Alcateia de Lobos";
			enemies[3] = "Capanga do Imperador Maligno";
			enemies[4] = "Estranho Assustador";

			// Atribuir novos valores aos encontros
			encounters[0] = "Batalha";
			encounters[1] = "Batalha";
			encounters[2] = "Batalha";
			encounters[3] = "Descanso";
			encounters[4] = "Shop";

		} else if (player.xp >= 50 && act == 2) {
			// incrementa ação e lugar
			act = 3;
			place = 2;

			// história
			Story.printSecondActOutro();

			// level up
			player.chooseTrait();

			// história
			Story.printThirdActIntro();
			
			
			// Atribua novos valores aos inimigos
			enemies[0] = "Um velho conhecido(fantasma)";
			enemies[1] = "Minotauro";
			enemies[2] = "Capanga do Imperador Maligno";
			enemies[3] = "Ninja";
			enemies[4] = "Demônio";

			// Atribuir novos valores aos encontros
			encounters[0] = "Batalha";
			encounters[1] = "Batalha";
			encounters[2] = "Batalha";
			encounters[3] = "shop";
			encounters[4] = "Shop";

			// curar completamente o jogador
			player.hp = player.maxHp;
			

		} else if (player.xp >= 80 && act == 3) {
			// incrementa ação e lugar
			act = 4;
			place = 3;

			// história
			Story.printThirdActOutro();
			// level up
			player.chooseTrait();
			// história
			Story.printFourthActIntro();
			
			// curar completamente o jogador
			player.maxHp = 175;
			player.hp = player.maxHp;
			player.numAtkUpgrades = 4;
			player.numDefUpgrades = 4;
			
			// chamando o final da batalha
			finalBattle();

		}
	}

	// método para calcular um encontro aleatório
	public static void randomEncounter() {

		// número aleatório entre 0 e o tamanho do array de encounters
		int encounter = (int) (Math.random() * encounters.length);
		// chamando os respectivos métodos
		if (encounters[encounter].equals("Batalha")) {
			randomBattle();
		} else if (encounters[encounter].equals("Descanso")) {
			takeRest();
		} else {
			shop();
		}
	}

	// método para continuar a jornada
	public static void continueJourney() {
		// verifique se a ação deve ser aumentada
		checkAct();
		// verifique se o jogo não está na última ação
		if (act != 4)
			randomEncounter();
	}

	// imprimindo o mais importante sobre o personagem do jogador
	public static void characterInfo() {
		clearConsole();
		printHeading("Informações do Personagem");
		System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
		printSeparator(20);
		// Xp e Gold do jogador
		System.out.println("XP: " + player.xp + "\tOuro: " + player.gold);
		printSeparator(20);
		// # of pots
		System.out.println("# Poções: " + player.pots);
		printSeparator(20);

		// imprimindo as habilidades escolhidas
		if (player.numAtkUpgrades > 0) {
			System.out.println("Habilidade ofensiva: " + player.atkUpgrades[player.numAtkUpgrades -1]);
			printSeparator(20);
		}
		if (player.numDefUpgrades > 0) {
			System.out.println("Habilidade defensiva: " + player.defUpgrades[player.numDefUpgrades - 1]);
		}
		anythingToContinue();
	}

	// encontrando um comerciante viajante
	public static void shop() {
		clearConsole();
		printHeading("Você conheceu um estranho misterioso. Ele lhe oferece algo...");
		int price = (int) (Math.random() * (8 + player.pots * 2) + 8 + player.pots);
		System.out.println("- Poção Mágica: " + price + " ouro.");
		printSeparator(20);

		// perguntar se o jogador quer comprar
		System.out.println("Comprar a poção?\n(1) Sim!\n(2) Não, obrigado.");
		System.out.println("- Seu ouro coletado: " + player.gold);
		int input = readInt("-> ", 2);
		// verificar se o jogador quer comprar
		if (input == 1) {
			clearConsole();
			// checar se ele tem ouro necessario para comprar
			if (player.gold >= price) {
				printHeading("Você comprou uma poção mágica por " + price + " ouro.");
				player.pots++;
				player.gold -= price;
				while (player.gold >= price) {
					System.out.println("Você ainda tem OURO, deseja comprar outra poção?");
					input = readInt("-> ", 2);
					if (input == 1) {
						clearConsole();
						printHeading("Você comprou  mais uma poção mágica por " + price + " ouro.");
						player.pots++;
						player.gold -= price;
					} else if(input == 2) {
						System.out.println(
								"Ótimo! Agora você tem " + player.pots + " poções ! Nos vemos por aí guerreiro");
					}
				}
			}else {
			printHeading("Você não tem dinheiro suficiente para comprar isso...");
			anythingToContinue();}}
	}

	// descansando
	public static void takeRest() {
		clearConsole();
		if (player.restLeft >= 1) {
			printHeading("Você quer descansar ? (" + player.restLeft + " restantes.)");
			System.out.println("(1) Sim\n(2) Não, agora não.");
			int input = readInt(" -> ", 2);
			if (input == 1) {
				//
				clearConsole();
				if (player.hp < player.maxHp) {
					int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
					player.hp += hpRestored;
					player.restLeft--;
					if (player.hp > player.maxHp)
						player.hp = player.maxHp;
					System.out.println("Você descansou e restaurou  " + hpRestored + " HP.");
					System.out.println("Você está agora com " + player.hp + "/" + player.maxHp + " de vida.");
					player.restLeft--;
				}
			} else
				System.out.println("Você está com a muita saúde, não quer descansar agora!");
			anythingToContinue();
		}
	}

	// Criando uma batalha aleatória
	public static void randomBattle() {
		clearConsole();
		printHeading("Você encontrou uma criatura das trevas. Agora você terá que lutar !!!");
		anythingToContinue();
		// Criando um novo inimigo com um nome aleatório.
		battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));

	}

	// método da batalha principal
	public static void battle(Enemy enemy) {
		// loop da batalha principal
		while (true) {
			clearConsole();
			printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
			printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
			System.out.println("Escolha uma ação: ");
			printSeparator(20);
			System.out.println("(1) Lutar\n(2) Usar Poção\n(3) Tentar correr");
			int input = readInt("-> ", 3);

			// reagir de acordo com a entrada do jogador
			if (input == 1) {
				// Fight
				// Calcular dano e dano recebido (took)
				int dmg = player.attack() - enemy.defend();
				int dmgTook = enemy.attack() - player.defend();

				// verifica se o dano não foi negativo
				if (dmgTook < 0) {

					// adicione algum dano se o jogador se defender bem
					dmg -= dmgTook / 2;
					dmgTook = 0;
				}
				if (dmg < 0)
					dmg = 0;

				// causar dano a ambas as partes
				player.hp -= dmgTook;
				enemy.hp -= dmg;

				// mostrar as informações dessa batalha
				clearConsole();
				printHeading("BATALHA");
				System.out.println("Você acertou " + dmg + " de dano no " + enemy.name + ".");
				printSeparator(15);
				System.out.println("O " + enemy.name + " acertou " + dmgTook + " de dano em você.");
				anythingToContinue();

				// verificar se os jogadores ainda estão vivos ou mortos
				if (player.hp <= 0) {
					playerDied(); // método para o fim do jogo
					break;

				} else if (enemy.hp <= 0) {
					// dizer ao jogador que ele ganhou
					clearConsole();
					printHeading("Você derrotou o " + enemy.name + "!");

					// Adicionar xp para o jogador
					player.xp += enemy.xp;
					System.out.println("Ganhou " + enemy.xp + " de XP!");
					//
					boolean addRest = (Math.random() * 5 + 1 <= 2.25);
					int goldEarned = (int) (Math.random() * 2 + enemy.xp);
					if (addRest) {
						player.restLeft++;
						System.out.println("Você ganhou a chance de obter um descanso adicional!");
					}
					if (goldEarned > 0) {
						player.gold += goldEarned;
						System.out.println("Você coletou " + goldEarned + " de ouro no corpo do  " + enemy.name + "!");
					}
					anythingToContinue();
					break;

				}

			} else if (input == 2) {
				// Usar poção
				clearConsole();
				if (player.pots > 0 && player.hp < player.maxHp) {
					// jogador pode tomar uma poção
					// certifique-se de que o jogador quer beber a poção
					printHeading("Você quer tomar uma poção(" + player.pots + " restantes).");
					System.out.println("(1) Sim\n(2) Não, talvez depois.");
					input = readInt("-> ", 2);
					if (input == 1) {
						// jogador realmente pegou a poção
						player.hp = player.maxHp;
						player.pots--;
						clearConsole();
						printHeading(
								"Você bebeu uma poção mágica. Ela restaurou sua saúde de volta para " + player.maxHp);
						anythingToContinue();
					}
				} else {
					// jogador não quis tomar a poção
					printHeading("Você não tem nenhuma poção ou está com saúde total.");
					anythingToContinue();
				}

			} else {
				// RUN WAY
				clearConsole();
				// verifique se o jogador não está no último ato (batalha final do chefe)
				if (act != 4) {
					// chance de 35% de correr
					if (Math.random() * 10 + 1 <= 3.5) {
						printHeading("Você fugiu do " + enemy.name + "!");
						anythingToContinue();
						break;
					} else {
						printHeading("Você não conseguiu escapar.");
						// calcular o dano que o jogador recebe
						int dmgTook = enemy.attack() * 2;
						System.out.println("Na pressa para fugir você levou " + dmgTook + " de dano crítico!");
						player.hp -= dmgTook;
						anythingToContinue();

						// verificar se os jogadores estão vivos
						if (player.hp <= 0)
							playerDied();
					}
				} else {
					printHeading("VOCÊ NÃO PODE ESCAPAR DO IMPERADOR DO MAL!!!");
				}
			}
		}
	}

	// Printando o menu principal
	public static void printMenu() {
		clearConsole();
		printHeading(places[place]);
		System.out.println("Escolha uma ação:");
		printSeparator(20);
		System.out.println("(1) Continue a jornada");
		System.out.println("(2) Informações do Personagem");
		System.out.println("(3) Sair do jogo");
	}

	// a batalha final (última) de todo o jogo
	public static void finalBattle() {

		// criando o imperador do mal e deixando o jogador lutar contra ele
		battle(new Enemy("O IMPERADOR DO MAL", 250));

		// imprimindo o final adequado
		if (player.hp <= 0) {
			playerDied();
			Story.printEndLose(player);
		} else if (player.hp >= 1) {
			Story.printEnd(player);
		}
		isRunning = false;
	}

	// método que é chamado quando o jogador está morto
	public static void playerDied() {
		clearConsole();
		printHeading("Você morreu...");
		printHeading("Você ganhou " + player.xp + "  de XP na sua jornada. Tente ganhar mais da próxima vez!");
		System.out.println("Obrigado por ter jogado meu jogo ! Espero que tenha gostado.");
		isRunning = false;
	}

	public static void sair() {
		clearConsole();
		printSeparator(30);
		System.out.println("Você decidiu se render e abandonar o jogo!");
		System.out.println("QUE PENA!");
		System.out.println("Até mais Guerreiro!");
	}

	public static void principal() {

		menu();
		int input = readInt("-> ", 4);
		if (input == 1) {
			startGame();
			;
		} else if (input == 2) {
			instruções();
			anythingToContinue();
			principal();
		} else if (input == 3) {
			creditos();
			anythingToContinue();
			principal();
			;
		} else if (input == 4) {
			sair();
			isRunning = false;
		}
	}

	// main game loop
	public static void gameLoop() {
		while (isRunning) {
			printMenu();
			int input = readInt("-> ", 3);
			if (input == 1) {
				continueJourney();
			} else if (input == 2) {
				characterInfo();
			} else {
				sair();
				isRunning = false;
			}
		}
	}

}
