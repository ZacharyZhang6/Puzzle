package flood;

import java.util.Random;

import static flood.Utils.*;

/** A creator of random Flood puzzles.
 *  @author Zachary Zhang
 */
class PuzzleGenerator implements PuzzleSource {

    /** A new PuzzleGenerator whose random-number source is seeded
     *  with SEED. */
    PuzzleGenerator(long seed) {
        _random = new Random(seed);
    }

    @Override
    public Model getPuzzle(int width, int height, int ncolors, int extra) {
        int [][] puzzle = new int[height][width];
        for (int [] row: puzzle) {
            for (int column = 0; column < width; column++) {
                row[column] = _random.nextInt(ncolors);
            }
        }
        Model model = new Model(puzzle, ncolors);
        model.setLimit(Solver.movesNeeded(model) + extra);
        return model;
    }

    @Override
    public void setSeed(long seed) {
        _random.setSeed(seed);
    }

    /** My PNRG. */
    private Random _random;

}
