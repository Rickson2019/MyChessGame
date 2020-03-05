package chess;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Chess PiecePawn is a extended class of Piece.
 * 
 * @author Judao Zhong
 *
 */
public class PiecePawn extends Piece {
    private Image image;

//    private Tile initSQR=getTile();
    public double xPos;
    public double yPos;
    private static final double  leftGridValues = 1;
    private static final double  rightGridValues = 75.02;
    private static final double  upGridValues = 1;
    private static final double  downGridValues = 75.02;
    private ImageView iv;

    public PiecePawn(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if (type.getColour() == Color.WHITE) {
            // image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Pawn.png";
            // ImageView imageView = new ImageView();
            // imageView.setImage(image);
            // setSquare(initSQR);
//            imageView.fitHeightProperty();
//            imageView.fitWidthProperty();
//            imageView.setPreserveRatio(true);
//            imageView.setSmooth(true);
//            imageView.setCache(true);

            xPos = x;
            yPos = y;
        } else {
            img = "file:src/ChessPiece/Black_Pawn.png";
            // ImageView imageView = new ImageView();
            // imageView.setImage(image);
//            imageView.fitHeightProperty();
//            imageView.fitWidthProperty();
//            imageView.setPreserveRatio(true);
//            imageView.setSmooth(true);
//            imageView.setCache(true);

            xPos = x;
            yPos = y;
        }
        this.image = new Image(img);
        setIv(new ImageView(image));
//        imageView.setImage(image);
//        imageView.fitHeightProperty();
//        imageView.fitWidthProperty();
//        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
//        imageView.setCache(true);
//        iv.setX(getSquare().getX()*80);
        getIv().setY(yPos);
        getIv().setX(xPos);
        getChildren().add(getIv());
    }

    @Override
//    public boolean validMove() {
//        // TODO Auto-generated method stub
//        return true;
//    }
    public void move(double xCoor, double yCoor) {

        getIv().setX(xCoor);
        getIv().setY(yCoor);

    }

    @Override
    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board) {
        ArrayList<Square> availableSquares = new ArrayList<>();
        int i = 0;
        // Black Player
        if (player.getColour() == Color.BLACK) {

            try {
                // X direction right take out
                if (board.getSquare(thisSquare.getX() + rightGridValues * 1, thisSquare.getY() + downGridValues * 1).isOccupied) {
                    availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 76 * 1));
                    availableSquares.get(i).setRow(thisSquare.getRow()+1);
                    availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
                    i = i++;
                }
            } catch (Exception e) {
                System.out.println("Some may be out of Bs");
            }

            // X direction take out left
            if (board.getSquare(thisSquare.getX() - leftGridValues, thisSquare.getY() + downGridValues * 1).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() - leftGridValues, thisSquare.getY() + downGridValues *1));
                availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
                i = i++;
            }

            // Specific move at the start
            if (thisSquare.getRow() < 3) {
                //MOVE ONE STEP 
                if(!board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + downGridValues * 1).isOccupied ) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1));
                availableSquares.get(i).setRow(thisSquare.getRow() + 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn());
                i = i++;
                
                }
                
                if(!board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + downGridValues * 1).isOccupied
                && !board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + downGridValues * 2).isOccupied) {
                    //MOVE TWO STEPS
                    availableSquares.add(board.getSquare(thisSquare.getX() + 0.2, thisSquare.getY() + 76 * 2));
                    availableSquares.get(i).setRow(thisSquare.getRow() + 2);
                    availableSquares.get(i).setColumn(thisSquare.getColumn());
                    i = i++;
                }
            }

            if (thisSquare.getRow() >= 3 && thisSquare.getRow() < 8) {
                // Y direction Can only move once
                if (!board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1).isOccupied()) {
                    availableSquares.add(board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1));
                    availableSquares.get(i).setRow(thisSquare.getRow() + 1);
                    availableSquares.get(i).setColumn(thisSquare.getColumn());
                    i = i++;
                }
                
                
                if (thisSquare.getRow() >= 4 && thisSquare.getRow() < 8) {
                // Move either left or right
                    // Move Left
                    if (!board.getSquare(thisSquare.getX() - leftGridValues , thisSquare.getY() + 1  ).isOccupied()) {
                        availableSquares.add(board.getSquare(thisSquare.getX() - leftGridValues , thisSquare.getY()+1));
                        availableSquares.get(i).setRow(thisSquare.getRow());
                        availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
                        i = i++;
                    }

                    // Move Right
                    if (!board.getSquare(thisSquare.getX() + rightGridValues, thisSquare.getY() +1).isOccupied()) {
                        availableSquares.add(board.getSquare(thisSquare.getX() + rightGridValues, thisSquare.getY() + 1));
                        availableSquares.get(i).setRow(thisSquare.getRow());
                        availableSquares.get(i).setColumn(thisSquare.getColumn()+1);
                        i = i++;
                    }
                }

            }

        }
        // White Player

        else if (player.getColour() == Color.WHITE) {

            // take out enemy pieces
            // Take out the One on the Right
            try {
                if (board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 1)!=null && board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 1).isOccupied) {

                    availableSquares.add(board.getSquare(thisSquare.getX() + 75.01 * 1, thisSquare.getY() -1));

                    availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                    availableSquares.get(i).setColumn(thisSquare.getColumn());

                    i = i++;
                }
            } catch (Exception e) {
                System.out.println("some may be out of bound");
            }
            // Take out the One on the Left
            if (board.getSquare(thisSquare.getX() - 0.2, thisSquare.getY() - 1).isOccupied) {

                availableSquares.add(board.getSquare(thisSquare.getX() - 1, thisSquare.getY() - 1));

                availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
                i=i++;
            }

            // Move either two grids or just one for the first movement
            if (thisSquare.getRow() == 6) {
                // Move 2 grids
                if(!board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() - 0.1).isOccupied   &&
                   !board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() -downGridValues * 1 ).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() - 75 * 1));
                availableSquares.get(i).setRow(thisSquare.getRow() - 2);
                availableSquares.get(i).setColumn(thisSquare.getColumn());
                i = i++;
                }
                
                if (!board.getSquare(thisSquare.getX() + 0.2, thisSquare.getY()).isOccupied) {
                    // Move 1 grid
                    availableSquares.add(board.getSquare(thisSquare.getX() + 0.2, thisSquare.getY()));
                    availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                    availableSquares.get(i).setColumn(thisSquare.getColumn());
                    i=i++;
                }
            }

            // Move only one grid forward after the first move
            if (thisSquare.getRow() >= 1 && thisSquare.getRow() <= 5) {
                System.out.println("thisRow" + thisSquare.getRow());
              
                    if (!board.getSquare(thisSquare.getX() +0.2 , thisSquare.getY()-upGridValues).isOccupied) {
                        availableSquares.add(board.getSquare(thisSquare.getX() + 0.2, thisSquare.getY()-upGridValues));
                        availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                        availableSquares.get(i).setColumn(thisSquare.getColumn());
                        i = i++;
                    }
                

                // Move either left or right
                if (thisSquare.getRow() <= 4) {
                    // Move Left
                    if (!board.getSquare(thisSquare.getX() - 1 , thisSquare.getY() +1 ).isOccupied()) {
                        availableSquares.add(board.getSquare(thisSquare.getX() -1 , thisSquare.getY()+1));
                        availableSquares.get(i).setRow(thisSquare.getRow());
                        availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
                        i = i++;
                    }

                    // Move Right
                    if (!board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() +1).isOccupied()) {
                        availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 1));
                        availableSquares.get(i).setRow(thisSquare.getRow());
                        availableSquares.get(i).setColumn(thisSquare.getColumn()+1);
                        i = i++;
                    }
                }

            }
        }

        return availableSquares;
    }

    public void setCaptured() {
        setSquare(null);
     
        if (getOwner().getColour() == Color.WHITE) {
            getIv().setX(650);
            getIv().setY(500);
        } else {
            getIv().setX(750);
            getIv().setY(500);
        }
    
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }

//    @Override
//    public ArrayList<Square> movePattern(Player player, Square thisSquare,Board board) {
//        ArrayList<Square> availableSquares = new ArrayList<>();
//        int i = 0;
//        if(player.getColour()==Color.BLACK) {
//            if(thisSquare.getRow()<4) {
//                availableSquares.add(board.getSquare(thisSquare.getX(),thisSquare.getY()));
//            }
//    }
//        return availableSquares;
//    
}
