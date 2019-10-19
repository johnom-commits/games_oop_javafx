package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws IllegalStateException {
//        throw new IllegalStateException(
//                String.format("Could not way by diagonal from %s to %s", source, dest)
//        );
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not way by diagonal from %s to %s", source, dest));
        }

        int size = abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : -1;
        for (int index = 0; index < steps.length; index++) {
            int i = (source.x + (index + 1) * deltaX) * 8 + source.y + (index + 1) * deltaY;
            steps[index] = Cell.values()[i];
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(dest.x - source.x) == abs(dest.y - source.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
