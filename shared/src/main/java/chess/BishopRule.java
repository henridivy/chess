package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BishopRule extends PieceRule {

    private ChessGame.TeamColor color;

    public BishopRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, starting);
        this.color = color;
        this.type = ChessPiece.PieceType.BISHOP;
    }

    @Override
    Collection<ChessMove> getValidMoves() {
        List<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending = starting;

        int r = starting.getRow();
        int c = starting.getColumn();

        validMoves.add(new ChessMove(starting, ending));

        return validMoves;
    }
}
