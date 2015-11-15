package tp.pr4;

public enum Directions {
	NORTH,
	EAST,
	SOUTH,
	WEST,
	UNKNOWN;
	
	/*----------------------------------------------------------------------------------------------------------
	 * Returns the opposite of a command verb
	 * Returns:
	 	SOUTH if the typed verb command is NORTH
	 	WEST if the typed verb command is EAST
	 	NORTH if the typed verb command is SOUTH
	 	EAST if the typed verb command is WEST
	 ----------------------------------------------------------------------------------------------------------*/
	public Directions getOposite()
	{
		switch(this)
		{
		case NORTH:
			return SOUTH;

		case EAST:
			return WEST;

		case SOUTH:
			return NORTH;

		case WEST:
			return EAST;
		}
		return UNKNOWN;

	}

}
