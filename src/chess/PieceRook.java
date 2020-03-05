package chess;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Chess PieceRook is a child class of Piece.
 * 
 * @author Judao Zhong
 * @version 1.0
 *
 */
public class PieceRook extends Piece {
    private Image image;

//    private Tile initSQR=getTile();
    public double xPos;
    public double yPos;
    public ImageView iv;

    public PieceRook(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if (type.getColour() == Color.WHITE) {
            // image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Rook.png";
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
            img = "file:src/ChessPiece/Black_Rook.png";
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
        iv = new ImageView(image);
//        imageView.setImage(image);
//        imageView.fitHeightProperty();
//        imageView.fitWidthProperty();
//        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
//        imageView.setCache(true);
//        iv.setX(getSquare().getX()*80);
        iv.setY(yPos);
        iv.setX(xPos);
        getChildren().add(iv);
    }

//    @Override
//    public boolean validMove() {
//        // TODO Auto-generated method stub
//        return true;
//    }
    public void move(double xCoor, double yCoor) {

        iv.setX(xCoor);
        iv.setY(yCoor);

    }

    public void setCaptured() {
        setSquare(null);

        if (getOwner().getColour() == Color.WHITE) {
            iv.setX(650);
            iv.setY(180);

        } else {
            iv.setX(750);
            iv.setY(180);
        }

    }

    @Override
    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board) {
        ArrayList<Square> availableSquares = new ArrayList<>();
        int i = 0;

        // down
        double j = thisSquare.getY();
        while (j < 526) {
        try {
                j += 75.01;
                availableSquares.add(board.getSquare(thisSquare.getX() + 1, j));
                availableSquares.get(i).setRow(board.getSquare(thisSquare.getX() + 1, j).getRow());
                availableSquares.get(i).setColumn(board.getSquare(thisSquare.getY() + 1, j).getColumn());
                i++;         
            
            } catch (Exception e) {
                System.out.println("some not added");
                continue;
                
            }
        if (board.getSquare(thisSquare.getX() + 1, j).isOccupied) {
            if (board.getSquare(thisSquare.getX() + 1, j).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                availableSquares.remove(i-1);
                i--;
            }
            break;
        }
        }
        
       
        // right
        double k = thisSquare.getX();
        while (k < 526) {
        try {
                k += 75.000;
//                if(board.getSquare(k, thisSquare.getY() + 1).returnPiece().player.colour == thisSquare.returnPiece().player.colour)
//                    break;
                availableSquares.add(board.getSquare(k, thisSquare.getY() + 1));
               
                availableSquares.get(i).setRow(board.getSquare(k, thisSquare.getX() + 1).getRow());
                availableSquares.get(i).setColumn(board.getSquare(k, thisSquare.getY() + 1).getColumn());
                i++;

        } catch (Exception e) {
            System.out.println("some not added");
//            continue;
        }
        if (board.getSquare(k, thisSquare.getY()+1).isOccupied) {
            if (board.getSquare(k, thisSquare.getY()+1).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                availableSquares.remove(i-1);
                i--;
            }
            break;
        }

        }
//        // up
//        double l = thisSquare.getY() + 75;
//        while (l > 75 && !board.getSquare(thisSquare.getX() + 1, l -76).isOccupied) {
//            try {
//                if (board.getSquare(thisSquare.getX(), l).returnPiece().player.colour != null
//                        && board.getSquare(thisSquare.getX(), l).returnPiece().player.colour != thisSquare
//                                .returnPiece().player.colour) {
//                   
//                    break;
//                }
//            } catch (Exception e) {
//                System.out.println("!!!!!!!!!");
//            }
//            l -= 76.00;
//
//            availableSquares.add(board.getSquare(thisSquare.getX() + 1, l));
//            availableSquares.get(i).setRow(board.getSquare(thisSquare.getX() + 1, l).getRow());
//            availableSquares.get(i).setColumn(board.getSquare(thisSquare.getX() + 1, l).getColumn());
//            i++;
//
//        }
        
        // up
        double l = thisSquare.getY() + 75;
        while (l > 75) {
        try {
                l -= 75.01;
                availableSquares.add(board.getSquare(thisSquare.getX() + 1, l));
                availableSquares.get(i).setRow(board.getSquare(thisSquare.getX() + 1, l).getRow());
                availableSquares.get(i).setColumn(board.getSquare(thisSquare.getY() + 1, l).getColumn());
                i++;         
            
            } catch (Exception e) {
                continue;
            }
        if (board.getSquare(thisSquare.getX() + 1, l).isOccupied) {
            if (board.getSquare(thisSquare.getX() + 1, l).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                availableSquares.remove(i-1);
                i--;
            }
            break;
        }
        }       

        // left
        double m = thisSquare.getX() + 75;
        while (m > 0 && !board.getSquare(m -1 , thisSquare.getY() +1).isOccupied) {
            try {
                m -= 76.000;
                availableSquares.add(board.getSquare(m-1, thisSquare.getY() + 1));
                availableSquares.get(i).setRow(board.getSquare(m-1, thisSquare.getY() + 1).getRow());
                availableSquares.get(i).setColumn(board.getSquare(m-1, thisSquare.getY() + 1).getColumn());
                i++;
            } catch (Exception e) {
                continue;
            }
            if (board.getSquare(m -1 , thisSquare.getY() +1).isOccupied) {
                if (board.getSquare(m -1 , thisSquare.getY() +1).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                    availableSquares.remove(i-1);
                    i--;
                }
                break;
            }

        }
        
        return availableSquares;
    
    
    }
}