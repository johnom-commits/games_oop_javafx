package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void checkPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E3);
        Cell pos = bishopBlack.position();
        assertThat(pos, is(Cell.E3));
    }

    @Test
    public void checkCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure figure = bishopBlack.copy(Cell.E3);
        assertThat(figure.position(), is(Cell.E3));
    }

    @Test
    public void checkWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expected));
    }

    @Test
    public void checkIsDiagonale() {
        String result = "";
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.C1, Cell.E2);
        } catch (IllegalStateException e) {
            result = e.getClass().getName();
        }
        assertThat(result, is("java.lang.IllegalStateException"));
    }
}
