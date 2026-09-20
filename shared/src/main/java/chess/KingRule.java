package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingRule extends PieceRule {

    public KingRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.KING;
    }

    @Override
    public Collection<ChessMove> getValidMoves() {

        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition[] possibleEndings = getPossibleEndings();

        for (var ending : possibleEndings) {
            if (board.inBounds(ending)) {
                if (notOccupiedFriend(ending)) { // no friend = always valid, so add move
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return validMoves;
    }

    @Override
    protected ChessPosition[] getPossibleEndings() {
        int r = starting.getRow();
        int c = starting.getColumn();

        return new ChessPosition[]{
                new ChessPosition(r + 1, c + 1),
                new ChessPosition(r + 1, c),
                new ChessPosition(r + 1, c - 1),
                new ChessPosition(r, c + 1),
                new ChessPosition(r, c - 1),
                new ChessPosition(r - 1, c + 1),
                new ChessPosition(r - 1, c),
                new ChessPosition(r - 1, c - 1)
        };
    }
}
