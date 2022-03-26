package lab3.java;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageTag implements Comparable<ImageTag> {

    private String tag;
    private int width;
    private int height;

    @Override
    public int compareTo(ImageTag o) {
        return this.getHeight() + this.getWidth() > o.getWidth() + o.getHeight() ? 1 : 0;
    }
}
