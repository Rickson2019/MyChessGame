package chess;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PieceBishop extends Piece{
    private Image image;
   
//    private Tile initSQR=getTile();
    public double xPos;
    public double yPos;
    
    private static final double  leftGridValues = 1;
    private static final double  rightGridValues = 75.02;
    private static final double  upGridValues = 1;
    private static final double  downGridValues = 75.02;
    
    public ImageView iv;
    int count = 0;
    public PieceBishop(Player type, double x, double y) {
        super(type, x, y);
        String img;
        if(type.getColour()==Color.WHITE){
            //image = new Image("file:src/ChessPiece/White_Bishop.png");
            img = "file:src/ChessPiece/White_Bishop.png";
            //ImageView imageView = new ImageView();
            //imageView.setImage(image);
            //setSquare(initSQR);
//            imageView.fitHeightProperty();
//            imageView.fitWidthProperty();
//            imageView.setPreserveRatio(true);
//            imageView.setSmooth(true);
//            imageView.setCache(true);
            
            
            
            
            
            
            xPos = x;
            yPos = y;
        }
        else{
            img = "file:src/ChessPiece/Black_Bishop.png";
            //ImageView imageView = new ImageView();
            //imageView.setImage(image);
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
        iv.setX(xPos);
        iv.setY(yPos);
        
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
       
        if(getOwner().getColour()==Color.WHITE) {
            iv.setX(650);
            iv.setY(120);
        }else {
            iv.setX(750);
            iv.setY(120);
        }

       
       
//        count++;
//        Game.bishopLabel_white.setText(""+count);
        Game.bishopLabel_white.setTranslateX(730);
        Game.bishopLabel_white.setTranslateY(70);
        Game.bishopLabel_white.setScaleX(2);
        Game.bishopLabel_white.setScaleY(2);
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
        while (j > 75 && k < 576 ) {

            try { 

                j -= 76;
                k += 76;

                
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
        

 

        return availableSquares;

    }
//    public ArrayList<Square> movePattern(Player player, Square thisSquare, Board board){
//        ArrayList<Square> availableSquares = new ArrayList<>();
//        int i = 0;
//        double j = thisSquare.getX();
//        double k = thisSquare.getY();
//        
//        // SE
//        while (j < 525 && k < 525) {
//          
//                try {
//
//                    
//                    j += 76;
//                    k += 76;
//
//                    availableSquares.add(board.getSquare(j, k));
//                    availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
//                    availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
//                    i++;
//                    
//
//                } catch (Exception e) {
//                   System.out.println("not added");
//                }
//                if(board.getSquare(j + rightGridValues * 1  , k + downGridValues + 5).isOccupied ||
//                        board.getSquare(j + rightGridValues * 1  , k + downGridValues + 5).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
//                           break;
//                   }
//        }
//        
//        
//        j=thisSquare.getX();
//        k=thisSquare.getY() + 76;
//        
//        //NE
//        while ( j < 525 && k>75 ) {
//                
//                try {
//
//                    
//                    j +=76;
//                    k -= 76;
////                  if(board.getSquare(j,k).isOccupied)
////                  break;
////                    if(board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
////                        break;
////                    }
//                    availableSquares.add(board.getSquare(j, k));
//                    availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
//                    availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
//                    i++;
//                    if (board.getSquare(j, k).isOccupied) {
//                        if (board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
//                            availableSquares.remove(i-1);
//                            i--;
//                        }
//                        break;
//                    }
//
//                } catch (Exception e) {
//                    System.out.println("not added");
//                }
//
//            
//        }
//        
//        j=thisSquare.getX()+75;
//        k=thisSquare.getY()+75;
//        // NW
//        while (j > 75 && k > 75 ) {
//
//                try {
//                    
//                    j -= 76;
//                    k -= 76;
////                    if(board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
////                        break;
////                    }
//
//                    availableSquares.add(board.getSquare(j, k));
//                    availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
//                    availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
//                    i++;
//
//                } catch (Exception e) {
//                   System.out.println("not added");
//                }
//                if(board.getSquare(j, k).isOccupied) {
//                    if (board.getSquare(j, k).returnPiece().player.colour == thisSquare.returnPiece().player.colour) {
//                        availableSquares.remove(i-1);
//                        i--;
//                    }
//                    break;
//                }
//           
//        }
//        
//        
//        j=thisSquare.getX() + 75*2;
//        k=thisSquare.getY() - 75;
//        
//        //SW
//        while ( j > 73 && k < 525) {
//            
//                try {
//                    j -= 75.1;
//                    k += 75.1;
//                    availableSquares.add(board.getSquare(j, k));
//                    availableSquares.get(i).setRow(board.getSquare(j, k).getRow());
//                    availableSquares.get(i).setColumn(board.getSquare(j, k).getColumn());
//                    i++;
////                    if(board.getSquare(j, k).returnPiece().player.colour != thisSquare.returnPiece().player.colour) 
////                        break;
////                    if(board.getSquare(j,k).isOccupied)
////                        break;
//
//                    
//                } catch (Exception e) {
//                    System.out.println("not added");
//                }
////                finally {
////                    if(board.getSquare(j,k).isOccupied)
////                        break;
////                }
////                if(board.getSquare(j,k).isOccupied)
////                    break;
////              
//            
//        }
//  
//    
//        return availableSquares;
//    
//  
//    }
}
