package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingRule extends PieceRule {

    public KingRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getPieceMoves() {
        Collection<ChessMove> pieceMoves = new ArrayList<>();

        for (var ending : getPossibleEndings()) {
            if (board.inBounds(ending)) {
                if (!occupiedByFriend(ending)) { // no friend = always valid, so add move
                    pieceMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return pieceMoves;
    }

    @Override
    protected ChessPosition[] getPossibleEndings() {
        return new ChessPosition[]{
                new ChessPosition(r + 1, c - 1),
                new ChessPosition(r + 1, c),
                new ChessPosition(r + 1, c + 1),
                new ChessPosition(r, c - 1),
                new ChessPosition(r, c + 1),
                new ChessPosition(r - 1, c - 1),
                new ChessPosition(r - 1, c),
                new ChessPosition(r - 1, c + 1)
        };
    }
}