package chess;

import java.util.*;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        // get the piece that's at the given position on the given board
        ChessPiece piece = board.getPiece(myPosition);

        // if the piece is a Bishop...
        if (piece.getPieceType() == PieceType.BISHOP) {
            return moveBishop(piece, myPosition);
        }
        // return an empty list
        return List.of();
    }

    public Collection<ChessMove> moveBishop(ChessPiece piece, ChessPosition startingPosition) {
//        TreeSet<ChessMove> validMoves = new TreeSet<>();
        List<ChessMove> validMoves = new ArrayList<>();
        ChessPosition endingPosition = startingPosition;

        // for up right
        int j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i < 8 && j < 8; i++) {
            endingPosition = new ChessPosition(i+1, j+1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j++;
        }

        // for up left
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i < 8 && j > 1; i++) {
            endingPosition = new ChessPosition(i+1, j-1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j--;
        }

        // for down right
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i > 1 && j < 8; i--) {
            endingPosition = new ChessPosition(i-1, j+1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j++;
        }

        // for down left
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i > 1 && j > 1; i--) {
            endingPosition = new ChessPosition(i-1, j-1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j--;
        }

            /* 5,4 (i, j)
            up right - 6,5  7,6  8,7
            up left - 6,3  7,2  8,1
            down right - 4,5  3,6  2,7  1,8
            down left - 4,3  3,2  2,1
             */

        return validMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
