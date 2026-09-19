package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightRule extends PieceRule {

    public KnightRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.ROOK;
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

    private ChessPosition[] getPossibleEndings() {
        int r = starting.getRow();
        int c = starting.getColumn();

        return new ChessPosition[]{
                new ChessPosition(r + 1, c + 2),
                new ChessPosition(r + 1, c - 2),
                new ChessPosition(r - 1, c + 2),
                new ChessPosition(r - 1, c - 2),
                new ChessPosition(r + 2, c + 1),
                new ChessPosition(r + 2, c - 1),
                new ChessPosition(r - 2, c + 1),
                new ChessPosition(r - 2, c - 1)
        };
    }
}
