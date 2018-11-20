/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 8
 * Date: Nov 19, 2018
 */

/**
 * Creates and modifies a generic array of objects
 * @author Olivier Lauzon
 * @version 1.0
 * @since 1.8
 */
public class GenericArray<T> {
	/**
	 * Capacity of the array
	 */
	private int capacity;
	
	/**
	 * Size of the array ie: amount of objects in the array
	 */
	private int size;  
	
	/**
	 * An array of Objects that gets modified
	 */
	public Object[] tArray;
	
	/**
	 * Default constructor, Constructs an empty GenericArray with an initial capacity of ten
	 */
	public GenericArray() 
	{
		this(10);
	}

	/**
	 * Initial constructor, Constructs an empty GenericArray with the specified initial capacity
	 * @param initialCapacity Will determine the capacity of the tArray
	 * @throws IllegalArgumentException If the specified parameter is smaller that 0
	 */
	public GenericArray(int initialCapacity) throws IllegalArgumentException
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException();
		
		size = 0;
		capacity = initialCapacity;
		//stringArray = new String[initialCapacity];
		tArray = new Object[initialCapacity];
	}

	/**
	 * Constructs a GenericArray that is a copy of a given GenericArray
	 * @param sa Object of GenericArray
	 * @throws NullPointerException is thrown if the specified object is null
	 */
	public GenericArray(GenericArray<T> sa) throws NullPointerException
	{
		this(sa.capacity);

		if (sa == null)
			throw new NullPointerException();
		
		this.size = sa.size;
		
		for(int i = 0; i < size; i++)
		{
			tArray[i] = sa.tArray[i];
		}
	}

	/**
	 * Appends the specified string to the end of this GenericArray. Increases capacity if needed
	 * @param s String to add to the array
	 * @throws NullPointerException is thrown if the specified object is null
	 */
	public void add(T s) throws NullPointerException
	{
		try {
			add(size, s);
		}
		catch (NullPointerException ex) {
			throw ex;
		}
		catch (IndexOutOfBoundsException ex) {
			// do nothing, this should never occur
		}
	}

	/**
	 * Inserts the specified object at the specified position in this GenericArray. Increases capacity if needed
	 * @param index The index at which we add the object
	 * @param s the object that will be added
	 * @throws NullPointerException is thrown if the specified object is null
	 * @throws IndexOutOfBoundsException is thrown if the specified index is <0 or >size()
	 */
	public void add(int index, T s) throws NullPointerException, IndexOutOfBoundsException
	{
		if (s == null)
			throw new NullPointerException();
		
		if (index > size)
			throw new IndexOutOfBoundsException();
		
		if(size == capacity)
			ensureCapacity(capacity + capacity/2);

		for(int i = size; i > index; i--)
		{
			tArray[i] = tArray[i-1];
		}
		
		tArray[index] = s;
		
		size++;
	}

	/**
	 * Returns the capacity of this GenericArray
	 * @return The value of the capacity
	 */
	public int capacity() 
	{
		return capacity;
	}

	/**
	 * Removes all of the Strings from this GenericArray
	 */
	public void clear() 
	{
		for(; size > 0; size--)
			tArray[size - 1] = null;
	}

	/**
	 * Returns true if this GenericArray contains the specified object
	 * @param s the object that we are looking for in the array
	 * @return true if the object is found and false if it is not
	 */
	public boolean contains(T s) throws NullPointerException
	{	
		return indexOf(s) > -1;
	}

	/**
	 * Increases the capacity of this GenericArray instance, if necessary to ensure that
	 * it can hold at least the number of objects specified by the minimum capacity argument
	 * @param minCapacity determines the capacity that the array needs to be 
	 * @throws CapacityOutOfBoundsException is thrown if the specified capacity is <size()
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException
	{
		if (minCapacity <= size)
			throw new CapacityOutOfBoundsException();
		
		if(capacity < minCapacity)
		{
			capacity = minCapacity;
			//String[] temp = new String[capacity];
			Object[] temp = (new Object[capacity]);
			for(int i = 0 ; i < size; i++)
			{
				temp[i] = tArray[i];
			}
			tArray = temp;
		}
	}

	/**
	 * Returns the object at the specified position in this GenericArray.
	 * @param index the index of the array that we want to retrieve
	 * @return the object at the specified index
	 */
	public Object get(int index) throws IndexOutOfBoundsException
	{
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return tArray[index];
	}

	/**
	 * Returns the index of the first occurrence of the specified object in this GenericArray,
	 * or -1 if this GenericArray does not contain the object
	 * @param s the object that we are looking for
	 * @return the index of the specified object
	 */
	public int indexOf(T s) throws NullPointerException
	{
		if (s == null)
			throw new NullPointerException();
		
		int found = -1;

		for(int i = 0; i < size; i++)
		{
			if(s.equals(tArray[i]))
			{
				found = i;
				break;
			}
		}
		return found;
	}

	/**
	 * Returns true if this GenericArray contains no objects
	 * @return true if the array has no objects and false if not
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * Removes the object at the specified position in this GenericArray.
	 * Return the object previously at the specified position.
	 * @param index the index of the object that we wish to remove
	 * @return the object that was previously at that position
	 */
	public Object remove(int index) throws IndexOutOfBoundsException
	{
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Object oldString = tArray[index];
		
		for(; index < size; index++)
		{
			tArray[index]= tArray[index + 1];
		}
		
		size--;
		return oldString;
	}

	/**
	 * Removes the first occurrence of the specified object from this GenericArray, if it is present.
	 * Return true if this GenericArray contained the specified object
	 * @param s the object that we wish to remove
	 * @return true if the array contained the specified object and false if not
	 */
	public boolean remove(T s) throws NullPointerException
	{	
		int index = indexOf(s);
		remove(index);
		return index > -1;
	}

	/**
	 * Replaces the object at the specified position in this GenericArray with the specified object.
	 * Return the object previously at the specified position.
	 * Increases capacity if needed
	 * @param index the index at which we want to set the string
	 * @param s the string that we wish to set
	 * @return the object that was at the specified index previously
	 * @throws IndexOutOfBoundsException is thrown if the specified index is <0 or >size()
	 * @throws NullPointerException is thrown if the specified object is null
	 */
	public Object set(int index, T s) throws IndexOutOfBoundsException, NullPointerException
	{
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		if (s == null)
			throw new NullPointerException();
		
		Object oldString;
		
		if(index > capacity)
		{
			ensureCapacity(index + 1);
			oldString = null;
		} else {
			oldString = tArray[index];
		}
		
		if(index >= size)
		{
			size = index + 1;
		}
		
		tArray[index] = s;
		return oldString;
	}

	/**
	 * Returns the number of object in this GenericArray
	 * @return the size of the array(amount of object in the array)
	 */
	public int size() 
	{
		return size;
	}

}
