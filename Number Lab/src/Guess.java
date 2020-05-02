import java.util.Scanner;

public class Guess {
	protected int g1;
	protected int g2;
	protected int g3;
	private boolean followsRule;
	
	public Guess(int g1, int g2, int g3, boolean followsRule) {
		this.g1 = g1;
		this.g2 = g2;
		this.g3 = g3;
		this.followsRule = followsRule;
	}

	
	@Override
	public String toString() {
		return "your guess is [g1=" + g1 + ", g2=" + g2 + ", g3=" + g3 +" "+ followsRule+ " "+ "]";
	}



}
