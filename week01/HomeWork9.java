/**
 * 加一
 */
public class HomeWork9 {
    public int[] plusOne(int[] digits) {
        int max =digits.length;
        for(int i = max-1;i>=0;i--){
            if (i==0 && digits[i]==9){
                //总结规律 只有类似 9999.. 结果为 1000,不需要扩容
                digits = new int[max+1];
                digits[0]= 1;
                break;
            }
            if (digits[i]!=9){
                digits[i]+=1;
                break;
            }
            if (digits[i]==9)
                digits[i]=0;
        }
        return digits;
    }
}
