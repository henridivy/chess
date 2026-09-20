package chess;

import java.util.Collection;

public abstract class PieceRule {

    protected static ChessBoard board;
    protected ChessPosition starting;
    protected ChessPiece.PieceType type;
    protected ChessGame.TeamColor color;

    public PieceRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        PieceRule.board = board;
        this.starting = starting;
        this.color = color;
    }

    public abstract Collection<ChessMove> getValidMoves();

    public boolean notOccupiedFriend(ChessPosition position) {
        if (position.isOccupied(board)) {
            ChessPiece otherPiece = board.getPiece(position);
            return otherPiece.getTeamColor() != color; // occupied by friend
        }
        return true;
    }

    public boolean notOccupiedEnemy(ChessPosition position) {
        if (position.isOccupied(board)) {
            ChessPiece otherPiece = board.getPiece(position);
            return otherPiece.getTeamColor() == color; // occupied by enemy
        }
        return true;
    }

    protected ChessPosition[] getPossibleEndings() {
        return new ChessPosition[]{};
    }
}
