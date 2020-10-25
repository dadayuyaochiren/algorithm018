/**
 * 合并两个有序数组
 */
public class HomeWork6 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 解体要素 从后往前 进行赋值
        // 建立指针
        int mlen = m - 1;
        int nlen = n - 1;
        int len = m + n - 1;
        while(mlen >= 0 && nlen >= 0) {
            nums1[len--] = nums1[mlen]  > nums2[nlen] ? nums1[mlen--] : nums2[nlen--];
        }
        if (nlen >= 0){
            for(int i = 0; i<=nlen ; i++){
                nums1[i] = nums2[i];
            }
        }

    }
}
