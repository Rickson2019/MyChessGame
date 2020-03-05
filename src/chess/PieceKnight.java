package chess;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PieceKnight extends Piece {
    private Image image;

//    private Tile initSQR=getTile();
    public double xPos;
    public double yPos;
    public ImageView iv;

    public PieceKnight(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if (type.getColour() == Color.WHITE) {
            // image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Knight.png";
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
            img = "file:src/ChessPiece/Black_Knight.png";
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.fitHeightProperty();
            imageView.fitWidthProperty();
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

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
            iv.setY(400);
        } else {
            iv.setX(750);
            iv.setY(400);
        }

    }

    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board) {
        ArrayList<Square> availableSquares = new ArrayList<>();
        int i = 0;

//        if(player.getColour()==Color.BLACK) {
//          
//                //X+1, Y+2
//            try {
//                if(board.getSquare(thisSquare.getX()+76*1, thisSquare.getY()+76*2).returnPiece().player != null &&
//                   board.getSquare(thisSquare.getX()+76*1, thisSquare.getY()+76*2).returnPiece().player.getColour() !=Color.BLACK) {    
//                    availableSquares.add(board.getSquare(thisSquare.getX()+76*1, thisSquare.getY()+76*2));
//                    availableSquares.get(i).setRow(thisSquare.getRow()+1);
//                    availableSquares.get(i).setColumn(thisSquare.getColumn());
//                    i=i++;
//                }
//            } catch (Exception e) {
//                System.out.println("not this Square!");
//            }
//                
//                
//                //X+1, Y-2
//            try {
//                availableSquares.add(board.getSquare(thisSquare.getX()+76*1, thisSquare.getY()-76*1));
//                availableSquares.get(i).setRow(thisSquare.getRow()+1);
//                availableSquares.get(i).setColumn(thisSquare.getColumn());
//                i=i++;
//            } catch (Exception e) {
//                System.out.println("not this square");
//            }
//                
//
//                
//                //X-1, Y+2
//            try {
//                availableSquares.add(board.getSquare(thisSquare.getX()-0.1, thisSquare.getY()+76*2));
//                availableSquares.get(i).setRow(thisSquare.getRow()+2);
//                availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                i=i++;
//            } catch (Exception e) {
//                System.out.println("not this square" );
//            }
//               
//                
//                //X-1, Y-2
//            try {
//                availableSquares.add(board.getSquare(thisSquare.getX()-0.1, thisSquare.getY()-76*1));
//                availableSquares.get(i).setRow(thisSquare.getRow()+2);
//                availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                i=i++;
//            } catch (Exception e) {
//                System.out.println("Not this qaure!!");
//            }
//                
// 
//                
//                //X-2, Y+1
//            try {
//                availableSquares.add(board.getSquare(thisSquare.getX()-76*1, thisSquare.getY()+76*1));
//                availableSquares.get(i).setRow(thisSquare.getRow()-2);
//                availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                i=i++;
//            } catch (Exception e) {
//                System.out.println("Not this sqaure!");
//            }
//                
//      
//                
//                //X-2, Y-1
//            try {
//                availableSquares.add(board.getSquare(thisSquare.getX()-76*1, thisSquare.getY()-1));
//                availableSquares.get(i).setRow(thisSquare.getRow()-2);
//                availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                i=i++;
//            } catch (Exception e) {
//               System.out.println("not this sqaure");
//            }
//                    
//                    
//                //X+2, Y+1
//                try {
//                    availableSquares.add(board.getSquare(thisSquare.getX()+76*2, thisSquare.getY()+76*1));
//                    availableSquares.get(i).setRow(thisSquare.getRow()-2);
//                    availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                    i=i++;
//                } catch (Exception e) {
//                    System.out.println("Not this square plz");
//                }
//      
//                
//                //X-2, Y-1
//                try {
//                    availableSquares.add(board.getSquare(thisSquare.getX()+76*2, thisSquare.getY()-1));
//                    availableSquares.get(i).setRow(thisSquare.getRow()-2);
//                    availableSquares.get(i).setColumn(thisSquare.getColumn()-1);
//                    i=i++;
//                } catch (Exception e) {
//                    System.out.println("not this one plz");
//                }
//
//            }

        // X+1, Y+2
        try {
            if ((board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 76 * 2).returnPiece() != null
                    && board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 76 * 2)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour)
                    || !board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 76 * 2).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() + 76 * 2));
                availableSquares.get(i).setRow(thisSquare.getRow() + 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn() + 2);
                i = i++;
            }
        } catch (Exception e) {
            System.out.println("no");
        }

        // X+1, Y-2
        try {
            if ((board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 76 * 1).returnPiece() != null
                    && board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 76 * 1)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour)
                    || !board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 76 * 1).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 1, thisSquare.getY() - 76 * 1));
                availableSquares.get(i).setRow(thisSquare.getRow() + 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn() - 2);
                i = i++;
            }
        } catch (Exception e) {
            System.out.println("no");
        }

        // X-1, Y+2
        try {
            if ((board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() + 76 * 2).returnPiece() != null
                    && board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() + 76 * 2)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour)
                    || !board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() + 76 * 2).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() + 76 * 2));
                availableSquares.get(i).setRow(thisSquare.getRow() - 1);
                availableSquares.get(i).setColumn(thisSquare.getColumn() + 2);
                i = i++;
            }
        } catch (Exception e) {
            System.out.println("just dont add this square");
        }

        // X-1, Y-2
        try {
            if ((board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() - 76 * 1).returnPiece() != null
                    && board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() - 76 * 1)
                            .returnPiece().player.colour != thisSquare.returnPiece().player.colour)
                    || !board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() - 76 * 1).isOccupied) {
                availableSquares.add(board.getSquare(thisSquare.getX() - 0.1, thisSquare.getY() - 76 * 1));
                availableSquares.get(i).setRow(thisSquare.getRow() + 2);
                availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
                i = i++;
            }
        } catch (Exception e) {
            System.out.println("not added");
        }

        // X-2, Y+1
        try {
            if((board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() + 76 * 1).returnPiece() != null &&
                    board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() + 76 * 1).returnPiece().player.colour != thisSquare.returnPiece().player.colour)||
                    !board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() + 76 * 1).isOccupied)  {
            availableSquares.add(board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() + 76 * 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 2);
            availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
            i = i++;
            }
        } catch (Exception e) {
            System.out.println("not added");
        }

        // X-2, Y-1
        try {
            if((board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() - 1).returnPiece() != null &&
                    board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() - 1).returnPiece().player.colour != thisSquare.returnPiece().player.colour)||
                    !board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() - 1).isOccupied)  {
            availableSquares.add(board.getSquare(thisSquare.getX() - 76 * 1, thisSquare.getY() - 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 2);
            availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
            i = i++;
            }
        } catch (Exception e) {
            System.out.println("not added");
        }

        // X+2, Y+1
        try {
            if((board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() + 76 * 1).returnPiece() != null &&
                    board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() + 76 * 1).returnPiece().player.colour != thisSquare.returnPiece().player.colour)||
                    !board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() + 76 * 1).isOccupied)  {
            availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() + 76 * 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 2);
            availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
            i = i++;
            }
        } catch (Exception e) {
            System.out.println("not added");
        }

        // X+2, Y-1
        try {
            if((board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() - 1).returnPiece() != null &&
                    board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() - 1).returnPiece().player.colour != thisSquare.returnPiece().player.colour)||
                    !board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() - 1).isOccupied)  {
            availableSquares.add(board.getSquare(thisSquare.getX() + 76 * 2, thisSquare.getY() - 1));
            availableSquares.get(i).setRow(thisSquare.getRow() - 2);
            availableSquares.get(i).setColumn(thisSquare.getColumn() - 1);
            i = i++;
            }
        } catch (Exception e) {
            System.out.println("not added");
        }

        return availableSquares;

    }

}
