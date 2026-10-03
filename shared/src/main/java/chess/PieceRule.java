package chess;

import java.util.Collection;

public abstract class PieceRule {

    protected final ChessBoard board;
    protected ChessGame.TeamColor color;
    protected ChessPosition starting;
    // if needing a 'type' variable, create and assign it
    // in the individual piece Rules; but it's currently
    // never called so...

    protected int r;
    protected int c;

    public PieceRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        this.board = board;
        this.color = color;
        this.starting = starting;

        r = starting.getRow();
        c = starting.getColumn();
    }

    public abstract Collection<ChessMove> getPieceMoves();

    protected boolean occupiedByFriend(ChessPosition position) {
        var other = board.getPiece(position);
        if (other != null) {
            return other.getTeamColor() == color;
        }
        return false;
    }

    protected boolean occupiedByEnemy(ChessPosition position) {
        var other = board.getPiece(position);
        if (other != null) {
            return other.getTeamColor() != color;
        }
        return false;
    }

    protected ChessPosition[] getPossibleEndings() {
        return new ChessPosition[]{};
    }
}