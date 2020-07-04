package tencomalgorithms.kmp.violentmatch;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/26/10:31
 */
public class ViolentMatch {

    @Test
    public void test1() {
        String source = "ajakfjaiejflefjakwnv";
        String target = "jak";
        int i = violentMatchString(source, target);
        System.out.println(i);
    }

    /**
     * @param source 源字符串
     * @param target 目标字符串
     * @return 第一次出现的位置，如果未匹配上则返回-1
     */
    private int violentMatchString(String source, String target) {
        char[] sources = source.toCharArray();
        char[] targets = target.toCharArray();
        int s1Len = sources.length;
        int s2Len = targets.length;
        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (sources[i] == targets[j]) {
                i++;
                j++;
            } else {
                //这个操作很厉害，可以起到i++的作用,如果部分匹配到又可以让i回溯
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
