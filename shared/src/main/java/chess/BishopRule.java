package chess;

import java.util.ArrayList;
import java.util.Collection;

public class BishopRule extends PieceRule {

    public BishopRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
    }

    @Override
    public Collection<ChessMove> getValidMoves() {

        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending;
        int i;

        // top right
        i = 1;
        ending = new ChessPosition(r + i, c + i);
        while (board.inBounds(ending)) {
            if (!occupiedByFriend(ending)) {                        // no friend = valid, so add moves
                validMoves.add(new ChessMove(starting, ending));
                if (!occupiedByEnemy(ending)) {                     // no enemy = empty, so update and continue checking
                    i++;
                    ending = new ChessPosition(r + i, c + i);
                } else { break; }                                   // yes enemy = blocked, so stop checking; move was already added
            } else { break; }                                       // yes friend = blocked, so stop checking; move was never added
        }

        // bottom right
        i = 1;
        ending = new ChessPosition(r - i, c + i);
        while (board.inBounds(ending)) {
            if (!occupiedByFriend(ending)) {
                validMoves.add(new ChessMove(starting, ending));
                if (!occupiedByEnemy(ending)) {
                    i++;
                    ending = new ChessPosition(r - i, c + i);
                } else { break; }
            } else { break; }
        }

        // bottom left
        i = 1;
        ending = new ChessPosition(r - i, c - i);
        while (board.inBounds(ending)) {
            if (!occupiedByFriend(ending)) {
                validMoves.add(new ChessMove(starting, ending));
                if (!occupiedByEnemy(ending)) {
                    i++;
                    ending = new ChessPosition(r - i, c - i);
                } else { break; }
            } else { break; }
        }

        // top left
        i = 1;
        ending = new ChessPosition(r + i, c - i);
        while (board.inBounds(ending)) {
            if (!occupiedByFriend(ending)) {
                validMoves.add(new ChessMove(starting, ending));
                if (!occupiedByEnemy(ending)) {
                    i++;
                    ending = new ChessPosition(r + i, c - i);
                } else { break; }
            } else { break; }
        }

        return validMoves;
    }
}