package de.uni_potsdam.hpi;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque testList = new DequeRing(1000);
		// Deque testRing = new DequeRing(1000);
		
		for (int i=1; i<=10; i++)
		{
			int e = i;
			try {
				testList.addFirst(e);
				System.out.println("yo." + i);
			} catch (DequeFull e1) {
				e1.printStackTrace();
			}
		}
		
		for (int i=1; i<=10; i++)
		{
			try {
				System.out.println(testList.removeFirst());
			} catch (DequeEmpty e) {
				e.printStackTrace();
			}
		}
	}

}
