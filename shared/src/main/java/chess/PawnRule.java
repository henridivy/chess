package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnRule extends PieceRule {

    private final int i;
    private boolean hasMoved = false;

    public PawnRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.PAWN;

        if (color == ChessGame.TeamColor.BLACK) {
            i = -1; // black pawns move down
            if (starting.getRow() != 7) { hasMoved = true; }
        } else {
            i = 1; // white pawns move up
            if (starting.getRow() != 2) { hasMoved = true; }
        }
    }

    @Override
    public Collection<ChessMove> getValidMoves() {

        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition ending;

        ChessPosition[] possibleEndings = getPossibleEndings();

        // move forward one
        ending = possibleEndings[0];
        if (board.inBounds(ending)) {
            if (notOccupiedFriend(ending) && notOccupiedEnemy(ending)) { // empty = valid, so add move
                if (promotable(ending)) {
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.BISHOP));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.QUEEN));
                } else { validMoves.add(new ChessMove(starting, ending)); }
                // move forward two; only possible if can move forward one; no promotion needed
                ending = possibleEndings[1];
                if (!hasMoved) {
                    if (board.inBounds(ending)) {
                        if (notOccupiedFriend(ending) && notOccupiedEnemy(ending)) { // empty = valid, so add move
                            validMoves.add(new ChessMove(starting, ending));
                        }
                    }
                }
            }
        }

        // capture left
        ending = possibleEndings[2];
        if (board.inBounds(ending)) {
            if (!notOccupiedEnemy(ending)) {    // enemy = valid, so add move
                if (promotable(ending)) {
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.BISHOP));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.QUEEN));
                } else {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        // capture right
        ending = possibleEndings[3];
        if (board.inBounds(ending)) {
            if (!notOccupiedEnemy(ending)) {
                if (promotable(ending)) {   // enemy = valid, so add move
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.BISHOP));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(starting, ending, ChessPiece.PieceType.QUEEN));
                } else {
                    validMoves.add(new ChessMove(starting, ending));
                }
            }
        }

        return validMoves;
    }

    private boolean promotable(ChessPosition position) {
        return (position.getRow() == 1 ||
                position.getRow() == 8);
    }

    @Override
    protected ChessPosition[] getPossibleEndings() {
        int r = starting.getRow();
        int c = starting.getColumn();

        return new ChessPosition[]{
                new ChessPosition(r + i, c),            // [0] = move forward one
                new ChessPosition(r + i + i, c),        // [1] = move forward two
                new ChessPosition(r + i, c - i),    // [2] = capture to pawn's left
                new ChessPosition(r + i, c + i)     // [3] = capture to pawn's right
        };
    }
}
