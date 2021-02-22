package utils.diff;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hyq on 2021/2/20 11:46.
 */
public class ComputeDifference {
    public static void main(String[] args) {
        List<String> original = Arrays.asList("This is a test senctence.", "This is the second line.", "And here is the finish.");
        List<String> revised = Arrays.asList("This is a test for diffutils.", "This is the second line.");

        //compute the patch: this is the diffutils part
        Patch<String> patch = DiffUtils.diff(original, revised);

        //simple output the computed patch to console
        for (AbstractDelta<String> delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }
}
