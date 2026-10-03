package chess;

import java.util.Collection;
import java.util.Objects;

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
        color = pieceColor;
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
    public ChessGame.TeamColor getTeamColor() { return color; }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() { return type; }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        PieceRule myRule;

        if (type == PieceType.BISHOP) { myRule = new BishopRule(board, color, myPosition); }
        else if (type == PieceType.ROOK) { myRule = new RookRule(board, color, myPosition); }
        else if (type == PieceType.QUEEN) { myRule = new QueenRule(board, color, myPosition); }
        else if (type == PieceType.KING) { myRule = new KingRule(board, color, myPosition); }
        else if (type == PieceType.KNIGHT) { myRule = new KnightRule(board, color, myPosition); }
        else { myRule = new PawnRule(board, color, myPosition); }

        return myRule.getPieceMoves();
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

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
        String s;

        // get appropriate letter
        if (type == PieceType.KNIGHT) {
            s = type.toString().substring(1, 2); // second letter
        } else {
            s = type.toString().substring(0, 1); // first letter
        }

        // set appropriate case
        if (color == ChessGame.TeamColor.BLACK) {
            return s.toLowerCase();
        } else {
            return s.toUpperCase();
        }
    }
}