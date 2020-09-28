import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wz
 * @Date: 2020-09-15
 */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] newarr = new int[m+n];
            int p = 0, q = 0;
            while (p <= m || q <= n) {
                for (int i=0; i<m+n; i++) {
                    if (nums1[p] < nums2[q]) {
                        newarr[i] = nums1[p];
                    } else {
                        newarr[i] = nums1[q];
                    }
                }
            }
            if (p > m && q <= n) {
                for (int i=m+q; i<m+n; i++) {
                    newarr[i] = nums2[i-m];
                }
            }
            if (q > n && p <= m) {
                for (int i=p+n; i<m+n; i++) {
                    newarr[i] = nums1[i-n];
                }
            }
        }
    }
