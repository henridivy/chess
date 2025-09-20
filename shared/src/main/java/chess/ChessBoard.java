package chess;

import java.util.*;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    // create a double array of chess pieces, with 8 rows and 8 columns
    private final ChessPiece[][] board = new ChessPiece[8][8];

    public ChessBoard() { }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        // assign the given piece to the given position; "this position should hold this piece"
        // remember that the given position is 1-based, so we have to subtract 1 to get the index to access
        board[position.getRow() - 1][position.getColumn() - 1] = piece;

        // my note: remember that board is a double array of ChessPieces
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        // access the piece at the given position and return it
        return board[position.getRow() - 1][position.getColumn() - 1];
    }

    public void removePiece(ChessPosition position) {
        board[position.getRow() - 1][position.getColumn() - 1] = null;
    }

    public void removeAllPieces() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = null;
            }
        }
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {

        removeAllPieces();

        // add non-pawn white pieces (row 1)
        setOtherPieces(1, ChessGame.TeamColor.WHITE);

        // add white pawns
        for (int c = 1; c <= 8; c++) {
            ChessPosition piecePosition = new ChessPosition(2, c);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            addPiece(piecePosition, piece);
        }

        // add black pawns
        for (int c = 1; c <= 8; c++) {
            ChessPosition piecePosition = new ChessPosition(7, c);
            ChessPiece piece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            addPiece(piecePosition, piece);
        }

        // add non-pawn black pieces (row 8)
        setOtherPieces(8, ChessGame.TeamColor.BLACK);

    }

    private void setOtherPieces(int r, ChessGame.TeamColor color) {

        int c = 1;

        List<ChessPiece.PieceType> typesInOrder = List.of(
                ChessPiece.PieceType.ROOK,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.QUEEN,
                ChessPiece.PieceType.KING,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.ROOK
        );

        for (ChessPiece.PieceType pieceType : typesInOrder) {      // for each of the chess piece types in order...
        if (pieceType != ChessPiece.PieceType.PAWN) {                           // if it's not a pawn...
            ChessPosition piecePosition = new ChessPosition(r, c);              // make a chess position with the given row and a column starting from 1
            ChessPiece piece = new ChessPiece(color, pieceType);                // make a chess piece with the given color and the current piece type
            addPiece(piecePosition, piece);                                     // add a piece with those details
            c++;                                                                // go to next column
            }
        }
    }

    public boolean isOccupied(ChessPosition position) {

        if (getPiece(position) == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
