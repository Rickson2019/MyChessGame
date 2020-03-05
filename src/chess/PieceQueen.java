package chess;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Chess PieceQueen
 * 
 * @author Judao Zhong
 * @version 2.0
 *
 */
public class PieceQueen extends Piece {
    private Image image;

    public double xPos;
    public double yPos;
    private static final double leftGridValues = 1;
    private static final double rightGridValues = 75.02;
    private static final double upGridValues = 1;
    private static final double downGridValues = 75.02;
    public ImageView iv;

    public PieceQueen(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if (type.getColour() == Color.WHITE) {
            // image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Queen.png";
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
            img = "file:src/ChessPiece/Black_Queen.png";
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
            iv.setY(60);
        } else {
            iv.setX(750);
            iv.setY(60);
        }
    }

    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board) {
        ArrayList<Square> availableSquares = new ArrayList<>();
        int i = 0;
        double j = thisSquare.getX();
        double k = thisSquare.getY();

        // SE
        while (j < 526 && k < 526) {

            try {

                j += 76;
                k += 76;
                availableSquares.add(board.getSquare(j, k));
                availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
                availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
                i++;
                if(board.getSquare(j, k).isOccupied) {
                    if (board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        availableSquares.remove(i-1);
                        i--;
                    }
                    break;
                } 
            } catch (Exception e) {
                System.out.println("not added");
            }

        }
        j = thisSquare.getX();
        k = thisSquare.getY() + 76;

        // NE
        while (j < 525 && k > 75) {

            try {
                j += 76;
                k -= 76;
                availableSquares.add(board.getSquare(j, k));
                availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
                availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
                i++;
                if(board.getSquare(j, k).isOccupied) {
                    if (board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        availableSquares.remove(i-1);
                        i--;
                    }
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        j = thisSquare.getX() + 75;
        k = thisSquare.getY() + 75;

        // NW
        while (j > 75 && k > 75) {

            try {

                j -= 76;
                k -= 76;
                availableSquares.add(board.getSquare(j, k));

                availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
                availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
                i++;
                if(board.getSquare(j, k).isOccupied) {
                    if (board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        availableSquares.remove(i-1);
                        i--;
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("not added");
            }

        }
        j = thisSquare.getX() + 76;
        k = thisSquare.getY() ;

        // SW
        while (j > 75 && k < 575) {

            try { 

                j -= 75.01;
                k += 75.01;

                
                availableSquares.add(board.getSquare(j, k));
                availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
                availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
                i++;
                
      
                
                if (board.getSquare(j - 1 , k +1).isOccupied) {
                    System.out.println(thisSquare);
                    
                    if (board.getSquare(j - 1 , k + 1).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        System.out.println("sameClr"+thisSquare.returnPiece().player.colour);
                        availableSquares.remove(i-1);
                        i--;
                    }    
                    break;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("not added");
            }
        }
        
            //down
            j = thisSquare.getY();
            while (j < 525) {
                j += 75.101;
               
                availableSquares.add(board.getSquare(thisSquare.getX() + 1, j));
                availableSquares.get(i).setRow(board.getSquare(thisSquare.getX() + 1, j).getRow());
                availableSquares.get(i).setColumn(board.getSquare(thisSquare.getY() + 1, j).getColumn());
                i++;
                if(board.getSquare(thisSquare.getX() + 1, j).isOccupied) {
                    if (board.getSquare(thisSquare.getX() + 1, j).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        availableSquares.remove(i-1);
                        i--;
                    }
                    break;
                }
            }
      
        
        //right
        k = thisSquare.getX();
        while (k < 525) {
            k += 75.100;


            availableSquares.add(board.getSquare(k, thisSquare.getY() + 1));
            availableSquares.get(i).setRow(board.getSquare(k, thisSquare.getY() +1 ).getRow());
            availableSquares.get(i).setColumn(board.getSquare(k, thisSquare.getY() +1 ).getColumn());
            i++;
            
            if (board.getSquare(k, thisSquare.getY() +1 ).isOccupied) {
                if (board.getSquare(k, thisSquare.getY() +1 ).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                    availableSquares.remove(i-1);
                    i--;
                }
                break;
            }
        }
        //up
        double l = thisSquare.getY()+75;
        while (l > 0) {
            l -= 76.00;
            availableSquares.add(board.getSquare(thisSquare.getX() + 0.1, l));
            availableSquares.get(i).setRow(board.getSquare(thisSquare.getX() + 0.1, l).getRow());
            availableSquares.get(i).setColumn(board.getSquare(thisSquare.getX() +0.1, l).getColumn());
            i++;
            if (board.getSquare(thisSquare.getX() + 0.1, l).isOccupied) {
                if (board.getSquare(thisSquare.getX() + 0.1, l).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                    availableSquares.remove(i-1);
                    i--;
                }
                break;
            }

        }
        //left
        try {
            double m = thisSquare.getX() +75;
            while (m > 0) {
                m -= 75.2000;
                availableSquares.add(board.getSquare(m, thisSquare.getY()+1) );
                availableSquares.get(i).setRow(board.getSquare(m, thisSquare.getY() +1 ).getRow());
                availableSquares.get(i).setColumn(board.getSquare(m, thisSquare.getY() +1  ).getColumn());
                i++;
                if (board.getSquare(m, thisSquare.getY()+1).isOccupied) {
                    if (board.getSquare(m, thisSquare.getY()+1).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
                        availableSquares.remove(i-1);
                        i--;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("some not added");
        }
        

        return availableSquares;

    }
}
