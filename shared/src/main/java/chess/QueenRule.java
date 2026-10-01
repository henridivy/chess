package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenRule extends PieceRule {

    public QueenRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getValidMoves() {
        Collection<ChessMove> validMoves = new ArrayList<>();

        BishopRule bishopRule = new BishopRule(board, color, starting);
        RookRule rookRule = new RookRule(board, color, starting);

        validMoves.addAll(bishopRule.getValidMoves());
        validMoves.addAll(rookRule.getValidMoves());

        return validMoves;
    }
}