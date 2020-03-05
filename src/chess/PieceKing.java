package chess;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PieceKing extends Piece {
    private Image image;
    private static final double leftGridValues = 1;
    private static final double rightGridValues = 75.02;
    private static final double upGridValues = 1;
    private static final double downGridValues = 75.02;
    public double xPos;
    public double yPos;
    public ImageView iv;

    public PieceKing(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if (type.getColour() == Color.WHITE) {

            img = "file:src/ChessPiece/White_King.png";

            xPos = x;
            yPos = y;
        } else {
            img = "file:src/ChessPiece/Black_King.png";

            xPos = x;
            yPos = y;
        }
        this.image = new Image(img);
        iv = new ImageView(image);

        iv.setY(yPos);
        iv.setX(xPos);
        getChildren().add(iv);
    }

//    @Override
//    public boolean validMove() {
//
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
            iv.setY(100);
        } else {
            iv.setX(750);
            iv.setY(100);
        }

    }

    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board) {
        ArrayList<Square> availableSquares = new ArrayList<>();
        int i = 0;

        // Y+1
        try {
            if (!board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1).isOccupied
                    || board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 0.1, thisSquare.getY() + 76 * 1));
                availableSquares.get(i).setRow(thisSquare.getRow());
                availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
            }
        } catch (Exception e) {
            System.out.println("Y+1 not added");
        }

        // Y-1
        try {
            if (!board.getSquare(thisSquare.getX() + 0.00001, thisSquare.getY() - upGridValues).isOccupied
                    || board.getSquare(thisSquare.getX() + 0.00001, thisSquare.getY() - upGridValues)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 0.00001, thisSquare.getY() - upGridValues));
                availableSquares.get(i).setRow(thisSquare.getRow());
                availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
            }
        } catch (Exception e) {
            System.out.println("Y-1 not added");
        }

        // X-1
        try {
            if (!board.getSquare(thisSquare.getX() - upGridValues, thisSquare.getY() + 1).isOccupied
                    || board.getSquare(thisSquare.getX() - upGridValues, thisSquare.getY() + 1)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour) {
            availableSquares.add(board.getSquare(thisSquare.getX() - upGridValues, thisSquare.getY() + 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 1);
            availableSquares.get(i).setColumn(thisSquare.getColumn());
            }
        } catch (Exception e) {
            System.out.println("X-1 not added");
        }

        // X+1
        try {
            if (!board.getSquare(thisSquare.getX() - rightGridValues, thisSquare.getY() + 0.01).isOccupied
                    || board.getSquare(thisSquare.getX() - rightGridValues, thisSquare.getY() + 0.01)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour) {
            availableSquares.add(board.getSquare(thisSquare.getX() + rightGridValues, thisSquare.getY() + 0.01));
            availableSquares.get(i).setRow(thisSquare.getRow() + 1);
            availableSquares.get(i).setColumn(thisSquare.getColumn());
            }
        } catch (Exception e) {
            System.out.println("X+1 not added");
        }

        // X+1, Y+1 working
        try {
            if (!board.getSquare(thisSquare.getX() - rightGridValues, thisSquare.getY() + downGridValues * 1).isOccupied
                    || board.getSquare(thisSquare.getX() - rightGridValues, thisSquare.getY() + downGridValues * 1)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour) {
                    availableSquares.add(
                    board.getSquare(thisSquare.getX() + rightGridValues * 1, thisSquare.getY() + downGridValues * 1));
                    availableSquares.get(i).setRow(thisSquare.getRow() + 1);
                    availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
            }
        } catch (Exception e) {
            System.out.println("X+1,Y+1 not added");
        }

        // X-1, Y-1 working
        try {
            availableSquares
                    .add(board.getSquare(thisSquare.getX() - leftGridValues, thisSquare.getY() - upGridValues * 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 1);
            availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
        } catch (Exception e) {
            System.out.println("X-1 Y-1 not added");
        }

        // X-1 Y+1 working
        try {
            availableSquares.add(board.getSquare(thisSquare.getX() - leftGridValues, thisSquare.getY() + 76));
            availableSquares.get(i).setRow(thisSquare.getRow() - 1);
            availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
        } catch (Exception e) {
            System.out.println("X-1 Y+1 not added");
        }

        // X+1 Y-1 working
        try {
            availableSquares.add(board.getSquare(thisSquare.getX() + rightGridValues, thisSquare.getY() - 1));
            availableSquares.get(i).setRow(thisSquare.getRow() + 1);
            availableSquares.get(i).setColumn(thisSquare.getColumn() + 1);
        } catch (Exception e) {
            System.out.println("X+1 Y-1 Not added");
        }

        return availableSquares;
    }

}
