package de.uni_potsdam.hpi;

public class DequeList implements Deque {
	
	protected int capacity = 0;
	protected int currentSize = 0;
	
	protected DequeListElement first = null;
	protected DequeListElement last = null;

	
	DequeList(int newCapacity)
	{
		this.capacity = newCapacity;
	}
	
	DequeList()
	{
		this.capacity = 1000;
	}
	
	
	
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
		first = null;
		last = null;
		currentSize = 0;
	}

	@Override
	public void addFirst(Object e) throws DequeFull {
		if(currentSize == capacity) throw new DequeFull();
		
		if (first == null) // Liste  leer
		{
			first = new DequeListElement(e, null, null);
			last = first;
		}
		else
		{
			DequeListElement firstBefore = first;
			first = new DequeListElement(e, null, firstBefore);
			firstBefore.prev = first;
		}
		
		currentSize++;
		
	}

	@Override
	public void addLast(Object e) throws DequeFull {
		if(currentSize == capacity) throw new DequeFull();
		
		if (last == null) // Liste  leer
		{
			last = new DequeListElement(e, null, null);
			first = last;
		}
		else
		{
			DequeListElement lastBefore = last;
			last = new DequeListElement(e, lastBefore, null);
			lastBefore.next = last;
		}
		
		currentSize++;
		
	}

	@Override
	public Object removeFirst() throws DequeEmpty {
		if (first==null) throw new DequeEmpty();
				
		DequeListElement toBeRemoved = first;
		
		// falls nicht einziges Element:
		if (first.next != null)
		{
			first = toBeRemoved.next;
			first.prev = null;
			currentSize--;
		}
		else
			clear();
		
		
		
		return toBeRemoved.content;
	}

	@Override
	public Object removeLast() throws DequeEmpty {
		if (last==null) throw new DequeEmpty();
		
		DequeListElement toBeRemoved = last;
		
		// falls nicht einziges Element:
		if (last.prev != null)
		{
			last = toBeRemoved.prev;
			last.next = null;
			currentSize--;
		}
		else
			clear();
		
		
		
		return toBeRemoved.content;
	}

}
