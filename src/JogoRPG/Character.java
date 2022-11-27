package JogoRPG;

public abstract class Character {
	
	// Variáveis ​​/ Atributos que todos os personagens têm.
	public String name;
	public int maxHp, hp, xp;
	
	

	// Construtor para o personagem
	public Character(String name, int maxHp, int xp) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
	}
	
	
	// métodos que cada personagem tem
	public abstract int attack();
	public abstract int defend();
	
	
	
}
