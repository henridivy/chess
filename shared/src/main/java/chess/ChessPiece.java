package chess;

import java.util.*;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor color;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.color = pieceColor;
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
        return color;
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
        ChessPiece myPiece = board.getPiece(myPosition);

        PieceType myType = myPiece.getPieceType();
        ChessGame.TeamColor myColor = myPiece.getTeamColor();

        PieceRule myRules;

        if (myType == PieceType.BISHOP) { myRules = new BishopRule(board, myColor, myPosition); }
        else if (myType == PieceType.ROOK) { myRules = new RookRule(board, myColor, myPosition); }
        else if (myType == PieceType.QUEEN) { myRules = new QueenRule(board, myColor, myPosition); }
        else if (myType == PieceType.KNIGHT) { myRules = new KnightRule(board, myColor, myPosition); }
        else if (myType == PieceType.KING) { myRules = new KingRule(board, myColor, myPosition); }
        else { myRules = new PawnRule(board, myColor, myPosition); }

        return myRules.getValidMoves();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return color == that.color && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public String toString() {
        String t;

        // get the first (or second) letter of the piecetype
        if (type == PieceType.KNIGHT) {
            t = type.toString().substring(1, 2);
        } else {
            t = type.toString().substring(0, 1);
        }

        // return as lowercase for black pieces; leave as uppercase for white pieces
        if (color == ChessGame.TeamColor.BLACK) {
            return t.toLowerCase();
        } else { return t; }
    }
}
