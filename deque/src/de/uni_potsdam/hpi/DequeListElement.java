package de.uni_potsdam.hpi;

public class DequeListElement {

	/**
	 * @param args
	 */
	
	public DequeListElement next = null;
	public DequeListElement prev = null;
	public Object content;
	
	DequeListElement(Object ElContent, DequeListElement newPrev, DequeListElement newNext) {
		this.content = ElContent;
		this.prev = newPrev;
		this.next = newNext;
	}

}
