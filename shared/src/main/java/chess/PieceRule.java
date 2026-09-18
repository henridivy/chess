package chess;

import java.util.Collection;

public abstract class PieceRule {

    protected ChessBoard board;
    protected ChessPosition starting;
    protected ChessPiece.PieceType type;

    public PieceRule(ChessBoard board, ChessPosition starting) {
        this.board = board;
        this.starting = starting;
    }

    abstract Collection<ChessMove> getValidMoves();

}
