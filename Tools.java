package researchproject;

import repast.simphony.space.grid.Grid;

public class Tools
{
	/**
	 * Get coordinates of a grid cell located in a given direction from a given grid cell coordinates
	 * @param direction - direction to the other cell
	 * @param thisX - X coordinate of this cell
	 * @param thisY - Y coordinate of this cell
	 * @return set of coordinates of the other cell (X,Y)
	 */
	public final static int[] dirToCoord(int direction, int thisX, int thisY)
	{
		int x = thisX, y = thisY;
		
		switch (direction)
		{
	        case 0:  y++;
	                 break;
	        case 1:  x++; y++;
	                 break;
	        case 2:  x++;
	                 break;
	        case 3:  x++; y--;
	                 break;
	        case 4:  y--;
	                 break;
	        case 5:  x--; y--;
	                 break;
	        case 6:  x--;
	                 break;
	        case 7:  x--; y++;
		}
		
		return new int[] {x,y};
	}
	/**
	 * Check that given grid cell coordinates lay inside a given grid
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 * @param grid - a grid to check against
	 * @return 0 - if out of borders, 1 - if within borders
	 */
	public static boolean isWithinBorders(int x, int y, Grid<Object> grid)
	{
		return (x >= 0 && y >= 0 && x < grid.getDimensions().getWidth() && y < grid.getDimensions().getHeight());
	}
	
	public static int getDistanceTo(int x1, int y1, int x2, int y2){
		int dx = Math.abs(x2 - x1);
	    int dy = Math.abs(y2 - y1);

	    return Math.max(dx, dy);
	}
}
