
public class Line implements Comparable<Line> {
	private double weight;
	private String word;

	public Line(double weight, String word) {
		setWeight(weight);
		setWord(word);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight2) {
		if(weight2 > 0)
		{
			this.weight = weight2;
		}
		else this.weight = 0;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		if(word != null)
		{
			this.word = word.trim().toLowerCase();
		}
	}

	@Override
	public String toString() {
		return "Line [weight=" + weight + ", word=" + word + "]";
	}

	@Override
	public int compareTo(Line o) {
		// TODO Auto-generated method stub
		return 0;
	}




}
