package chess;

import java.util.ArrayList;
import java.util.Collection;

public class RookRule extends PieceRule {

    public RookRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.ROOK;
    }

    @Override
    public Collection<ChessMove> getValidMoves() {

        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending;

        int r = starting.getRow();
        int c = starting.getColumn();
        int i;

        // up
        i = 1;
        ending = new ChessPosition(r + i, c);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r + i, c);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // right
        i = 1;
        ending = new ChessPosition(r, c + i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r, c + i);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // down
        i = 1;
        ending = new ChessPosition(r - i, c);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r - i, c);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // left
        i = 1;
        ending = new ChessPosition(r, c - i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r, c - i);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        return validMoves;
    }
}
