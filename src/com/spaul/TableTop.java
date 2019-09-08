package com.spaul;

public class TableTop {

    private int tableWidth = 5; //max width (X)
    private int tableHeight = 5; //max height (Y)

    private static TableTop tableTopInstance;

    /**
     * Private Constructor to prevent any other class from instantiating.
     */
    private TableTop() {
        //Prevent form the reflection api.
        if (tableTopInstance != null)
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    /**
     *  Static instance method
     */
    public synchronized static TableTop getInstance(){
        if (tableTopInstance == null)// If there is no instance available then create new one.
            tableTopInstance = new TableTop();
        return tableTopInstance;
    }

    /**
     * Check if the position is on the table top
     * @param X
     * @param Y
     * @return true/false
     */
    public boolean isPositionValid(int X, int Y){
        return (isXPositionValid(X) && isYPositionValid(Y));
    }

    //check the X axis

    /**
     * Check the X axis position is on the board
     * @param X
     * @return true/false
     */
    public boolean isXPositionValid(int X){
        return (X >= 0 && X < tableWidth);
    }

    /**
     * Check the Y axis position is on the board
     * @param Y
     * @return true/false
     */
    public boolean isYPositionValid(int Y){
        return (Y >= 0 && Y < tableHeight);
    }

    /**
     * Get Table Width
     * @return
     */
    public int getWidth() {
        return tableWidth;
    }

    /**
     * Get Table Height
     * @return
     */
    public int getHeight() {
        return tableHeight;
    }

    /**
     * Future....can change table top dimension
     * @param tableWidth
     * @param tableHeight
     */
    public void setTableDimension(int tableWidth, int tableHeight) {
        this.tableWidth = tableWidth;
        this.tableHeight = tableHeight;
    }


}
