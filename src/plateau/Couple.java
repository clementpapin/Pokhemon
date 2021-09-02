package plateau;

public class Couple<T,S,V> {
	private T first;
	private S second;
	private V third;
	
	public Couple(T first, S second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public T getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}
	
	public V getThird() {
		return third;
	}

	@Override
	public String toString() {
		return "{" + first + ", " + second + "}";
	}
}
