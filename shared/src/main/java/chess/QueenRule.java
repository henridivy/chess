package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenRule extends PieceRule {

    public QueenRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getPieceMoves() {
        Collection<ChessMove> pieceMoves = new ArrayList<>();

        BishopRule bishopRule = new BishopRule(board, color, starting);
        RookRule rookRule = new RookRule(board, color, starting);

        pieceMoves.addAll(bishopRule.getPieceMoves());
        pieceMoves.addAll(rookRule.getPieceMoves());

        return pieceMoves;
    }
}