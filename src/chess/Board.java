package chess;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Chess Board is the class with tiles layout and 
 * other functions.
 * @author Judao Zhong
 * @version 2.0
 *
 */
public class Board extends Group {
//public class Board extends GridPane {    
    /** The tiles. */
    private final Square[][] squares = new Square[SIZE][SIZE];

    /** The Constant SIZE. */
    static final int SIZE = 8;
    

    /** The selected piece. */
    public Piece selectedPiece;
    
    /** The pointer white move fail. */
    public boolean pointerWhiteMoveFail;
    
    /** The pointer white move success. */
    public boolean whiteMoveSuccess;
    
    /** The pointer black move fail. */
    public boolean blackMoveFail;
    
    /** The pointer black move success. */
    public boolean blackMoveSuccess;
    
    public static int counterBlack = 16;
    
    public static int counterWhite = 16;
    /**
     * Instantiates a new board.
     */
    public Board() {
        /* Generate all Squares */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i+j) % 2 == 0 )
                squares[i][j] = new Square(i, j, Color.WHEAT);
                else 
                    squares[i][j] = new Square(i, j, Color.GRAY);
            }
        }
        
        /* Add tiles to board */
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                getChildren().addAll(squares[i][j]);
                squares[i][j].setColumn(i);
                squares[i][j].setRow(j);
            }
        }
    }
        
//        for (int i = 0; i < SIZE; i++) {
//          for (int j = 0; j < SIZE; j++) {
//              if ((i+j) % 2 == 0 )
//              squares[i][j] = new Square(i, j, Color.WHEAT);
//              else 
//                  squares[i][j] = new Square(i, j, Color.GRAY);
//          }
//      }
//      
//      /* Add tiles to board */
//      for (int i = 0; i < SIZE; i++) {
//          for (int j = 0; j < SIZE; j++) {
//              add(squares[i][j],i,j);
//              squares[i][j].setColumn(i);
//              squares[i][j].setRow(j);
//          }
//      }   
//        
//    }
//    

    /**
     * Gets the array.
     *
     * @return the array
     */
    public Square[][] getArray() {
        
        return squares;
    }
    
    /**
     * Gets the tile.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tile
     */
    public Square getSquare(double xCoor,double yCoor) {
        double temp1 = xCoor;
        int counterx = 0;
        double temp2 = yCoor;
        int countery = 0;
        while (temp1 > 75.0) {
            temp1 = temp1 - 75;
            counterx++;        
            
        }
        while (temp2 > 75.0) {
            temp2 = temp2 - 75;
            countery++;              
        }
      
        return squares[counterx][countery];      
    }
    
    /**
     * Gets the tilex.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tilex
     */
    public int getTilex(double xCoor,double yCoor) {
        double temp1 = xCoor;
        int counterx = 0;

        while (temp1 > 75.0) {
            temp1 = temp1 - 75;
            counterx++;         
        }

        return counterx;      
    }
    
    /**
     * Gets the tiley.
     *
     * @param xCoor the x coor
     * @param yCoor the y coor
     * @return the tiley
     */
    public int getTiley(double xCoor,double yCoor) {

        double temp2 = yCoor;
        int countery = 0;

        while (temp2 > 75) {
            temp2 = temp2 - 75;
            countery++;      
        }
        return countery;      
    }
    
    
    /**
     * Gets the num rows.
     *
     * @return the num rows
     */
    public int getNumRows() {
        return 8;
        
    }
    
    /**
     * Gets the num cols.
     *
     * @return the num cols
     */
    public int getNumCols() {
        return 8;
        
    }
    
    /**
     * Inits the pieces.
     */
    public void initPieces() {

        
        
        
        squares[0][0].setOccupied(true);
        squares[1][0].setOccupied(true);
        squares[2][0].setOccupied(true);
        squares[3][0].setOccupied(true);
        squares[4][0].setOccupied(true);
        squares[5][0].setOccupied(true);
        squares[6][0].setOccupied(true);
        squares[7][0].setOccupied(true);
        
        squares[0][1].setOccupied(true);
        squares[1][1].setOccupied(true);
        squares[2][1].setOccupied(true);
        squares[3][1].setOccupied(true);
        squares[4][1].setOccupied(true);
        squares[5][1].setOccupied(true);
        squares[6][1].setOccupied(true);
        squares[7][1].setOccupied(true);
        
        squares[0][6].setOccupied(true);
        squares[1][6].setOccupied(true);
        squares[2][6].setOccupied(true);
        squares[3][6].setOccupied(true);
        squares[4][6].setOccupied(true);
        squares[5][6].setOccupied(true);
        squares[6][6].setOccupied(true);
        squares[7][6].setOccupied(true);
        
        squares[0][7].setOccupied(true);
        squares[1][7].setOccupied(true);
        squares[2][7].setOccupied(true);
        squares[3][7].setOccupied(true);
        squares[4][7].setOccupied(true);
        squares[5][7].setOccupied(true);
        squares[6][7].setOccupied(true);
        squares[7][7].setOccupied(true);
     
    }
    

    
    /**
     * Select black piece.
     *
     * @param piece1 the piece 1
     */
    public void selectBlackPiece(Piece piece1) {
        
        try {
            //IF CHOSEN BLACK PIECES
            //SET ALL BLACKS TO ACTIVE
            if(piece1.getOwner().getColour()==Color.BLACK) {
                piece1.getSquare().setActive(true);
            
            }
        } catch (Exception e) {
            piece1.getSquare().setActive(false);
            System.out.println("set active failed");
        }
        
        
       
        try {
            //SET THE SQUAE TO BE NOT OCCUPIED
            if(piece1.getSquare().getActive() && piece1.getOwner().getColour() == Color.BLACK) {
                
                
            
            piece1.getSquare().setOccupied(false);
            piece1.setSquare(null);
            selectedPiece = piece1;
            

            }
        } catch (Exception e) {
            piece1.getSquare().setOccupied(true);
            e.printStackTrace();
        }
    }
    
    /**
     * Select white piece.
     *
     * @param piece1 the piece 1
     */
    public void selectWhitePiece(Piece piece1) {
        try {
        if(piece1.getOwner().getColour()==Color.WHITE) {
            try {
                piece1.getSquare().setActive(true);
            } catch (Exception e) {
                piece1.getSquare().setActive(false);
                System.out.println("Set Active failed..");
            }
           
        
        }
       
        if(piece1.getSquare().getActive() && piece1.getOwner().getColour()!=Color.BLACK) {
            
           
        
        piece1.getSquare().setOccupied(false);
        piece1.setSquare(null);
        
        }
        }catch (Exception e) {
            System.out.println("May have already done this before!!");
        }
        finally {
            selectedPiece = piece1;
        }
    }
    
    /**
     * Move black piece.
     *
     * @param x theOld x
     * @param y the y
     */
    
    
    public void moveBlackPiece(double x, double y) {
        double newx;
        double newy;
        
//        if(!getTile(x, y).isOccupied()&&selectedPiece.getOwner().getColour()!=Color.WHITE) {
        if(selectedPiece.getOwner().getColour()!=Color.WHITE) {
//            if (!getSquare(x, y).isOccupied())
            if(!getSquare(x, y).isOccupied)
            {
            newx = 75*(getSquare(x,y).getxCoor()) + 0.1;
            newy = 75*(getSquare(x,y).getyCoor()) + 0.1;
                    
                    
                selectedPiece.move(newx,newy);
                getSquare(newx,newy).setPiece(selectedPiece);
                selectedPiece.setSquare(getSquare(newx,newy));
                getSquare(newx,newy).setOccupied(true);
                
                blackMoveSuccess = true;
            } else {
                newx = 75*(getSquare(x,y).getxCoor()) + 0.1;
                newy = 75*(getSquare(x,y).getyCoor()) + 0.1;
                
                getSquare(x, y).returnPiece().setCaptured(); 
                
            selectedPiece.move(newx,newy);
            
            getSquare(newx,newy).setPiece(selectedPiece);
            selectedPiece.setSquare(getSquare(newx,newy));
            getSquare(newx,newy).setOccupied(true);
            
            blackMoveSuccess = true;
            }
            counterBlack--;
            
            } else
        blackMoveFail = true;
    }
    
    /**
     * Move white piece.
     *
     * @param x the x
     * @param y the y
     */
    public void moveWhitePiece(double x, double y) {
        double newx;
        double newy;
        

        if(selectedPiece.getOwner().getColour()!=Color.BLACK) {
           if (!getSquare(x, y).isOccupied()) {
               newx = 75*(getSquare(x,y).getxCoor()) + 0.1;
           

            newy = 75*(getSquare(x,y).getyCoor()) + 0.1;
            
           
        selectedPiece.move(newx,newy);
        getSquare(newx,newy).setPiece(selectedPiece);
        selectedPiece.setSquare(getSquare(newx,newy));
        getSquare(newx,newy).setOccupied(true);
        whiteMoveSuccess = true;
        
           } else {
               newx = 75*(getSquare(x,y).getxCoor()) + 0.1;
               

               newy = 75*(getSquare(x,y).getyCoor()) + 0.1;
               
               getSquare(x, y).returnPiece().setCaptured();
               
           selectedPiece.move(newx,newy);
           getSquare(newx,newy).setPiece(selectedPiece);
           selectedPiece.setSquare(getSquare(newx,newy));
           getSquare(newx,newy).setOccupied(true);
          
              
           whiteMoveSuccess = true;
           }
           counterWhite--;
           
        } else {
            pointerWhiteMoveFail = true;
        }
    }
    
    /**
     * Gets the selected piece.
     *
     * @return the selected piece
     */
    public Piece getSelectedPiece() {
        return selectedPiece;
    }
}