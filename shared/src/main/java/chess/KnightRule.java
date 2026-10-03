package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightRule extends PieceRule {


    public KnightRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getPieceMoves() {
        Collection<ChessMove> pieceMoves = new ArrayList<>();

        for (var ending : getPossibleEndings()) {
            if (board.inBounds(ending)) {
                if (!occupiedByFriend(ending)) {
                    pieceMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return pieceMoves;
    }

    @Override
    protected ChessPosition[] getPossibleEndings() {
        return new ChessPosition[]{
                new ChessPosition(r + 1, c + 2),
                new ChessPosition(r + 1, c - 2),
                new ChessPosition(r + 2, c + 1),
                new ChessPosition(r + 2, c - 1),
                new ChessPosition(r - 1, c + 2),
                new ChessPosition(r - 1, c - 2),
                new ChessPosition(r - 2, c + 1),
                new ChessPosition(r - 2, c - 1)
        };
    }
}