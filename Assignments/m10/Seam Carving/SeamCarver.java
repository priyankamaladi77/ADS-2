import java.awt.Color;
public class SeamCarver {
    // create a seam carver object based on the given picture
    Picture pic;
    public SeamCarver(Picture picture) {
        pic = new Picture(picture);
    }
    // current picture
    public Picture picture() {
        return pic;
    }
    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x == 0 || y == 0 || x == pic.width() - 1
            || y == pic.height() - 1) {
            return 1000;
        } 
        Color top = pic.get(x, y - 1);
        Color bottom = pic.get(x, y + 1);
        Color left = pic.get(x - 1, y);
        Color right = pic.get(x + 1, y);
        int redV = top.getRed() - bottom.getRed();
        int greenV = top.getGreen() - bottom.getGreen();
        int blueV = top.getBlue() - bottom.getBlue();
        double vertical = ((redV * redV) + (greenV * greenV)
            + (blueV * blueV));
        int redH = left.getRed() - right.getRed();
        int greenH = left.getGreen() - right.getGreen();
        int blueH = left.getBlue() - right.getBlue();
        double horizontal = ((redH * redH) + (greenH * greenH)
            + (blueH * blueH));
        double energy = Math.sqrt(horizontal + vertical);
        return energy;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return new int[0];
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return new int[0];
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {

    }
}
