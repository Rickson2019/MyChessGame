package chess;

import java.awt.Button;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 * Chess Game class is the main scene of the game.
 * 
 * @author Judao Zhong
 * @version 2.0
 *
 */
public class Game extends Application {

    /** currently chosen tile. */
    Square currentSquare;

    /** The board. */
    private Board board;

    /** Group of all images. */
    private Pane root;

    /** The selected piece. */
    public Piece selectedPiece = null;

    /** The white player. */
    private final Player whitePlayer;

    /** The black player. */
    private final Player blackPlayer;

    /** The current player. */
    private Player currentPlayer;

    public static Label bishopLabel_white;

    /** The Wbishop. */
    public Piece bishop_white;

    /** The Wbishop 2. */
    public Piece bishop_white2;

    public Label rookLabel_white;

    /** The Wrook. */
    public Piece rook_white;

    /** The Wrook 2. */
    public Piece rook_white2;

    /** The Wpawn. */
    public Piece pawn_white;

    /** The Wpawn 2. */
    public Piece pawn_white2;

    /** The Wpawn 3. */
    public Piece pawn_white3;

    /** The Wpawn 4. */
    public Piece pawn_white4;

    /** The Wpawn 5. */
    public Piece pawn_white5;

    /** The Wpawn 6. */
    public Piece pawn_white6;

    /** The Wpawn 7. */
    public Piece pawn_white7;

    /** The Wpawn 8. */
    public Piece pawn_white8;

    /** The Wking. */
    public Piece Wking;

    public Label queenwhiteLabel_white;
    /** The Wqueen. */
    public Piece queen_white;

    public Label knightLabel_white;
    /** The Wknight. */
    public Piece knight_white;

    /** The Wknight 2. */
    public Piece knight_white2;

    /** The Bbishop. */
    public Piece bishop_black;

    /** The Bbishop 2. */
    public Piece bishop_black2;

    /** The Brook. */
    public Piece rook_black;

    /** The Brook 2. */
    public Piece rook_black2;

    /** The Bpawn. */
    public Piece pawn_black;

    /** The Bpawn 2. */
    public Piece Bpawn2;

    /** The Bpawn 3. */
    public Piece Bpawn3;

    /** The Bpawn 4. */
    public Piece Bpawn4;

    /** The Bpawn 5. */
    public Piece Bpawn5;

    /** The Bpawn 6. */
    public Piece Bpawn6;

    /** The Bpawn 7. */
    public Piece Bpawn7;

    /** The Bpawn 8. */
    public Piece Bpawn8;

    /** The Bking. */
    public Piece Bking;

    /** The Bqueen. */
    public Piece queen_black;

    /** The Bknight. */
    public Piece Bknight;

    /** The Bknight 2. */
    public Piece Bknight2;

    /** The game. */
    public Game game;

    /** The status. */
    public Label status;

    /**
     * Instantiates a new game.
     */
    public Game() {
        this.whitePlayer = new Player(Color.WHITE);
        this.blackPlayer = new Player(Color.BLACK);
        board = new Board();
        status = new Label();

        bishopLabel_white = new Label(" ");

        status.setText("White Player's Turn");

        status.setTextFill(Color.BLACK);
        status.setTranslateX(680);
        status.setTranslateY(20);
        status.setScaleX(2);
        status.setScaleY(2);
    }

    /**
     * Initialize the board and pieces.
     *
     * @param primaryStage the primary stage
     */
    public void start(Stage primaryStage) {
        // create the board with 75 for each tile

        root = new Pane(board, status);
        instantiate();

        // app size
        final int appWidth = 850;
        final int appHeight = 600;
        Scene scene = new Scene(root, appWidth, appHeight, Color.WHITE);
        // Scene scene = new Scene(board);
        root.getChildren().addAll(bishop_white, bishop_white2, bishop_black, bishop_black2,

                rook_white, rook_white2, rook_black, rook_black2, pawn_white, pawn_white2, pawn_white3, pawn_white4,
                pawn_white5, pawn_white6, pawn_white7, pawn_white8, pawn_black, Bpawn2, Bpawn3, Bpawn4, Bpawn5, Bpawn6,
                Bpawn7, Bpawn8, Wking, Bking, queen_white, queen_black, knight_white, knight_white2, Bknight, Bknight2,
                bishopLabel_white);
        /* disable the resizing function of window */
        // primaryStage.setResizable(false);
        primaryStage.setTitle("Blitzkrieg");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            StackPane root2 = new StackPane();
//            Button buttonOK = new Button("OK");
            Label instructionLabel = new Label("Drag and release to move the pieces");
            root2.getChildren().add(instructionLabel);

//            root2.getChildren().addAll(buttonOK);
            Stage stage = new Stage();
            stage.setTitle("Notice");
            stage.setScene(new Scene(root2, 220, 120));
            stage.show();
            // Hide this current window (if this is what you want)

        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Display the position respect to the mouse click */

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                currentSquare = board.getSquare(event.getX(), event.getY());
                currentSquare.setFill(Color.GREEN);
                selectedPiece = currentSquare.returnPiece();

                if (currentPlayer == blackPlayer && currentSquare.isOccupied)
                    activateBlack();
                else if (currentPlayer == whitePlayer && currentSquare.isOccupied)
                    activateWhite();

                try {
                    ArrayList<Square> availableSquares = selectedPiece.movePattern(currentPlayer, currentSquare, board);
                    if (availableSquares.size() != 0)
                        for (int i = 0; i < availableSquares.size(); i++) {

//                                System.out.println("get available X" + availableSquares.get(i).getX());
//                                System.out.println("get available Y" + availableSquares.get(i).getY());
                            availableSquares.get(i).setFill(Color.YELLOWGREEN);
                            availableSquares.get(i).setStroke(Color.BLUE);
                        }

                    try {
                        if (currentPlayer.getColour() == Color.BLACK)
                            board.selectBlackPiece(selectedPiece);
                        else if (currentPlayer.getColour() == Color.WHITE)
                            board.selectWhitePiece(selectedPiece);
                    } catch (Exception e) {
                        availableSquares = null;
                        selectedPiece = currentSquare.returnPiece();
                        System.out.println("cannot choose");
                    }
                } catch (Exception e) {
                    System.out.println("difficluue");
                }

            }

        });
        scene.setOnMouseReleased(
                /**
                 * Mouse Event.
                 */
                new EventHandler<MouseEvent>() {

                    /**
                     * Handle.
                     *
                     * @param event2 the event
                     */
                    public void handle(MouseEvent event2) {
                        selectedPiece = currentSquare.returnPiece();
//                        try {
//                            if(currentPlayer == blackPlayer) 
//                                activateBlack();
//                            else if(currentPlayer == whitePlayer)
//                                activateWhite();
//                            else {
//                                System.out.println("not clicking any piece");
//                            }
//                        } catch (Exception e1) {
//                            System.out.println("not clicking any piece");
//                        }

                        boolean canMove = false;

                        try {
                         // setFill changes the color back to the orginal colour of the tiles
                            
                          currentSquare.setFill(currentSquare.getColor());
                            ArrayList<Square> availableSquares = selectedPiece.movePattern(currentPlayer, currentSquare,
                                    board);
                           for (int i = 0; i < availableSquares.size(); i++) {
                                availableSquares.get(i).setStroke(null);
                               availableSquares.get(i).setFill(availableSquares.get(i).getColor());
                           } 

                            if (currentPlayer == blackPlayer
                                    && board.getSquare(event2.getX(), event2.getY()) != currentSquare) {
//                                ArrayList<Square> availableSquares = selectedPiece.movePattern(currentPlayer,currentSquare, board);
                                for (int i = 0; i < availableSquares.size(); i++) {
                                    if (availableSquares.get(i) == board.getSquare(event2.getX(), event2.getY()))
                                        canMove = true;
//                                        System.out.println(canMove);

                                }
                                if (canMove) {
                                    board.moveBlackPiece(event2.getX(), event2.getY());
                                    currentSquare.setPiece(null);
                                    currentSquare.isOccupied = false;
                                }

                            } else if (currentPlayer == whitePlayer
                                    && board.getSquare(event2.getX(), event2.getY()) != currentSquare) {
                                for (int i = 0; i < availableSquares.size(); i++) {
                                    if (availableSquares.get(i) == board.getSquare(event2.getX(), event2.getY()))
                                        canMove = true;
//                                    System.out.println(canMove);

                                }
                                if (canMove) {
                                    board.moveWhitePiece(event2.getX(), event2.getY());
                                    currentSquare.setPiece(null);
                                    currentSquare.isOccupied = false;
                                }
                            }
                        } catch (Exception e) {
                            currentSquare.setPiece(selectedPiece);
                            System.out.println("Choose the other color to play!");
                        }

                        if (currentPlayer == blackPlayer && board.blackMoveSuccess == true) {
                            switchPlayers();

                            board.blackMoveSuccess = false;
                        } else if (currentPlayer == whitePlayer && board.whiteMoveSuccess == true) {
                            switchPlayers();

                            board.whiteMoveSuccess = false;
                        }

                    }

                });

    }

    /**
     * Instantiate.
     */
    public void instantiate() {
        currentPlayer = whitePlayer;
        bishop_white = new PieceBishop(whitePlayer, 150.1, 525.1);
        bishop_white.setSquare(board.getSquare(150.1, 525.1));

        board.getSquare(150.1, 525.1).setPiece(bishop_white);

        bishop_white2 = new PieceBishop(whitePlayer, 375.1, 525.1);
        bishop_white2.setSquare(board.getSquare(375.1, 525.1));
        board.getSquare(375.1, 525.1).setPiece(bishop_white2);

        bishop_black = new PieceBishop(blackPlayer, 150.1, 0.1);
        bishop_black.setSquare(board.getSquare(150.1, 0.1));
        board.getSquare(150.1, 0.1).setPiece(bishop_black);

        bishop_black2 = new PieceBishop(blackPlayer, 375.1, 0.1);
        bishop_black2.setSquare(board.getSquare(375.1, 0.1));
        board.getSquare(375.1, 0.1).setPiece(bishop_black2);

        rook_white = new PieceRook(blackPlayer, 0.1, 0.1);
        rook_white.setSquare(board.getSquare(0.1, 0.1));
        board.getSquare(0.1, 0.1).setPiece(rook_white);

        rook_white2 = new PieceRook(blackPlayer, 525.1, 0.1);
        rook_white2.setSquare(board.getSquare(525.1, 0.1));
        board.getSquare(525.1, 0.1).setPiece(rook_white2);

        rook_black = new PieceRook(whitePlayer, 0.1, 525.1);
        rook_black.setSquare(board.getSquare(0.1, 525.1));
        board.getSquare(0.1, 525.1).setPiece(rook_black);

        rook_black2 = new PieceRook(whitePlayer, 525.1, 525.1);
        rook_black2.setSquare(board.getSquare(525.1, 525.1));
        board.getSquare(525.1, 525.1).setPiece(rook_black2);

        pawn_white = new PiecePawn(blackPlayer, 0.1, 75.1);
        pawn_white.setSquare(board.getSquare(0.1, 75.1));
        board.getSquare(0.1, 75.1).setPiece(pawn_white);

        pawn_white2 = new PiecePawn(blackPlayer, 75.1, 75.1);
        pawn_white2.setSquare(board.getSquare(75.1, 75.1));
        board.getSquare(75.1, 75.1).setPiece(pawn_white2);

        pawn_white3 = new PiecePawn(blackPlayer, 150.1, 78);
        pawn_white3.setSquare(board.getSquare(150.1, 75.1));
        board.getSquare(150.1, 75.1).setPiece(pawn_white3);

        pawn_white4 = new PiecePawn(blackPlayer, 225.1, 75.1);
        pawn_white4.setSquare(board.getSquare(225.1, 75.1));
        board.getSquare(225.1, 75.1).setPiece(pawn_white4);

        pawn_white5 = new PiecePawn(blackPlayer, 300.1, 75.1);
        pawn_white5.setSquare(board.getSquare(300.1, 75.1));
        board.getSquare(300.1, 75.1).setPiece(pawn_white5);

        pawn_white6 = new PiecePawn(blackPlayer, 375.1, 75.1);
        pawn_white6.setSquare(board.getSquare(375.1, 75.1));
        board.getSquare(375.1, 75.1).setPiece(pawn_white6);

        pawn_white7 = new PiecePawn(blackPlayer, 450.1, 75.1);
        pawn_white7.setSquare(board.getSquare(450.1, 75.1));
        board.getSquare(450.1, 75.1).setPiece(pawn_white7);

        pawn_white8 = new PiecePawn(blackPlayer, 525.1, 75.1);
        pawn_white8.setSquare(board.getSquare(525.1, 75.1));
        board.getSquare(525.1, 75.1).setPiece(pawn_white8);

        pawn_black = new PiecePawn(whitePlayer, 0.1, 450.1);
        pawn_black.setSquare(board.getSquare(0.1, 450.1));
        board.getSquare(0.1, 450.1).setPiece(pawn_black);

        Bpawn2 = new PiecePawn(whitePlayer, 75.1, 450.1);
        Bpawn2.setSquare(board.getSquare(75.1, 450.1));
        board.getSquare(75.1, 450.1).setPiece(Bpawn2);

        Bpawn3 = new PiecePawn(whitePlayer, 151.1, 455.1);
        Bpawn3.setSquare(board.getSquare(152.1, 453.1));
        board.getSquare(150.1, 450.1).setPiece(Bpawn3);

        Bpawn4 = new PiecePawn(whitePlayer, 225.1, 450.1);
        Bpawn4.setSquare(board.getSquare(225.1, 450.1));
        board.getSquare(225.1, 450.1).setPiece(Bpawn4);

        Bpawn5 = new PiecePawn(whitePlayer, 300.1, 450.1);
        Bpawn5.setSquare(board.getSquare(300.1, 450.1));
        board.getSquare(300.1, 450.1).setPiece(Bpawn5);

        Bpawn6 = new PiecePawn(whitePlayer, 375.1, 450.1);
        Bpawn6.setSquare(board.getSquare(375.1, 450.1));
        board.getSquare(375.1, 450.1).setPiece(Bpawn6);

        Bpawn7 = new PiecePawn(whitePlayer, 450.1, 450.1);
        Bpawn7.setSquare(board.getSquare(450.1, 450.1));
        board.getSquare(450.1, 450.1).setPiece(Bpawn7);

        Bpawn8 = new PiecePawn(whitePlayer, 525.1, 450.1);
        Bpawn8.setSquare(board.getSquare(525.1, 450.1));
        board.getSquare(525.1, 450.1).setPiece(Bpawn8);

        Wking = new PieceKing(blackPlayer, 300.1, 0.1);
        Wking.setSquare(board.getSquare(300.1, 0.1));
        board.getSquare(300.1, 0.1).setPiece(Wking);

        Bking = new PieceKing(whitePlayer, 300.1, 525.1);
        Bking.setSquare(board.getSquare(300.1, 525.1));
        board.getSquare(300.1, 525.1).setPiece(Bking);

        queen_white = new PieceQueen(blackPlayer, 225.1, 0.1);
        queen_white.setSquare(board.getSquare(225.1, 0.1));
        board.getSquare(225.1, 0.1).setPiece(queen_white);

        queen_black = new PieceQueen(whitePlayer, 225.1, 525.1);
        queen_black.setSquare(board.getSquare(225.1, 525.1));
        board.getSquare(225.1, 525.1).setPiece(queen_black);

        knight_white = new PieceKnight(blackPlayer, 75.1, 0.1);
        knight_white.setSquare(board.getSquare(75.1, 0.1));
        board.getSquare(75.1, 0.1).setPiece(knight_white);

        knight_white2 = new PieceKnight(blackPlayer, 450.1, 0.1);
        knight_white2.setSquare(board.getSquare(450.1, 0.1));
        board.getSquare(450.1, 0.1).setPiece(knight_white2);

        Bknight = new PieceKnight(whitePlayer, 75.1, 525.1);
        Bknight.setSquare(board.getSquare(75.1, 525.1));
        board.getSquare(75.1, 525.1).setPiece(Bknight);

        Bknight2 = new PieceKnight(whitePlayer, 450.1, 525.1);
        Bknight2.setSquare(board.getSquare(450.1, 525.1));
        board.getSquare(450.1, 525.1).setPiece(Bknight2);

        board.initPieces();
//        activateWhite();
    }

    /**
     * Switch players.
     */
    public void switchPlayers() {
        if (board.counterBlack == 1 && board.counterWhite > 1) {

            status.setText("Black player lost!");

        } else if (board.counterWhite == 1 && board.counterBlack > 1) {

            status.setText("White player lost!");
        }

        else if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
            status.setText("White Player's Turn");
            status.setTextFill(Color.GRAY);

        } else if (this.currentPlayer == this.whitePlayer) {
            this.currentPlayer = this.blackPlayer;
            status.setText("Black Player's Turn");
            status.setTextFill(Color.BLACK);
        }
        for (int x = 0; x < board.getNumCols(); x++) {
            for (int y = 0; y < board.getNumCols(); y++) {
                board.getArray()[x][y].setActive(false);

            }
        }
    }

    /**
     * Gets the current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {

        return currentPlayer;
    }

    /**
     * Allows White Player to move pieces
     */
    private void activateWhite() {

        try {
            bishop_white.getSquare().setActive(true);
            bishop_white2.getSquare().setActive(true);
            rook_white.getSquare().setActive(true);
            rook_white2.getSquare().setActive(true);
            pawn_white.getSquare().setActive(true);
            pawn_white2.getSquare().setActive(true);
            pawn_white3.getSquare().setActive(true);
            pawn_white4.getSquare().setActive(true);
            pawn_white5.getSquare().setActive(true);
            pawn_white6.getSquare().setActive(true);
            pawn_white7.getSquare().setActive(true);
            pawn_white8.getSquare().setActive(true);
            Wking.getSquare().setActive(true);
            queen_white.getSquare().setActive(true);
            knight_white.getSquare().setActive(true);
            knight_white2.getSquare().setActive(true);

            bishop_black.getSquare().setActive(false);
            bishop_black2.getSquare().setActive(false);
            rook_black.getSquare().setActive(false);
            rook_black2.getSquare().setActive(false);
            pawn_black.getSquare().setActive(false);
            Bpawn2.getSquare().setActive(false);
            Bpawn3.getSquare().setActive(false);
            Bpawn4.getSquare().setActive(false);
            Bpawn5.getSquare().setActive(false);
            Bpawn6.getSquare().setActive(false);
            Bpawn7.getSquare().setActive(false);
            Bpawn8.getSquare().setActive(false);
            Bking.getSquare().setActive(false);
            queen_black.getSquare().setActive(false);
            Bknight.getSquare().setActive(false);
            Bknight2.getSquare().setActive(false);

        } catch (Exception e) {
            System.out.println("cannot set White to and back to inactived");

//           bishop_white.getSquare().setActive(true);
//           bishop_white2.getSquare().setActive(true);
//           rook_white.getSquare().setActive(true);
//           rook_white2.getSquare().setActive(true);
//           pawn_white.getSquare().setActive(true);
//           pawn_white2.getSquare().setActive(true);
//           pawn_white3.getSquare().setActive(true);
//           pawn_white4.getSquare().setActive(true);
//           pawn_white5.getSquare().setActive(true);
//           pawn_white6.getSquare().setActive(true);
//           pawn_white7.getSquare().setActive(true);
//           pawn_white8.getSquare().setActive(true);
//           Wking.getSquare().setActive(true);
//           queen_white.getSquare().setActive(true);
//           knight_white.getSquare().setActive(true);
//           knight_white2.getSquare().setActive(true);
//           
//           bishop_white.getSquare().setActive(false);
//           bishop_white2.getSquare().setActive(false);
//           rook_white.getSquare().setActive(false);
//           rook_white2.getSquare().setActive(false);
//           pawn_white.getSquare().setActive(false);
//           pawn_white2.getSquare().setActive(false);
//           pawn_white3.getSquare().setActive(false);
//           pawn_white4.getSquare().setActive(false);
//           pawn_white5.getSquare().setActive(false);
//           pawn_white6.getSquare().setActive(false);
//           pawn_white7.getSquare().setActive(false);
//           pawn_white8.getSquare().setActive(false);
//           Wking.getSquare().setActive(false);
//           queen_white.getSquare().setActive(false);
//           knight_white.getSquare().setActive(false);
//           knight_white2.getSquare().setActive(false);
        }

    }

    /**
     * Allows Black Player to move pieces
     */
    public void activateBlack() {

        try {

            bishop_black.getSquare().setActive(true);
            bishop_black2.getSquare().setActive(true);
            rook_black.getSquare().setActive(true);
            rook_black2.getSquare().setActive(true);
            pawn_black.getSquare().setActive(true);
            Bpawn2.getSquare().setActive(true);
            Bpawn3.getSquare().setActive(true);
            Bpawn4.getSquare().setActive(true);
            Bpawn5.getSquare().setActive(true);
            Bpawn6.getSquare().setActive(true);
            Bpawn7.getSquare().setActive(true);
            Bpawn8.getSquare().setActive(true);
            Bking.getSquare().setActive(true);
            queen_black.getSquare().setActive(true);
            Bknight.getSquare().setActive(true);
            Bknight2.getSquare().setActive(true);

            bishop_white.getSquare().setActive(false);
            bishop_white2.getSquare().setActive(false);
            rook_white.getSquare().setActive(false);
            rook_white2.getSquare().setActive(false);
            pawn_white.getSquare().setActive(false);
            pawn_white2.getSquare().setActive(false);
            pawn_white3.getSquare().setActive(false);
            pawn_white4.getSquare().setActive(false);
            pawn_white5.getSquare().setActive(false);
            pawn_white6.getSquare().setActive(false);
            pawn_white7.getSquare().setActive(false);
            pawn_white8.getSquare().setActive(false);
            Wking.getSquare().setActive(false);
            queen_white.getSquare().setActive(false);
            knight_white.getSquare().setActive(false);
            knight_white2.getSquare().setActive(false);

        } catch (Exception e) {

//            bishop_black.getSquare().setActive(true); 
//            bishop_black2.getSquare().setActive(true);
//            rook_black.getSquare().setActive(true);
//            rook_black2.getSquare().setActive(true);
//            pawn_black.getSquare().setActive(true);
//            Bpawn2.getSquare().setActive(true);
//            Bpawn3.getSquare().setActive(true);
//            Bpawn4.getSquare().setActive(true);
//            Bpawn5.getSquare().setActive(true);
//            Bpawn6.getSquare().setActive(true);
//            Bpawn7.getSquare().setActive(true);
//            Bpawn8.getSquare().setActive(true);
//            Bking.getSquare().setActive(true);
//            queen_black.getSquare().setActive(true);
//            Bknight.getSquare().setActive(true);
//            Bknight2.getSquare().setActive(true);
            System.out.println("Cannot Set Black to Active, set back to inactivated");
//            bishop_black.getSquare().setActive(false);
//            bishop_black2.getSquare().setActive(false);
//            rook_black.getSquare().setActive(false);
//            rook_black2.getSquare().setActive(false);
//            pawn_black.getSquare().setActive(false);
//            Bpawn2.getSquare().setActive(false);
//            Bpawn3.getSquare().setActive(false);
//            Bpawn4.getSquare().setActive(false);
//            Bpawn5.getSquare().setActive(false);
//            Bpawn6.getSquare().setActive(false);
//            Bpawn7.getSquare().setActive(false);
//            Bpawn8.getSquare().setActive(false);
//            Bking.getSquare().setActive(false);
//            queen_black.getSquare().setActive(false);
//            Bknight.getSquare().setActive(false);
//            Bknight2.getSquare().setActive(false);

        }

    }

}