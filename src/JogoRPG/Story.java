package JogoRPG;

public class Story {
	
	//classe que não faz nada além de armazenar métodos para imprimir cada parte da história
	  public static void printIntro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("HISTÓRIA");
	        GameLogic.printSeparator(30);
	        System.out.println("Você é o último homem de pé depois que sua aldeia foi invadida pelos capangas do imperador do mal");
	        System.out.println("Todos os seus amigos, familiares e vizinhos foram assassinados. Você está parado nas ruínas em chamas desta outrora grande vila");
	        System.out.println("Tudo o que você quer agora é vingança, então você começa a planejar sua jornada para derrotar o imperador do mal e libertar as terras!");
	        GameLogic.anythingToContinue();
	    }

	    public static void printFirstActIntro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO I - INTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Ao iniciar sua jornada, você começa a viajar pelas florestas próximas para alcançar as montanhas eternas");
	        System.out.println("\nDepois de um longo dia caminhando pela floresta, você finalmente chega às montanhas eternas.");
	        System.out.println("\r\nVocê não se importa com os perigos à frente, sua única preocupação é derrotar o imperador do mal.");
	        GameLogic.anythingToContinue();
	    }

	    public static void printFirstActOutro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO 1 - OUTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você fez isso! Você cruzou as montanhas eternas e ainda está vivo!");
	        System.out.println("Ao descer a última colina, você fica mais do que feliz em sentir o chão duro sob seus pés novamente.");
	        System.out.println("\nVocê se sente fortalecido e a experiência adquirida permite que você aprenda outra característica!");
	        GameLogic.anythingToContinue();
	    }

	    public static void printSecondActIntro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO II - INTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você começa a viajar pelas ruas de uma cidade outrora bem povoado, e agora somente com fantasmas e demônios");
	        System.out.println("Você coletou um pouco de ouro dos monstros que matou ao longo do caminho.");
	        System.out.println("Felizmente você sabe que de vez em quando um comerciante viajante se depara por essas bandas");
	        System.out.println("Você sabe exatamente onde fica o castelo do imperador do mal, mas você tem que cruzar essas ruas assombradas primeiro...");
	        GameLogic.anythingToContinue();
	    }

	    public static void printSecondActOutro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO II - OUTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você conseguiu cruzar as ruas  assombradas da cidade e ainda é noite, mas a dia se aproxima!");
	        System.out.println("Você está a apenas algumas horas de seu destino final; a casa do imperador do mal!");
	        System.out.println("Você sabe que provavelmente não pode descansar lá, então faz uma última pausa para restaurar um pouco de saúde");
	        System.out.println("\nVocê se sente fortalecido e a experiência adquirida permite que você aprenda outra característica!");
	        GameLogic.anythingToContinue();
	    }

	    public static void printThirdActIntro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO  III - INTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você vê o enorme castelo preto à sua frente.");
	        System.out.println("Enquanto você fica na frente dos portões, você sabe que não há como voltar atrás");
	        System.out.println("Você está disfarçado de mercenário e entra no castelo. Você não sabe quanto tempo resta antes que alguém o descubra.");
	        GameLogic.anythingToContinue();
	    }

	    public static void printThirdActOutro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO III - OUTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você chegou tão longe. Você derrotou todos os asseclas do imperador do mal.");
	        System.out.println("Ao ficar em frente à porta da sala do trono, você sabe que não há como voltar atrás");
	        System.out.println("Você recupera seu poder perdido e restaura sua saúde");
	        System.out.println("Você tem a chance de aprender uma última característica antes de entrar na sala do trono.");
	        GameLogic.anythingToContinue();
	    }

	    
	    public static void printFourthActIntro() {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("EPISÓDIO IV - INTRO");
	        GameLogic.printSeparator(30);
	        System.out.println("Você entra na sala do trono do imperador do mal.");
	        System.out.println("Ele te encara morto nos olhos. Você sente a escuridão ao seu redor.");
	        System.out.println("Ele pega a espada profana das trevas, a arma mais poderosa conhecida pelo homem.");
	        System.out.println("Tudo o que você pode fazer é lutar por sua vida e rezar para sair como o vencedor...");
	        GameLogic.anythingToContinue();
	    }

	    public static void printEnd(Player player) {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("Parabéns Guerreiro , " + player.name + "! Você derrotou o imperador do mal e vingou a morte de seus familiares e amigos!");
	        System.out.println("A ordem foi resturada em seu reino, e você se tornou o IMPERADOR de todos os reinos da terra.");
	        GameLogic.printSeparator(30);
	        GameLogic.creditos();
	    }
	    
	    
	    public static void printEndLose(Player player) {
	        GameLogic.clearConsole();
	        GameLogic.printSeparator(30);
	        System.out.println("Que pena Guerreiro , " + player.name + "! Você não derrotou o imperador do mal e acabou morto como todos os outros");
	        System.out.println("Tente outra vez! Confiamos em você para nos livrar das criaturas das trevas");
	        GameLogic.printSeparator(30);
	    }
	    
}