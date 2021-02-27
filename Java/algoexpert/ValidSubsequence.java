package algoexpert;

import java.util.Iterator;
import java.util.List;

/*
  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.

  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4] form a subsequence of the array
  [1, 2, 3, 4], and so do the numbers [2, 4]. Note
  that a single number in an array and the array itself are both valid
  subsequences of the array.
 */
public class ValidSubsequence {
    // o(n) time | o(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;
        int arrIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

    // o(n) time | o(1) space
    public static boolean isValidSubsequenceAlternative(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;
        for (int i : array) {
            if (seqIdx == sequence.size()) {
                break;
            }
            if (array.get(i).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
        }
        return seqIdx == sequence.size();
    }

    // o(n^2) time | o(1) space
    public static boolean isValidSubsequenceOwnTrial(List<Integer> array, List<Integer> sequence) {
        if (array.size() >= sequence.size()) {
            Iterator seqitr = sequence.iterator();
            Iterator arritr = array.iterator();
            while (seqitr.hasNext()) {
                int currVal = (int) seqitr.next();
                boolean found = false;
                while (arritr.hasNext()) {
                    int currAttrVal = (int) arritr.next();
                    if (currVal == currAttrVal) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
