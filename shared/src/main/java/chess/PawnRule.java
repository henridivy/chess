package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnRule extends PieceRule {

    private final int i;  // direction
    private boolean hasMoved = false;

    public PawnRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);

        if (color == ChessGame.TeamColor.BLACK) {
            i = -1; // black pawns move down
            if (r != 7) { hasMoved = true; }
        } else {
            i = 1; // white pawns move up
            if (r != 2) { hasMoved = true; }
        }
    }

    private boolean promotable(ChessPosition ending) {
        if (color == ChessGame.TeamColor.BLACK) {
            return (ending.getRow() == 1);
        }
        return (ending.getRow() == 8);
    }

    private void addWithPromotion(Collection<ChessMove> validMoves, ChessPosition starting, ChessPosition ending) {
        validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.BISHOP));
        validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.ROOK));
        validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.KNIGHT));
        validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.QUEEN));
    }

    @Override
    public Collection<ChessMove> getValidMoves() {
        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending;
        var endings = getPossibleEndings();

        // move forward one (valid = and empty)
        // note: no need to check if in bounds because these will ALWAYS be in bounds
        ending = endings[0];
        if (ending.isEmpty(board)) {
            if (promotable(ending)) {
                addWithPromotion(validMoves, starting, ending);
            } else {
                validMoves.add(new ChessMove(starting, ending));
            }

            // move forward two (valid = hasn't moved, and empty)
            ending = endings[1];
            if (!hasMoved) {
                if (ending.isEmpty(board)) {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        // capture left (valid = in bounds and enemy)
        ending = endings[2];
        if (board.inBounds(ending)) {
            if (occupiedByEnemy(ending)) {
                if (promotable(ending)) {
                    addWithPromotion(validMoves, starting, ending);
                } else {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        // capture right (valid = in bounds and enemy)
        ending = endings[3];
        if (board.inBounds(ending)) {
            if (occupiedByEnemy(ending)) {
                if (promotable(ending)) {
                    addWithPromotion(validMoves, starting, ending);
                } else {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return validMoves;
    }


    @Override
    protected ChessPosition[] getPossibleEndings() {
        return new ChessPosition[]{
                new ChessPosition(r + i, c),            // move forward one
                new ChessPosition(r + i + i, c),        // move forward two
                new ChessPosition(r + i, c - i),    // capture left
                new ChessPosition(r + i, c + i)     // capture right
        };
    }
}