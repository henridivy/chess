package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightRule extends PieceRule {


    public KnightRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getValidMoves() {
        Collection<ChessMove> validMoves = new ArrayList<>();

        for (var ending : getPossibleEndings()) {
            if (board.inBounds(ending)) {
                if (!occupiedByFriend(ending)) {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return validMoves;
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