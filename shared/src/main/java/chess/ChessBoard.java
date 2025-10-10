package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    private final ChessPiece[][] board = new ChessPiece[8][8];

    public ChessBoard() {

    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return board[position.getRow() - 1][position.getColumn() - 1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {

        removeAllPieces();
        int r;

        // set black pawns
        r = 7;
        for (int c = 1; c < 9; c++ ) {
            ChessPosition newPosition = new ChessPosition(r, c);
            ChessPiece newPiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            addPiece(newPosition, newPiece);
        }

        // set black pawns
        r = 2;
        for (int c = 1; c < 9; c++ ) {
            ChessPosition newPosition = new ChessPosition(r, c);
            ChessPiece newPiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            addPiece(newPosition, newPiece);
        }

        // set other pieces
        setOtherPieces();
    }

    // my methods

    public void setOtherPieces() {
        ChessPiece.PieceType[] nonPawnTypes = {
                ChessPiece.PieceType.ROOK,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.QUEEN,
                ChessPiece.PieceType.KING,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.ROOK
        };

        int r;

        // set black pieces
        r = 8;
        for (int c = 1; c < 9; c++ ) {
            ChessPosition newPosition = new ChessPosition(r, c);
            ChessPiece newPiece = new ChessPiece(ChessGame.TeamColor.BLACK, nonPawnTypes[c-1]);
            addPiece(newPosition, newPiece);
        }

        // set white pieces
        r = 1;
        for (int c = 1; c < 9; c++ ) {
            ChessPosition newPosition = new ChessPosition(r, c);
            ChessPiece newPiece = new ChessPiece(ChessGame.TeamColor.WHITE, nonPawnTypes[c-1]);
            addPiece(newPosition, newPiece);
        }
    }

    public void removeAllPieces() {
        for (int r = 1; r < 9; r++) {
            for (int c = 1; c < 9; c++) {
                removePiece(new ChessPosition(r, c));
            }
        }
    }

    public void removePiece(ChessPosition position) {
        board[position.getRow() - 1][position.getColumn() - 1] = null;
    }

    public boolean inBounds(ChessPosition position) {
        int r = position.getRow();
        int c = position.getColumn();

        return (0 < r && r < 9) && (0 < c && c < 9);
    }

    public boolean isEmpty(ChessPosition position) {
        return getPiece(position) == null;
    }

    public boolean isValidSpot(ChessPiece piece, ChessPosition endPosition) {
        if (inBounds(endPosition)) {
            if (isEmpty(endPosition)) {
                return true; // true if it's an empty spot
            } else {
                ChessPiece nextPiece = getPiece(endPosition);
                if (nextPiece.getTeamColor() != piece.getTeamColor()) {
                    return true; // true if there's an enemy there
                }
            }
        }
        return false; // return false if not in bounds or doesn't fit other conditions
    }

//    public boolean isValidSpot(ChessPosition position) {
//        if (!inBounds(position)) {
//            return false;
//        } else if (!isEmpty(position)) {
//            ChessPiece myPiece = getPiece(position);
//            ChessPiece nextPiece = getPiece(position);
//            if (nextPiece.getTeamColor() != myPiece.getTeamColor()) {
//                return true; // true if there's an enemy there
//            }
//        }
//        return true; // return false if not in bounds or doesn't fit other conditions
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ChessBoard that)) {
            return false;
        }
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
