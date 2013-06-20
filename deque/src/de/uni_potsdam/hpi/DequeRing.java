package de.uni_potsdam.hpi;

public class DequeRing implements Deque {
	
	
	protected int capacity = 0;
	protected int currentSize = 0;
	
	int first = -1; // -1: Liste leer
	int last = -1;
	
	protected DequeRingElement[] ring;

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public void clear() {
		first = -1;
		last = -1;
		currentSize = 0;

	}
	
	private int nextID(int id)
	{
		if (id == capacity-1)
		{
			return 0;
		}
		else
		{
			return ++id;
		}
	}
	
	private int prevID(int id)
	{
		if (id == 0)
		{
			return capacity-1;
		}
		else
		{
			return --id;
		}
	}
	
	DequeRing(int newCapacity)
	{
		capacity = newCapacity;
		ring = new DequeRingElement[capacity];
	}

	@Override
	public void addFirst(Object e) throws DequeFull {
		if(currentSize == capacity) throw new DequeFull();
		
		if (first == -1) // Liste Leer
		{
			first = 0;
			ring[0] = new DequeRingElement(e);
			last = 0;
		}
		else
		{
			first = prevID(first);
			ring[first] = new DequeRingElement(e);
 		}
		currentSize++;

	}

	@Override
	public void addLast(Object e) throws DequeFull {
		if(currentSize == capacity) throw new DequeFull();
		
		if (last == -1) // Liste Leer
		{
			last = 0;
			ring[0] = new DequeRingElement(e);
			first = 0;
		}
		else
		{
			last = nextID(last);
			ring[last] = new DequeRingElement(e);
 		}
		currentSize++;

	}

	@Override
	public Object removeFirst() throws DequeEmpty {
		if(first == -1) throw new DequeEmpty();
		DequeRingElement toBeRemoved = ring[first];
		if (last != first) // nicht einziges Element
		{
			first = nextID(first);
			currentSize--;
		}
		else
		{
			clear();
		}
		
		return toBeRemoved.content;
	}

	@Override
	public Object removeLast() throws DequeEmpty {
		if(last == -1) throw new DequeEmpty();
		DequeRingElement toBeRemoved = ring[last];
		if (first != last) // nicht einziges Element
		{
			last = prevID(last);
			currentSize--;
		}
		else
		{
			clear();
		}
		
		return toBeRemoved.content;
	}

}
