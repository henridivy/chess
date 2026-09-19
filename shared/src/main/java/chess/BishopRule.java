package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BishopRule extends PieceRule {

    public BishopRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.BISHOP;
    }

    @Override
    public Collection<ChessMove> getValidMoves() {
        List<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending;

        int r = starting.getRow();
        int c = starting.getColumn();
        int i;

        // top right
        i = 1;
        ending = new ChessPosition(r + i, c + i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r + i, c + i);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // bottom right
        i = 1;
        ending = new ChessPosition(r - i, c + i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r - i, c + i);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // bottom left
        i = 1;
        ending = new ChessPosition(r - i, c - i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r - i, c - i);
                } else { // yes enemy = blocked, so stop checking; move already added
                    break;
                }
            } else { // yes friend = blocked, so stop checking; move was never added
                break;
            }
        }

        // top left
        i = 1;
        ending = new ChessPosition(r + i, c - i);
        while (board.inBounds(ending)) {
            if (notOccupiedFriend(ending)) { // no friend = valid, so add move
                validMoves.add(new ChessMove(starting, ending));
                if (notOccupiedEnemy(ending)) { // no enemy = empty, so continue checking; while loop continues
                    i++;
                    ending = new ChessPosition(r + i, c - i);
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
